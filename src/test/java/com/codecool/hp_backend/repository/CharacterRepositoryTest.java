package com.codecool.hp_backend.repository;

import com.codecool.hp_backend.entity.Character;
import com.codecool.hp_backend.entity.House;
import com.codecool.hp_backend.entity.School;
import net.bytebuddy.asm.Advice;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
class CharacterRepositoryTest {

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    private SchoolRepository schoolRepository;


    @Test
    void getCharactersByHouseOrderByName() {
        House house1 = House.builder()
                .name("House1")
                .build();

        Character character = Character.builder()
                .name("B Character")
                .house(house1)
                .ministryOfMagics(false)
                .orderOfPhoenix(false)
                .dumbledoresArmy(false)
                .deathEater(false)
                .build();

        Character character2 = Character.builder()
                .name("A Character")
                .house(house1)
                .ministryOfMagics(false)
                .orderOfPhoenix(false)
                .dumbledoresArmy(false)
                .deathEater(false)
                .build();

        Character character3 = Character.builder()
                .name("C Character")
                .ministryOfMagics(false)
                .orderOfPhoenix(false)
                .dumbledoresArmy(false)
                .deathEater(false)
                .build();

        houseRepository.save(house1);
        characterRepository.saveAll(Lists.newArrayList(character, character2, character3));
        List<Character> characterList = characterRepository.getCharactersByHouseOrderByName(house1);
        assertThat(characterList)
                .hasSize(2)
                .containsExactly(character2, character);
    }

    @Test
    void getCharactersByRoleContainingOrderByName() {
        Character character = Character.builder()
                .name("B Character")
                .role("Professor of wizard")
                .ministryOfMagics(false)
                .orderOfPhoenix(false)
                .dumbledoresArmy(false)
                .deathEater(false)
                .build();

        Character character2 = Character.builder()
                .name("A Character")
                .role("Spring Professor")
                .ministryOfMagics(false)
                .orderOfPhoenix(false)
                .dumbledoresArmy(false)
                .deathEater(false)
                .build();

        Character character3 = Character.builder()
                .name("C Character")
                .role("Student of Hogwarts")
                .ministryOfMagics(false)
                .orderOfPhoenix(false)
                .dumbledoresArmy(false)
                .deathEater(false)
                .build();

        characterRepository.saveAll(Lists.newArrayList(character, character2, character3));

        List<Character> professors = characterRepository.getCharactersByRoleContainingOrderByName("Professor");
        assertThat(professors)
                .hasSize(2)
                .containsExactly(character2, character);
    }

    @Test
    void getCharactersByMinistryOfMagicsIsTrueOrderByName() {
        Character character = Character.builder()
                .name("B Character")
                .ministryOfMagics(true)
                .orderOfPhoenix(false)
                .dumbledoresArmy(false)
                .deathEater(false)
                .build();

        Character character2 = Character.builder()
                .name("A Character")
                .ministryOfMagics(true)
                .orderOfPhoenix(false)
                .dumbledoresArmy(false)
                .deathEater(false)
                .build();

        Character character3 = Character.builder()
                .name("C Character")
                .ministryOfMagics(false)
                .orderOfPhoenix(false)
                .dumbledoresArmy(false)
                .deathEater(false)
                .build();

        characterRepository.saveAll(Lists.newArrayList(character, character2, character3));
        List<Character> isMinistryOfMagic = characterRepository.getCharactersByMinistryOfMagicsIsTrueOrderByName();

        assertThat(isMinistryOfMagic)
                .hasSize(2)
                .containsExactly(character2, character);

    }

    @Test
    void getCharactersByMinistryOfMagicsIsFalseAndSchoolIsNullOrSchoolNameNotContainsOrderByName() {
        School school = School.builder()
                .name("Hogwarts School")
                .build();

        School school2 = School.builder()
                .name("Codecool")
                .build();

        Character character = Character.builder()
                .name("B Character")
                .ministryOfMagics(false)
                .orderOfPhoenix(false)
                .dumbledoresArmy(false)
                .deathEater(false)
                .build();

        Character character2 = Character.builder()
                .name("A Character")
                .ministryOfMagics(false)
                .school(school)
                .orderOfPhoenix(false)
                .dumbledoresArmy(false)
                .deathEater(false)
                .build();

        Character character3 = Character.builder()
                .name("C Character")
                .ministryOfMagics(true)
                .orderOfPhoenix(false)
                .dumbledoresArmy(false)
                .deathEater(false)
                .build();

        Character character4 = Character.builder()
                .name("D Character")
                .ministryOfMagics(true)
                .school(school2)
                .orderOfPhoenix(false)
                .dumbledoresArmy(false)
                .deathEater(false)
                .build();

        schoolRepository.saveAll(Lists.newArrayList(school, school2));
        characterRepository.saveAll(Lists.newArrayList(character, character2, character3, character4));

        List<Character> characterList = characterRepository.getCharactersByMinistryOfMagicsIsFalseAndSchoolIsNullOrSchoolNameNotContainsOrderByName("Codecool");

        assertThat(characterList)
                .hasSize(2)
                .containsExactly(character2, character);
    }

    @Test
    void getCharacterById() {
        Character character = Character.builder()
                .name("B Character")
                .ministryOfMagics(false)
                .orderOfPhoenix(false)
                .dumbledoresArmy(false)
                .deathEater(false)
                .build();

        Character character2 = Character.builder()
                .name("A Character")
                .ministryOfMagics(false)
                .orderOfPhoenix(false)
                .dumbledoresArmy(false)
                .deathEater(false)
                .build();

        Character character3 = Character.builder()
                .name("C Character")
                .ministryOfMagics(true)
                .orderOfPhoenix(false)
                .dumbledoresArmy(false)
                .deathEater(false)
                .build();

        characterRepository.saveAll(Lists.newArrayList(character, character2, character3));

        Character returnedCharacter = characterRepository.getCharacterById(2L);
        System.out.println(returnedCharacter.getId());
        assertEquals(2L, returnedCharacter.getId());
    }

    @Test
    void getCharactersByHouseIsNotNullOrderByName() {
        House house1 = House.builder()
                .name("House1")
                .build();

        House house2 = House.builder()
                .name("House2")
                .build();

        Character character = Character.builder()
                .name("B Character")
                .house(house1)
                .ministryOfMagics(false)
                .orderOfPhoenix(false)
                .dumbledoresArmy(false)
                .deathEater(false)
                .build();

        Character character2 = Character.builder()
                .name("A Character")
                .house(house2)
                .ministryOfMagics(false)
                .orderOfPhoenix(false)
                .dumbledoresArmy(false)
                .deathEater(false)
                .build();

        Character character3 = Character.builder()
                .name("C Character")
                .ministryOfMagics(false)
                .orderOfPhoenix(false)
                .dumbledoresArmy(false)
                .deathEater(false)
                .build();

        houseRepository.saveAll(Lists.newArrayList(house1, house2));
        characterRepository.saveAll(Lists.newArrayList(character, character2, character2));

        List<Character> characterList = characterRepository.getCharactersByHouseIsNotNullOrderByName();

        assertThat(characterList)
                .hasSize(2)
                .containsExactly(character2, character);
    }


    @BeforeEach
    private void flushBeforeEach() {
        characterRepository.deleteAll();
        houseRepository.deleteAll();
    }
}

