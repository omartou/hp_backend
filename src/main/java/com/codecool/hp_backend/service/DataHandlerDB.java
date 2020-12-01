package com.codecool.hp_backend.service;

import com.codecool.hp_backend.entity.Character;
import com.codecool.hp_backend.entity.HPUser;
import com.codecool.hp_backend.entity.House;
import com.codecool.hp_backend.model.generated.PotterCharacter;
import com.codecool.hp_backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class DataHandlerDB implements DataHandler {

    private final HouseRepository houseRepository;
    private final CharacterRepository characterRepository;
    private final HPUserRepository hpUserRepository;

    @Autowired
    public DataHandlerDB(HouseRepository houseRepository,
                         CharacterRepository characterRepository, HPUserRepository hpUserRepository) {
        this.houseRepository = houseRepository;
        this.characterRepository = characterRepository;
        this.hpUserRepository = hpUserRepository;
    }

    @Override
    public List<PotterCharacter> getHogwartsHouseCharacters(String house) {
        List<PotterCharacter> houseCharacters = new ArrayList<>();
        House houseByName = houseRepository.findHouseByName(house.substring(0, 1).toUpperCase() + house.substring(1));
        List<Character> characters = characterRepository.getCharactersByHouseOrderByName(houseByName);

        for (Character character : characters) {
            PotterCharacter potterCharacter = convertCharacterToPotterCharacter(character);
            houseCharacters.add(potterCharacter);
        }
        System.out.println(house + " : " + houseCharacters.size());
        return houseCharacters;
    }

    @Override
    public List<PotterCharacter> getHogwartsEmployees() {
        List<PotterCharacter> employees = new ArrayList<>();
        List<Character> professors = characterRepository.getCharactersByRoleContainingOrderByName("Professor");

        for (Character professor : professors) {
            PotterCharacter potterCharacter = convertCharacterToPotterCharacter(professor);
            employees.add(potterCharacter);
        }
        System.out.println("employees: " + employees.size());
        return employees;
    }

    @Override
    public List<PotterCharacter> getOtherCharacters() {
        List<PotterCharacter> others = new ArrayList<>();
        List<Character> otherCharacters = characterRepository
                .getCharactersByMinistryOfMagicsIsFalseAndSchoolIsNullOrSchoolNameNotContainsOrderByName("Hogwarts");

        for (Character otherCharacter : otherCharacters) {
            PotterCharacter potterCharacter = convertCharacterToPotterCharacter(otherCharacter);
            others.add(potterCharacter);
        }
        System.out.println("other: " + otherCharacters.size());
        return others;
    }

    @Override
    public List<PotterCharacter> getMinistryOfMagicCharacters() {
        List<PotterCharacter> ministryCharacters = new ArrayList<>();
        List<Character> ministry = characterRepository.getCharactersByMinistryOfMagicsIsTrueOrderByName();

        for (Character character : ministry) {
            PotterCharacter potterCharacter = convertCharacterToPotterCharacter(character);
            ministryCharacters.add(potterCharacter);
        }
        System.out.println("ministry: " + ministryCharacters.size());
        return ministryCharacters;
    }

    @Override
    public PotterCharacter getCharacterById(String id) {
        Character character = characterRepository.getCharacterById(Long.valueOf(id));
        return convertCharacterToPotterCharacter(character);
    }

    @Override
    public PotterCharacter getRandomHouseQuizCharacter() {
        List<Character> houseCharacters = characterRepository.getCharactersByHouseIsNotNullOrderByName();
        Random random = new Random();
        System.out.println("houseQuizCharacters: " + houseCharacters.size());
        return convertCharacterToPotterCharacter(houseCharacters.get(random.nextInt(houseCharacters.size())));
    }

    private PotterCharacter convertCharacterToPotterCharacter(Character character) {
        String animagus = character.getAnimagus() != null ? character.getAnimagus().getName() : null;
        String house = character.getHouse() != null ? character.getHouse().getName() : null;
        String school = character.getSchool() != null ? character.getSchool().getName() : null;
        String wand = character.getWand() != null ? character.getWand().toString() : null;

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
                .species(character.getSpecies().getName())
                .boggart(character.getBoggart())
                .alias(character.getAlias())
                .wand(wand)
                .patronus(character.getPatronus())
                .animagus(animagus)
                .build();
    }

    @Override
    public void saveUser(HPUser hpUser) {
        hpUserRepository.save(hpUser);
    }
    @Override
    public boolean checkIfUsernameExists(String username) {
        return hpUserRepository.existsHPUserByUsername(username);
    }

    @Override
    public boolean checkIfEmailExists(String email) {
        return hpUserRepository.existsHPUserByEmail(email);
    }

    @Override
    public HPUser getHpUserByName(String name) {
        return hpUserRepository.getHPUserByUsername(name);
    }


}
