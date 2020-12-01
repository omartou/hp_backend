package com.codecool.hp_backend.service;

import com.codecool.hp_backend.entity.*;
import com.codecool.hp_backend.entity.Character;
import com.codecool.hp_backend.model.generated.PotterCharacter;
import com.codecool.hp_backend.repository.*;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DBInitializer {

    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    private BloodStatusRepository bloodStatusRepository;

    @Autowired
    private AnimagusRepository animagusRepository;

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private SpeciesRepository speciesRepository;

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private CharacterStorage characterStorage;

    @Autowired
    private WandRepository wandRepository;

    @Autowired
    private HPUserRepository hpUserRepository;

    public void initDB() {
        initHouseTable();
        initSpeciesTable();
        initBloodStatusTable();
        initAnimagusTable();
        initSchoolTable();
        initCharacterTable(characterStorage.getCharacterList());
        initUserTable();
    }

    private void initCharacterTable(List<PotterCharacter> characters) {
        List<Character> characterEntities = new ArrayList<>();

        for (PotterCharacter character : characters) {
            House house = houseRepository.findHouseByName(character.getHouse());
            School school = schoolRepository.findSchoolByName(character.getSchool());
            BloodStatus bloodStatus = bloodStatusRepository
                    .findBloodStatusByName(character.getBloodStatus());
            Species species = speciesRepository.findSpeciesByName(character.getSpecies());
            Animagus animagus = animagusRepository.findAnimagusByName(character.getAnimagus());
            Wand wand = null;
            if (character.getWand() != null) {
                String[] wandParts = character.getWand().split(", ");
                wand = Wand.builder()
                        .wood(wandParts[0])
                        .length(wandParts[1])
                        .core(Core.getEnumByString(wandParts[2]))
                        .build();
            }

            Character entity = Character.builder()
                    .name(character.getName())
                    .role(character.getRole())
                    .house(house)
                    .school(school)
                    .ministryOfMagics(character.isMinistryOfMagic())
                    .orderOfPhoenix(character.isOrderOfThePhoenix())
                    .dumbledoresArmy(character.isDumbledoresArmy())
                    .bloodStatus(bloodStatus)
                    .deathEater(character.isDeathEater())
                    .species(species)
                    .boggart(character.getBoggart())
                    .alias(character.getAlias())
                    .wand(wand)
                    .patronus(character.getPatronus())
                    .animagus(animagus)
                    .build();
            characterEntities.add(entity);

            if (wand != null) {
                wand.setOwner(entity);
                wandRepository.save(wand);
            }

        }

        characterRepository.saveAll(characterEntities);
    }

    private void initSchoolTable() {
        List<School> schools = new ArrayList<>();

        schools.add(School.builder().name("Beauxbatons Academy of Magic").build());
        schools.add(School.builder().name("Durmstrang Institute").build());
        schools.add(School.builder().name("Hogwarts Academy of Witchcraft and Wizardry").build());
        schools.add(School.builder().name("Hogwarts School of Witchcraft and Wizardry").build());

        schoolRepository.saveAll(schools);
    }

    private void initBloodStatusTable() {
        List<BloodStatus> bloodStatuses = new ArrayList<>();

        bloodStatuses.add(BloodStatus.builder().name("unknown").build());
        bloodStatuses.add(BloodStatus.builder().name("half-blood").build());
        bloodStatuses.add(BloodStatus.builder().name("half-giant").build());
        bloodStatuses.add(BloodStatus.builder().name("muggle").build());
        bloodStatuses.add(BloodStatus.builder().name("muggle-born").build());
        bloodStatuses.add(BloodStatus.builder().name("pure-blood").build());
        bloodStatuses.add(BloodStatus.builder().name("quarter-villa").build());
        bloodStatuses.add(BloodStatus.builder().name("squib").build());

        bloodStatusRepository.saveAll(bloodStatuses);
    }

    private void initSpeciesTable() {
        List<Species> speciesList = new ArrayList<>();

        speciesList.add(Species.builder().name("acromantula").build());
        speciesList.add(Species.builder().name("Boarhound").build());
        speciesList.add(Species.builder().name("cat").build());
        speciesList.add(Species.builder().name("centaur").build());
        speciesList.add(Species.builder().name("ghost").build());
        speciesList.add(Species.builder().name("giant").build());
        speciesList.add(Species.builder().name("goblin").build());
        speciesList.add(Species.builder().name("Great Grey Owl").build());
        speciesList.add(Species.builder().name("half-giant").build());
        speciesList.add(Species.builder().name("hippogriff").build());
        speciesList.add(Species.builder().name("horcrux").build());
        speciesList.add(Species.builder().name("house-elf").build());
        speciesList.add(Species.builder().name("human").build());
        speciesList.add(Species.builder().name("human (metamorphmagus)").build());
        speciesList.add(Species.builder().name("Norwegian Ridgeback").build());
        speciesList.add(Species.builder().name("part-goblin").build());
        speciesList.add(Species.builder().name("part-human").build());
        speciesList.add(Species.builder().name("phoenix").build());
        speciesList.add(Species.builder().name("poltergeist").build());
        speciesList.add(Species.builder().name("portrait").build());
        speciesList.add(Species.builder().name("scops owl").build());
        speciesList.add(Species.builder().name("Snowy Owl").build());
        speciesList.add(Species.builder().name("three-headed dog").build());
        speciesList.add(Species.builder().name("toad").build());
        speciesList.add(Species.builder().name("werewolf").build());

        speciesRepository.saveAll(speciesList);
    }

    private void initAnimagusTable() {
        List<Animagus> animaguses = new ArrayList<>();

        animaguses.add(Animagus.builder().name("beetle").build());
        animaguses.add(Animagus.builder().name("black dog").build());
        animaguses.add(Animagus.builder().name("rat").build());
        animaguses.add(Animagus.builder().name("stag").build());
        animaguses.add(Animagus.builder().name("tabby cat").build());

        animagusRepository.saveAll(animaguses);
    }

    private void initHouseTable() {
        List<House> houses = new ArrayList<>();

        houses.add(House.builder().name("Gryffindor").build());
        houses.add(House.builder().name("Hufflepuff").build());
        houses.add(House.builder().name("Ravenclaw").build());
        houses.add(House.builder().name("Slytherin").build());

        houseRepository.saveAll(houses);
    }

    private void initUserTable() {
        List<HPUser> hpUsers = new ArrayList<>();

        hpUsers.add(HPUser.builder().username("admin").password("admin")
                .roles(Arrays.asList("ROLE_USER", "ROLE_ADMIN")).email("admin@admin.com").build());
        hpUsers.add(
                HPUser.builder().username("user").password("user").email("user@user.com").build());

        hpUserRepository.saveAll(hpUsers);
    }

}

