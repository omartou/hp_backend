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
        characters.add(new PotterCharacter("human", "Harry Potter", "0", "Gryffindor"));
        characters.add(new PotterCharacter("human", "Draco Malfoy", "1", "Slytherin"));
        characters.add(new PotterCharacter("ghost", "Bloody Baron", "2", "Slytherin"));
        characters.add(new PotterCharacter("human", "Alecto Carrow", "4", null,
                "Professor, Muggle Studies"));
        characterStorage = mock(CharacterStorage.class);
        when(characterStorage.getCharacterList()).thenReturn(characters);
        dataHandler = new DataHandler(characterStorage);
    }

    @Test
    void getHogwartsHouseCharactersReturnsMatchingCharacters() {
        List<PotterCharacter> houseCharacterList = new ArrayList<>();
        houseCharacterList.add(new PotterCharacter("human", "Draco Malfoy", "1", "Slytherin"));
        houseCharacterList.add(new PotterCharacter("ghost", "Bloody Baron", "2", "Slytherin"));
        assertEquals(houseCharacterList.size(),
                dataHandler.getHogwartsHouseCharacters("Slytherin").size());
        assertEquals(houseCharacterList.get(0).getName(),
                dataHandler.getHogwartsHouseCharacters("Slytherin").get(0).getName());
    }

    @Test
    void getHogwartsEmployeesReturnsMatchingCharacters() {
        List<PotterCharacter> employeeCharacterList = new ArrayList<>();

        employeeCharacterList.add(new PotterCharacter("human", "Alecto Carrow", "4", null,
                "Professor, Muggle Studies"));

        assertEquals(employeeCharacterList.get(0).getName(),
                dataHandler.getHogwartsEmployees().get(0).getName());
    }

    @Test
    void getOtherCharacters() {
    }

    @Test
    void getMinistryOfMagicCharacters() {
    }

    @Test
    void getCharacterById() {
    }

    @Test
    void getRandomHouseQuizCharacter() {
    }
}