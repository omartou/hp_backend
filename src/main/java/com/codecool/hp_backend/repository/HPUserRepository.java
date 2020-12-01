package com.codecool.hp_backend.repository;

import com.codecool.hp_backend.entity.HPUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HPUserRepository extends JpaRepository<HPUser, Long> {

    boolean existsHPUserByUsername(String username);

    boolean existsHPUserByEmail(String email);
}
