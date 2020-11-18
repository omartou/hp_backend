package com.codecool.hp_backend.service;

import com.codecool.hp_backend.entity.*;
import com.codecool.hp_backend.entity.Character;
import com.codecool.hp_backend.model.generated.PotterCharacter;
import com.codecool.hp_backend.repository.*;
import org.assertj.core.util.Lists;
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

    public void initDB() {
        initHouseTable();
        initSpeciesTable();
        initBloodStatusTable();
        initAnimagusTable();
        initSchoolTable();
        initCharacterTable(characterStorage.getCharacterList());
        //ONLY FOR TESTING PURPOSES
        List<Character> characters = characterRepository.findAll();
        for (Character character : characters) {
            Animagus animagus = character.getAnimagus();
            if (animagus != null) {
                Long animagusId = animagus.getId();
                String animagusName = animagusRepository.getAnimagusNameById(animagusId);
                System.out.println(animagusName);
            }
        }
    }

    private void initCharacterTable(List<PotterCharacter> characters) {
        List<Character> characterEntities = new ArrayList<>();

        for (PotterCharacter character : characters) {
//            String houseName = character.getHouse();
//            House house = houseName != null ? houseRepository.findHouseByName(houseName) : null;
            House house = houseRepository.findHouseByName(character.getHouse());
            School school = schoolRepository.findSchoolByName(character.getSchool());
            BloodStatus bloodStatus = bloodStatusRepository.findBloodStatusByName(character.getBloodStatus());
            Species species = speciesRepository.findSpeciesByName(character.getSpecies());

//            String animagusName = character.getAnimagus();
//            Animagus animagus = animagusName != null ? animagusRepository.findAnimagusByName(animagusName) : null;
            Animagus animagus = animagusRepository.findAnimagusByName(character.getAnimagus());

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
                    .wand(character.getWand())
                    .patronus(character.getPatronus())
                    .animagus(animagus)
                    .build();
            characterEntities.add(entity);
        }
        characterRepository.saveAll(characterEntities);
    }

    private void initSchoolTable() {
        School beauxbatonsAcademyOfMagic = School.builder().name("Beauxbatons Academy of Magic")
                .build();
        School durmstrangInstitute = School.builder().name("Durmstrang Institute")
                .build();
        School hogwartsAcademyOfWitchcraftAndWizardry
                = School.builder().name("Hogwarts Academy of Witchcraft and Wizardry")
                .build();
        School hogwartsSchoolOfWitchcraftAndWizardry
                = School.builder().name("Hogwarts School of Witchcraft and Wizardry")
                .build();

        schoolRepository.saveAll(Lists.newArrayList(beauxbatonsAcademyOfMagic, durmstrangInstitute,
                hogwartsAcademyOfWitchcraftAndWizardry, hogwartsSchoolOfWitchcraftAndWizardry));
    }

    private void initBloodStatusTable() {
        BloodStatus unknown = BloodStatus.builder().name("unknown").build();
        BloodStatus halfBlood = BloodStatus.builder().name("half-blood").build();
        BloodStatus halfGiant = BloodStatus.builder().name("half-giant").build();
        BloodStatus muggle = BloodStatus.builder().name("muggle").build();
        BloodStatus muggleBorn = BloodStatus.builder().name("muggle-born").build();
        BloodStatus pureBlood = BloodStatus.builder().name("pure-blood").build();
        BloodStatus quarterVilla = BloodStatus.builder().name("quarter-villa").build();
        BloodStatus squib = BloodStatus.builder().name("squib").build();

        bloodStatusRepository.saveAll(
                Lists.newArrayList(unknown,
                        halfBlood,
                        halfGiant,
                        muggle,
                        muggleBorn,
                        pureBlood,
                        quarterVilla,
                        squib));
    }

    private void initSpeciesTable() {
        Species acromantula = Species.builder().name("acromantula").build();
        Species Boarhound = Species.builder().name("Boarhound").build();
        Species cat = Species.builder().name("cat").build();
        Species centaur = Species.builder().name("centaur").build();
        Species ghost = Species.builder().name("ghost").build();
        Species giant = Species.builder().name("giant").build();
        Species goblin = Species.builder().name("goblin").build();
        Species greyOwl = Species.builder().name("Great Grey Owl").build();
        Species halfGiant = Species.builder().name("half-giant").build();
        Species hippogriff = Species.builder().name("hippogriff").build();
        Species horcrux = Species.builder().name("horcrux").build();
        Species houseElf = Species.builder().name("house-elf").build();
        Species human = Species.builder().name("human").build();
        Species humanMetamorphMagus = Species.builder().name("human (metamorphmagus)").build();
        Species norwegianRidgeback = Species.builder().name("Norwegian RidgeBack").build();
        Species partGoblin = Species.builder().name("part-goblin").build();
        Species partHuman = Species.builder().name("part-human").build();
        Species phoenix = Species.builder().name("phoenix").build();
        Species poltergeist = Species.builder().name("poltergeist").build();
        Species portrait = Species.builder().name("portrait").build();
        Species scopsOwl = Species.builder().name("scops owl").build();
        Species snowyOwl = Species.builder().name("Snowy Owl").build();
        Species threeHeadedDog = Species.builder().name("three-headed dog").build();
        Species toad = Species.builder().name("toad").build();
        Species werewolf = Species.builder().name("werewolf").build();

        speciesRepository.saveAll(Lists.newArrayList(acromantula,
                Boarhound,
                cat,
                centaur,
                ghost,
                giant,
                goblin,
                greyOwl,
                halfGiant,
                hippogriff,
                horcrux,
                houseElf,
                human,
                humanMetamorphMagus,
                norwegianRidgeback,
                partGoblin,
                partHuman,
                phoenix,
                poltergeist,
                portrait,
                scopsOwl,
                snowyOwl,
                threeHeadedDog,
                toad,
                werewolf));
    }

    private void initAnimagusTable() {
        Animagus beetle = Animagus.builder().name("beetle").build();
        Animagus dog = Animagus.builder().name("black dog").build();
        Animagus rat = Animagus.builder().name("rat").build();
        Animagus stag = Animagus.builder().name("stag").build();
        Animagus tabbyCat = Animagus.builder().name("tabby cat").build();

        animagusRepository.saveAll(Lists.newArrayList(beetle, dog, rat, stag, tabbyCat));
    }

    private void initHouseTable() {
        House gryffindor = House.builder().name("Gryffindor").build();
        House hufflepuff = House.builder().name("Hufflepuff").build();
        House ravenclaw = House.builder().name("Ravenclaw").build();
        House slytherin = House.builder().name("Slytherin").build();

        houseRepository
                .saveAll(Lists.newArrayList(gryffindor, hufflepuff, ravenclaw, slytherin));
    }
}

