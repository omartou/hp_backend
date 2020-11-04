package com.codecool.hp_backend.service;

import com.codecool.hp_backend.model.generated.PotterCharacter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataHandler {

    private CharacterStorage characterStorage;

    @Autowired
    public  DataHandler(CharacterStorage characterStorage) {
        this.characterStorage = characterStorage;
    }

    public List<PotterCharacter> getHogwartsHouseCharacters(String house) {
        List<PotterCharacter> characters = characterStorage.getCharacterList();
        List<PotterCharacter> houseCharacters = new ArrayList<>();

        for (PotterCharacter character : characters) {
            if (character.getHouse() != null && character.getHouse().toLowerCase().equals(house.toLowerCase())) {
                houseCharacters.add(character);
            }
        }
        return houseCharacters;
    }
}
