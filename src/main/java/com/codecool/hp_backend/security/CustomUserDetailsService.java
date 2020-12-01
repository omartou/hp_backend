package com.codecool.hp_backend.security;

import com.codecool.hp_backend.entity.HPUser;
import com.codecool.hp_backend.repository.HPUserRepository;
import java.util.stream.Collectors;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private HPUserRepository hpUserRepository;

    public CustomUserDetailsService(HPUserRepository hpUserRepository) {
        this.hpUserRepository = hpUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        HPUser hpUser = hpUserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "Username: " + username + " not found"));
        return new User(hpUser.getUsername(), hpUser.getPassword(),
                hpUser.getRoles().stream().map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList()));
    }
}
