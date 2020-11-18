package com.codecool.hp_backend.service;

import static org.junit.jupiter.api.Assertions.*;

import com.codecool.hp_backend.model.generated.PotterCharacter;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class InMemoryDataHandlerTest {

    private static CharacterStorage characterStorage;
    private static InMemoryDataHandler dataHandler;
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
        characters.add(new PotterCharacter("Beauxbatons Academy of Magic", "Fleur Delacour",
                false));
        characters.add(new PotterCharacter("Hogwarts School of Witchcraft and Wizardry",
                "Albus Dumbledore", true));
        characterStorage = mock(CharacterStorage.class);
        when(characterStorage.getCharacterList()).thenReturn(characters);
        dataHandler = new InMemoryDataHandler(characterStorage);
    }

    @Test
    void getHogwartsHouseCharactersReturnsMatchingCharacters() {
        List<PotterCharacter> houseCharacterList = new ArrayList<>();
        houseCharacterList.add(characters.get(1));
        houseCharacterList.add(characters.get(2));
        assertIterableEquals(houseCharacterList, dataHandler.getHogwartsHouseCharacters("Slytherin"));
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
    }

    @Test
    void getRandomHouseQuizCharacter() {
    }
}