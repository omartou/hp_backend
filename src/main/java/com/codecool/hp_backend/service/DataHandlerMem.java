package com.codecool.hp_backend.service;

import com.codecool.hp_backend.entity.HPUser;
import com.codecool.hp_backend.model.generated.PotterCharacter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DataHandlerMem implements DataHandler {

    private final CharacterStorage characterStorage;
    private final List<PotterCharacter> characters;
    private final List<PotterCharacter> houseQuizCharacters = new ArrayList<>();

    @Autowired
    public DataHandlerMem(CharacterStorage characterStorage) {
        this.characterStorage = characterStorage;
        this.characters = characterStorage.getCharacterList();
        initHouseQuizCharacters();
    }

    private void initHouseQuizCharacters() {
        for (PotterCharacter character : characters) {
            if (character.getHouse() != null) {
                houseQuizCharacters.add(character);
            }
        }
    }

    @Override
    public List<PotterCharacter> getHogwartsHouseCharacters(String house) {
        List<PotterCharacter> houseCharacters = new ArrayList<>();

        for (PotterCharacter character : characters) {
            if (character.getHouse() != null && character.getHouse().toLowerCase().equals(house.toLowerCase())) {
                houseCharacters.add(character);
            }
        }
        return houseCharacters;
    }

    @Override
    public List<PotterCharacter> getHogwartsEmployees() {
        List<PotterCharacter> employees = new ArrayList<>();
        for (PotterCharacter character : characters) {
            if(character.getRole() != null && character.getRole().contains("Professor")) {
                employees.add(character);
            }
        }
        return employees;
    }

    @Override
    public List<PotterCharacter> getOtherCharacters() {
        List<PotterCharacter> otherCharacters = new ArrayList<>();
        for (PotterCharacter character : characters) {
            if(!character.isMinistryOfMagic()
                    && (character.getSchool() == null
                    || !character.getSchool().contains("Hogwarts"))){
                otherCharacters.add(character);
            }
        }
        return otherCharacters;
    }

    @Override
    public List<PotterCharacter> getMinistryOfMagicCharacters() {
        List<PotterCharacter> ministryCharacters = new ArrayList<>();
        for (PotterCharacter character : characters) {
            if (character.isMinistryOfMagic()) {
                ministryCharacters.add(character);
            }
        }
        return ministryCharacters;
    }

    @Override
    public PotterCharacter getCharacterById(String id) {
        return characterStorage.getCharacterById(id);
    }

    @Override
    public PotterCharacter getRandomHouseQuizCharacter() {
        Random random = new Random();
        return houseQuizCharacters.get(random.nextInt(houseQuizCharacters.size()));
    }

    @Override
    public void saveUser(HPUser hpUser){}

    @Override
    public boolean checkIfUsernameExists(String username) {
        return false;
    }

    @Override
    public boolean checkIfEmailExists(String email) {
        return false;
    }

    @Override
    public HPUser getHpUserByName(String name) {
        return null;
    }

    @Override
    public void updateCharacterById(Long id, PotterCharacter character) {}

}
