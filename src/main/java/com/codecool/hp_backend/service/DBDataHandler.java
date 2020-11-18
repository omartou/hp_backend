package com.codecool.hp_backend.service;

import com.codecool.hp_backend.model.generated.PotterCharacter;
import com.codecool.hp_backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DBDataHandler implements DataHandler {

    private HouseRepository houseRepository;

    private BloodStatusRepository bloodStatusRepository;

    private AnimagusRepository animagusRepository;

    private SchoolRepository schoolRepository;

    private SpeciesRepository speciesRepository;

    private CharacterRepository characterRepository;


    @Autowired
    public DBDataHandler(HouseRepository houseRepository,
                         BloodStatusRepository bloodStatusRepository,
                         AnimagusRepository animagusRepository,
                         SchoolRepository schoolRepository,
                         SpeciesRepository speciesRepository,
                         CharacterRepository characterRepository) {
        //TODO: We should get data from DB and store them in 'characters' variable
        this.characters = null;
//        initHouseQuizCharacters();
    }

    private final List<PotterCharacter> characters;
    private final List<PotterCharacter> houseQuizCharacters = new ArrayList<>();


    private void initHouseQuizCharacters() {
        for (PotterCharacter character : characters) {
            if (character.getHouse() != null) {
                houseQuizCharacters.add(character);
            }
        }
    }

    @Override
    public List<PotterCharacter> getHogwartsHouseCharacters(String house) {
        return null;
    }

    @Override
    public List<PotterCharacter> getHogwartsEmployees() {
        return null;
    }

    @Override
    public List<PotterCharacter> getOtherCharacters() {
        return null;
    }

    @Override
    public List<PotterCharacter> getMinistryOfMagicCharacters() {
        return null;
    }

    @Override
    public PotterCharacter getCharacterById(String id) {
        return null;
    }

    @Override
    public PotterCharacter getRandomHouseQuizCharacter() {
        return null;
    }
}
