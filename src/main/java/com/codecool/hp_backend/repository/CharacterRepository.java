package com.codecool.hp_backend.repository;

import com.codecool.hp_backend.entity.Character;
import com.codecool.hp_backend.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CharacterRepository extends JpaRepository<Character, Long> {

    List<Character> getCharactersByHouseOrderByName(House house);

    List<Character> getCharactersByRoleContainingOrderByName(String professor);

    List<Character> getCharactersByMinistryOfMagicsIsTrueOrderByName();

    List<Character> getCharactersByMinistryOfMagicsIsFalseAndSchoolIsNullOrSchoolNameNotContainsOrderByName(String school);

    Character getCharacterById(Long id);

    List<Character> getCharactersByHouseIsNotNullOrderByName();

}
