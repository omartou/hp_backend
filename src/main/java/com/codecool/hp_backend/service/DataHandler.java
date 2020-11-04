package com.codecool.hp_backend.service;

import com.codecool.hp_backend.model.generated.PotterCharacter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataHandler {

    private CharacterStorage characterStorage;
    private final List<PotterCharacter> characters;

    @Autowired
    public  DataHandler(CharacterStorage characterStorage) {
        this.characterStorage = characterStorage;
        this.characters = characterStorage.getCharacterList();
    }

    public List<PotterCharacter> getHogwartsHouseCharacters(String house) {
        List<PotterCharacter> houseCharacters = new ArrayList<>();

        for (PotterCharacter character : characters) {
            if (character.getHouse() != null && character.getHouse().toLowerCase().equals(house.toLowerCase())) {
                houseCharacters.add(character);
            }
        }
        return houseCharacters;
    }

    public List<PotterCharacter> getHogwartsEmployees() {
        List<PotterCharacter> employees = new ArrayList<>();
        for (PotterCharacter character : characters) {
            if(character.getRole() != null && character.getRole().split(",")[0].equals("Professor")) {
                employees.add(character);
            }
        }
        return employees;
    }
}
