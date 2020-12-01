package com.codecool.hp_backend.controller;

import com.codecool.hp_backend.entity.HPUser;
import com.codecool.hp_backend.service.DataHandler;
import com.codecool.hp_backend.service.DataHandlerDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class AuthController {

    private final DataHandler dataHandler;

    @Autowired
    public AuthController(@Qualifier("dataHandlerDB") DataHandler dataHandler) {
        this.dataHandler = dataHandler;
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
        dataHandler.saveUser(hpUser);
        return ResponseEntity.ok("Registration successful!");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(HPUser hpUser) {
        System.out.println("username: " + hpUser.getUsername() + "; password: " + hpUser.getPassword());
        return ResponseEntity.ok("You are logged in!");
    }

}
