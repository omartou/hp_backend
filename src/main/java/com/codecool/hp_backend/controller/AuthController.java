package com.codecool.hp_backend.controller;

import com.codecool.hp_backend.entity.HPUser;
import com.codecool.hp_backend.security.JwtTokenServices;
import com.codecool.hp_backend.service.DataHandler;
import com.codecool.hp_backend.service.DataHandlerDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@CrossOrigin
public class AuthController {

    private final DataHandler dataHandler;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenServices jwtTokenServices;

    @Autowired
    public AuthController(@Qualifier("dataHandlerDB") DataHandler dataHandler,
                          AuthenticationManager authenticationManager,
                          JwtTokenServices jwtTokenServices) {
        this.dataHandler = dataHandler;
        this.passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        this.authenticationManager = authenticationManager;
        this.jwtTokenServices = jwtTokenServices;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody HPUser hpUser) {
        System.out.println(hpUser);
        System.out.println("username: " + hpUser.getUsername() + "; password: " + hpUser.getPassword());
        if(dataHandler.checkIfUsernameExists(hpUser.getUsername())){
            return ResponseEntity.ok("Username already in use!");
        }else if(dataHandler.checkIfEmailExists(hpUser.getEmail())){
            return ResponseEntity.ok("Email already in use!");
        }
        hpUser.setPassword(passwordEncoder.encode(hpUser.getPassword()));
        dataHandler.saveUser(hpUser);
        return ResponseEntity.ok("Registration successful!");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody HPUser hpUser, HttpServletResponse response) {
        try {
            System.out.println("username: " + hpUser.getUsername() + "; password: " + hpUser.getPassword());
            String userName = hpUser.getUsername();
            String password = hpUser.getPassword();
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
            List<String> roles = authentication.getAuthorities()
                    .stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());

            String token = jwtTokenServices.createToken(userName, roles);

            System.out.println(token);

            Cookie tokenCookie = new Cookie("token", token);
//            tokenCookie.setHttpOnly(true);
//            tokenCookie.setSecure(true);
            tokenCookie.setPath("/");

            response.addCookie(tokenCookie);

            return ResponseEntity.ok("Login successful!");

        } catch (AuthenticationException e) {
            return ResponseEntity.ok("Invalid username or password!");
        }
        /*
        if (!dataHandler.checkIfUsernameExists(userName)) {
            return ResponseEntity.ok("Invalid username of password!");
        }

        HPUser registeredUser = dataHandler.getHpUserByName(userName);
        if (registeredUser.getUsername().equals(userName) && registeredUser.getPassword().equals(password)) {
            return ResponseEntity.ok("Login successful!");
        }

        return ResponseEntity.ok("Invalid username of password!"); */
    }

}
