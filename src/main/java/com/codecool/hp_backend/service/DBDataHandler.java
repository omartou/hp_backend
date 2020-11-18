package com.codecool.hp_backend.service;

import com.codecool.hp_backend.entity.Character;
import com.codecool.hp_backend.entity.House;
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
        House houseByName = houseRepository.findHouseByName(house.substring(0,1).toUpperCase() + house.substring(1));
        List<Character> characters = characterRepository.getCharactersByHouse(houseByName);
        System.out.println(characters);

        for (Character character : characters) {
            String animagus = null;
            if(character.getAnimagus() != null) {
                animagus = character.getAnimagus().getName();
            }

            PotterCharacter potterCharacter = PotterCharacter.builder()
                    .id(character.getId().toString())
                    .name(character.getName())
                    .role(character.getRole())
                    .house(character.getHouse().getName())
                    .school(character.getSchool().getName())
                    .ministryOfMagic(character.isMinistryOfMagics())
                    .orderOfThePhoenix(character.isOrderOfPhoenix())
                    .dumbledoresArmy(character.isDumbledoresArmy())
                    .bloodStatus(character.getBloodStatus().getName())
                    .deathEater(character.isDeathEater())
                    .species(character.getSpecies().getName())
                    .boggart(character.getBoggart())
                    .alias(character.getAlias())
                    .wand(character.getWand())
                    .patronus(character.getPatronus())
                    .animagus(animagus)
                    .build();
            houseCharacters.add(potterCharacter);
        }
        return houseCharacters;
    }

    @Override
    public List<PotterCharacter> getHogwartsEmployees() {
        List<PotterCharacter> employees = new ArrayList<>();
        List<Character> professors = characterRepository.getCharactersByRoleContaining("Professor");

        for (Character professor : professors) {
            String animagus = null;
            String house = null;
            if(professor.getAnimagus() != null) {
                animagus = professor.getAnimagus().getName();
            }
            if(professor.getHouse() != null){
                house = professor.getHouse().getName();
            }

            PotterCharacter potterCharacter = PotterCharacter.builder()
                    .id(professor.getId().toString())
                    .name(professor.getName())
                    .role(professor.getRole())
                    .house(house)
                    .school(professor.getSchool().getName())
                    .ministryOfMagic(professor.isMinistryOfMagics())
                    .orderOfThePhoenix(professor.isOrderOfPhoenix())
                    .dumbledoresArmy(professor.isDumbledoresArmy())
                    .bloodStatus(professor.getBloodStatus().getName())
                    .deathEater(professor.isDeathEater())
                    .species(professor.getSpecies().getName())
                    .boggart(professor.getBoggart())
                    .alias(professor.getAlias())
                    .wand(professor.getWand())
                    .patronus(professor.getPatronus())
                    .animagus(animagus)
                    .build();
            employees.add(potterCharacter);
        }
        return employees;
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
