package com.codecool.hp_backend.service;

import static org.junit.jupiter.api.Assertions.*;

import com.codecool.hp_backend.model.generated.PotterCharacter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DataHandlerTest {

    private static CharacterStorage characterStorage;
    private static DataHandler dataHandler;
    private final List<PotterCharacter> characters = new ArrayList<>();

    private static PotterApiService potterApiService;
    private static Map<String, PotterCharacter> charactersTest = new LinkedHashMap<>();

    private final List<PotterCharacter> houseQuizCharacters = new ArrayList<>();


    @BeforeEach
    void init() {
        setupTestWithList();
        setupTestWithHashMap();
//        setupTestForGetRandomHouseQuizCharacter();
    }

//    private void setupTestForGetRandomHouseQuizCharacter() {
//        houseQuizCharacters.add(new PotterCharacter("human", "Harry Potter", "0", "Gryffindor",
//                "Hogwarts School of Witchcraft and Wizardry"));
//        when(dataHandler.getRandomHouseQuizCharacter()).thenReturn(
//                (PotterCharacter) houseQuizCharacters);
//        dataHandler = new DataHandler(characterStorage);
//    }

    private void setupTestWithHashMap() {
        charactersTest.put("0", new PotterCharacter("human", "Harry Potter", "0", "Gryffindor",
                "Hogwarts School of Witchcraft and Wizardry"));
        charactersTest.put("1", new PotterCharacter("human", "Draco Malfoy", "1", "Slytherin",
                "Hogwarts School of Witchcraft and Wizardry"));
        charactersTest.put("2", new PotterCharacter("ghost", "Bloody Baron", "2", "Slytherin",
                "Hogwarts School of Witchcraft and Wizardry"));
        potterApiService = mock(PotterApiService.class);
        when(potterApiService.getAllCharacters()).thenReturn(charactersTest);
        characterStorage = new CharacterStorage(potterApiService);
    }

    private void setupTestWithList() {
        characters.add(new PotterCharacter("human", "Harry Potter", "0", "Gryffindor",
                "Hogwarts School of Witchcraft and Wizardry"));
        characters.add(new PotterCharacter("human", "Draco Malfoy", "1", "Slytherin",
                "Hogwarts School of Witchcraft and Wizardry"));
        characters.add(new PotterCharacter("ghost", "Bloody Baron", "2", "Slytherin",
                "Hogwarts School of Witchcraft and Wizardry"));
        characters.add(new PotterCharacter("human", "Alecto Carrow", "4", null,
                "Professor, Muggle Studies", "Hogwarts School of Witchcraft and Wizardry"));
        characters.add(new PotterCharacter("Beauxbatons Academy of Magic", "Fleur Delacour",
                false));
        characters.add(new PotterCharacter("Hogwarts School of Witchcraft and Wizardry",
                "Albus Dumbledore", true));
        characterStorage = mock(CharacterStorage.class);
        when(characterStorage.getCharacterList()).thenReturn(characters);
        dataHandler = new DataHandler(characterStorage);
    }

    @Test
    void getHogwartsHouseCharactersReturnsMatchingCharacters() {
        List<PotterCharacter> houseCharacterList = new ArrayList<>();
        houseCharacterList.add(characters.get(1));
        houseCharacterList.add(characters.get(2));
        assertIterableEquals(houseCharacterList,
                dataHandler.getHogwartsHouseCharacters("Slytherin"));
    }

    @Test
    void getHogwartsEmployeesReturnsMatchingCharacters() {
        List<PotterCharacter> employeeCharacterList = new ArrayList<>();
        employeeCharacterList.add(characters.get(3));
        assertIterableEquals(employeeCharacterList, dataHandler.getHogwartsEmployees());
    }

    @Test
    void getOtherCharacters() {
        List<PotterCharacter> otherCharacterList = new ArrayList<>();
        otherCharacterList.add(characters.get(4));
        assertIterableEquals(otherCharacterList, dataHandler.getOtherCharacters());
    }

    @Test
    void getMinistryOfMagicCharacters() {
        List<PotterCharacter> ministryCharacterList = new ArrayList<>();
        ministryCharacterList.add(characters.get(5));
        assertIterableEquals(ministryCharacterList, dataHandler.getMinistryOfMagicCharacters());
    }

    @Test
    void getCharacterById() {
        PotterCharacter testCharacter = charactersTest.get("1");
        assertEquals(testCharacter, characterStorage.getCharacterById("1"));
    }

    @Test
    void getRandomHouseQuizCharacter() {
//        List<PotterCharacter> houseQuizCharacters = new ArrayList<>();
//        houseQuizCharacters.add(characters.get(0));
//        assertEquals(houseQuizCharacters.get(0), dataHandler.getRandomHouseQuizCharacter());
    }
}