package com.codecool.hp_backend.service;

import com.codecool.hp_backend.entity.Character;
import com.codecool.hp_backend.entity.House;
import com.codecool.hp_backend.entity.School;
import com.codecool.hp_backend.model.generated.PotterCharacter;
import com.codecool.hp_backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class DBDataHandler implements DataHandler {

    private HouseRepository houseRepository;

    private BloodStatusRepository bloodStatusRepository;

    private AnimagusRepository animagusRepository;

    private SchoolRepository schoolRepository;

    private SpeciesRepository speciesRepository;

    @Autowired
    private CharacterRepository characterRepository;


    @Autowired
    public DBDataHandler(HouseRepository houseRepository,
                         BloodStatusRepository bloodStatusRepository,
                         AnimagusRepository animagusRepository,
                         SchoolRepository schoolRepository,
                         SpeciesRepository speciesRepository,
                         CharacterRepository characterRepository) {
        //TODO: We should get data from DB and store them in 'characters' variable
        this.houseRepository = houseRepository;
        this.bloodStatusRepository = bloodStatusRepository;
        this.animagusRepository = animagusRepository;
        this.schoolRepository = schoolRepository;
        this.speciesRepository = speciesRepository;
        this.characterRepository = characterRepository;
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
        List<PotterCharacter> houseCharacters = new ArrayList<>();
        House houseByName = houseRepository.findHouseByName(house.substring(0, 1).toUpperCase() + house.substring(1));
        List<Character> characters = characterRepository.getCharactersByHouse(houseByName);
        for (Character character : characters) {
            PotterCharacter potterCharacter = convertCharacterToPotterCharacter(character);
            houseCharacters.add(potterCharacter);

        }
        return houseCharacters;
    }

    @Override
    public List<PotterCharacter> getHogwartsEmployees() {
        List<PotterCharacter> employees = new ArrayList<>();
        List<Character> professors = characterRepository.getCharactersByRoleContaining("Professor");
        for (Character professor : professors) {
            PotterCharacter potterCharacter = convertCharacterToPotterCharacter(professor);
            employees.add(potterCharacter);
        }

        return employees;
    }

    @Override
    public List<PotterCharacter> getOtherCharacters() {
        List<PotterCharacter> others = new ArrayList<>();
        List<Character> otherCharacters = characterRepository
                .getCharactersByMinistryOfMagicsIsFalseAndSchoolIsNullOrSchoolNameNotContains("Hogwarts");
        for (Character otherCharacter : otherCharacters) {
            PotterCharacter potterCharacter = convertCharacterToPotterCharacter(otherCharacter);
            others.add(potterCharacter);
        }
        return others;
    }

    @Override
    public List<PotterCharacter> getMinistryOfMagicCharacters() {
        List<PotterCharacter> ministryCharacters = new ArrayList<>();
        List<Character> ministry = characterRepository.getCharactersByMinistryOfMagicsIsTrue();
        for (Character character : ministry) {
            PotterCharacter potterCharacter = convertCharacterToPotterCharacter(character);
            ministryCharacters.add(potterCharacter);
        }
        return ministryCharacters;
    }

    @Override
    public PotterCharacter getCharacterById(String id) {
        Character character = characterRepository.getCharacterById(Long.valueOf(id));
        return convertCharacterToPotterCharacter(character);
    }

    @Override
    public PotterCharacter getRandomHouseQuizCharacter() {
        List<Character> houseCharacters = characterRepository.getCharactersByHouseIsNotNull();
        Random random = new Random();

        return convertCharacterToPotterCharacter(houseCharacters.get(random.nextInt(houseCharacters.size())));
    }



    private PotterCharacter convertCharacterToPotterCharacter(Character character) {
            String animagus = null;
            String house = null;
            String school = null;
            String species = null;
            if (character.getAnimagus() != null) {
                animagus = character.getAnimagus().getName();
            }
            if (character.getHouse() != null) {
                house = character.getHouse().getName();
            }
            if (character.getSchool() != null) {
                school = character.getSchool().getName();
            }
            if (character.getSpecies() != null) {
                species = character.getSpecies().getName();
            }

        return PotterCharacter.builder()
                .id(character.getId().toString())
                .name(character.getName())
                .role(character.getRole())
                .house(house)
                .school(school)
                .ministryOfMagic(character.isMinistryOfMagics())
                .orderOfThePhoenix(character.isOrderOfPhoenix())
                .dumbledoresArmy(character.isDumbledoresArmy())
                .bloodStatus(character.getBloodStatus().getName())
                .deathEater(character.isDeathEater())
                .species(species)
                .boggart(character.getBoggart())
                .alias(character.getAlias())
                .wand(character.getWand())
                .patronus(character.getPatronus())
                .animagus(animagus)
                .build();
    }
}
