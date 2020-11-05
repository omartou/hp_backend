package com.codecool.hp_backend.service;

import static org.junit.jupiter.api.Assertions.*;

import com.codecool.hp_backend.model.generated.PotterCharacter;
import java.util.ArrayList;
import java.util.List;
import javax.xml.crypto.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.Test;

class DataHandlerTest {

    private static CharacterStorage characterStorage;
    private static DataHandler dataHandler;
    private final List<PotterCharacter> characters = new ArrayList<>();
    
    @BeforeEach
    void init() {
        characters.add(new PotterCharacter("human", "Harry Potter", "0", "Gryffindor",
                "Hogwarts School of Witchcraft and Wizardry"));
        characters.add(new PotterCharacter("human", "Draco Malfoy", "1", "Slytherin",
                "Hogwarts School of Witchcraft and Wizardry"));
        characters.add(new PotterCharacter("ghost", "Bloody Baron", "2", "Slytherin",
                "Hogwarts School of Witchcraft and Wizardry"));
        characters.add(new PotterCharacter("human", "Alecto Carrow", "4", null,
                "Professor, Muggle Studies", "Hogwarts School of Witchcraft and Wizardry"));
        characters
                .add(new PotterCharacter("Beauxbatons Academy of Magic", "Fleur Delacour", false));
        characters.add(new PotterCharacter("Hogwarts School of Witchcraft and Wizardry",
                "Albus Dumbledore", true));
        characterStorage = mock(CharacterStorage.class);
        when(characterStorage.getCharacterList()).thenReturn(characters);
        dataHandler = new DataHandler(characterStorage);
    }

    @Test
    void getHogwartsHouseCharactersReturnsMatchingCharacters() {
        List<PotterCharacter> houseCharacterList = new ArrayList<>();
        houseCharacterList.add(new PotterCharacter("human", "Draco Malfoy", "1", "Slytherin",
                "Hogwarts School of Witchcraft and Wizardry"));
        houseCharacterList.add(new PotterCharacter("ghost", "Bloody Baron", "2", "Slytherin",
                "Hogwarts School of Witchcraft and Wizardry"));
        assertEquals(houseCharacterList.size(),
                dataHandler.getHogwartsHouseCharacters("Slytherin").size());
        assertEquals(houseCharacterList.get(0).getName(),
                dataHandler.getHogwartsHouseCharacters("Slytherin").get(0).getName());
    }

    @Test
    void getHogwartsEmployeesReturnsMatchingCharacters() {
        List<PotterCharacter> employeeCharacterList = new ArrayList<>();

        employeeCharacterList.add(new PotterCharacter("human", "Alecto Carrow", "4", null,
                "Professor, Muggle Studies", "Hogwarts School of Witchcraft and Wizardry"));

        assertEquals(employeeCharacterList.get(0).getName(),
                dataHandler.getHogwartsEmployees().get(0).getName());
    }

    @Test
    void getOtherCharacters() {
        List<PotterCharacter> otherCharacterList = new ArrayList<>();

        otherCharacterList
                .add(new PotterCharacter("Beauxbatons Academy of Magic", "Fleur Delacour", false));

        assertEquals(otherCharacterList.get(0).getName(),
                dataHandler.getOtherCharacters().get(0).getName());
    }

    @Test
    void getMinistryOfMagicCharacters() {
        List<PotterCharacter> ministryCharacterList = new ArrayList<>();

        ministryCharacterList
                .add(new PotterCharacter("Hogwarts School of Witchcraft and Wizardry",
                        "Albus Dumbledore", true));

        assertEquals(ministryCharacterList.get(0).getName(),
                dataHandler.getMinistryOfMagicCharacters().get(0).getName());
    }

    @Test
    void getCharacterById() {
    }

    @Test
    void getRandomHouseQuizCharacter() {
    }
}