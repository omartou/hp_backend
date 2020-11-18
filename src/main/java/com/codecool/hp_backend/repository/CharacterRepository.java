package com.codecool.hp_backend.repository;

import com.codecool.hp_backend.entity.Character;
import com.codecool.hp_backend.entity.House;
import com.codecool.hp_backend.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CharacterRepository extends JpaRepository<Character, Long> {

//    @Query("SELECT c.id,\n" +
//            "       c.name,\n" +
//            "       c.role,\n" +
//            "       h.name AS house,\n" +
//            "       s.name AS school,\n" +
//            "       c.ministryOfMagics,\n" +
//            "       c.orderOfPhoenix,\n" +
//            "       c.dumbledoresArmy,\n" +
//            "       bs.name AS blood_status,\n" +
//            "       c.deathEater,\n" +
//            "       sp.name AS species,\n" +
//            "       c.boggart,\n" +
//            "       c.alias,\n" +
//            "       c.wand,\n" +
//            "       c.patronus,\n" +
//            "       a.name AS animagus\n" +
//            "FROM Character c\n" +
//            "    LEFT JOIN House h on h = c.house\n" +
//            "    LEFT JOIN School s on s = c.school\n" +
//            "    LEFT JOIN BloodStatus bs on bs = c.bloodStatus\n" +
//            "    LEFT JOIN Species sp on sp = c.species\n" +
//            "    LEFT JOIN Animagus a ON a = c.animagus\n" +
//            "WHERE h.name = :name")
@Query("SELECT c\n" +
        "FROM Character c\n" +
        "    LEFT JOIN House h on h = c.house\n" +
        "    LEFT JOIN School s on s = c.school\n" +
        "    LEFT JOIN BloodStatus bs on bs = c.bloodStatus\n" +
        "    LEFT JOIN Species sp on sp = c.species\n" +
        "    LEFT JOIN Animagus a ON a = c.animagus\n" +
        "WHERE h.name = :name")
    List<Character> getCharactersByHouseName(@Param("name") String name);

    List<Character> getCharactersByHouse(House house);

    List<Character> getCharactersByRoleContaining(String professor);

    List<Character> getCharactersByMinistryOfMagicsIsTrue();

    List<Character> getCharactersByMinistryOfMagicsIsFalseAndSchoolIsNullOrSchoolNameNotContains(String school);

    Character getCharacterById(Long id);
}
