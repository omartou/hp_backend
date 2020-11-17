package com.codecool.hp_backend.repository;

import com.codecool.hp_backend.entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, Long> {

}
