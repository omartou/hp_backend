package com.codecool.hp_backend.repository;

import com.codecool.hp_backend.entity.*;
import com.codecool.hp_backend.entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface CharacterRepository extends JpaRepository<Character, Long> {

    List<Character> getCharactersByHouseOrderByName(House house);

    List<Character> getCharactersByRoleContainingOrderByName(String professor);

    List<Character> getCharactersByMinistryOfMagicsIsTrueOrderByName();

    List<Character> getCharactersByMinistryOfMagicsIsFalseAndSchoolIsNullOrSchoolNameNotContainsOrderByName(String school);

    Character getCharacterById(Long id);

    List<Character> getCharactersByHouseIsNotNullOrderByName();

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Character SET " +
            "user = :newUser, " +
            "name = :newName, " +
            "role = :newRole, " +
            "house = :newHouse, " +
            "school = :newSchool, " +
            "ministryOfMagics = :newMinistryOfMagics, " +
            "orderOfPhoenix = :newOrderOfPhoenix," +
            "dumbledoresArmy = :newDumbledoresArmy, " +
            "bloodStatus = :newBloodStatus, " +
            "deathEater = :newDeathEater, " +
            "species = :newSpecies, " +
            "boggart = :newBoggart, " +
            "alias = :newAlias, " +
            "wand = :newWand, " +
            "patronus = :newPatronus, " +
            "animagus = :newAnimagus " +
            "WHERE id = :id")
    void updateCharacterById(@Param("id") Long id,
                             @Param("newUser") boolean newUser,
                             @Param("newName") String newName,
                             @Param("newRole") String newRole,
                             @Param("newHouse") House newHouse,
                             @Param("newSchool") School newSchool,
                             @Param("newMinistryOfMagics") boolean newMinistryOfMagics,
                             @Param("newOrderOfPhoenix") boolean newOrderOfPhoenix,
                             @Param("newDumbledoresArmy") boolean newDubmledoresArmy,
                             @Param("newBloodStatus") BloodStatus newBloodStatus,
                             @Param("newDeathEater") boolean newDeathEater,
                             @Param("newSpecies") Species newSpecies,
                             @Param("newBoggart") String newBoggart,
                             @Param("newAlias") String newAlias,
                             @Param("newWand") Wand newWand,
                             @Param("newPatronus") String newPatronus,
                             @Param("newAnimagus") Animagus newAnimagus
    );

}
