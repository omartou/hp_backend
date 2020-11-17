package com.codecool.hp_backend.service;

import com.codecool.hp_backend.entity.Animagus;
import com.codecool.hp_backend.entity.BloodStatus;
import com.codecool.hp_backend.entity.House;
import com.codecool.hp_backend.entity.School;
import com.codecool.hp_backend.entity.Species;
import com.codecool.hp_backend.repository.AnimagusRepository;
import com.codecool.hp_backend.repository.BloodStatusRepository;
import com.codecool.hp_backend.repository.HouseRepository;
import com.codecool.hp_backend.repository.SchoolRepository;
import com.codecool.hp_backend.repository.SpeciesRepository;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    public void initDB() {
        initHouseTable();
        initSpeciesTable();
        initBloodStatusTable();
        initAnimagusTable();
        initSchoolTable();
        initCharacterTable();
        //characterRepository.saveAll();
    }

    private void initCharacterTable() {

    }

    private void initSchoolTable() {
        School beauxbatonsAcademyOfMagic = School.builder().school("Beauxbatons Academy of Magic")
                .build();
        School durmstrangInstitute = School.builder().school("Durmstrang Institute")
                .build();
        School hogwartsAcademyOfWitchcraftAndWizardry
                = School.builder().school("Hogwarts Academy of Witchcraft and Wizardry")
                .build();
        School hogwartsSchoolOfWitchcraftAndWizardry
                = School.builder().school("Hogwarts School of Witchcraft and Wizardry")
                .build();

        schoolRepository.saveAll(Lists.newArrayList(beauxbatonsAcademyOfMagic, durmstrangInstitute,
                hogwartsAcademyOfWitchcraftAndWizardry, hogwartsSchoolOfWitchcraftAndWizardry));
    }

    private void initBloodStatusTable() {
        BloodStatus unknown = BloodStatus.builder().bloodStatus("unknown").build();
        BloodStatus halfBlood = BloodStatus.builder().bloodStatus("half-blood").build();
        BloodStatus halfGiant = BloodStatus.builder().bloodStatus("half-giant").build();
        BloodStatus muggle = BloodStatus.builder().bloodStatus("muggle").build();
        BloodStatus muggleBorn = BloodStatus.builder().bloodStatus("muggle-born").build();
        BloodStatus pureBlood = BloodStatus.builder().bloodStatus("pure-blood").build();
        BloodStatus quarterVilla = BloodStatus.builder().bloodStatus("quarter-villa").build();
        BloodStatus squib = BloodStatus.builder().bloodStatus("squib").build();

        bloodStatusRepository.saveAll(
                Lists.newArrayList(unknown,
                        halfBlood,
                        halfGiant,
                        muggle,
                        muggleBorn,
                        pureBlood,
                        quarterVilla,
                        squib));

        bloodStatusRepository.saveAll(
                Lists.newArrayList(unknown, halfBlood, halfGiant, muggle, muggleBorn, pureBlood,
                        quarterVilla, squib));
    }

    private void initSpeciesTable() {
        Species acromantula = Species.builder().species("acromantula").build();
        Species Boarhound = Species.builder().species("Boarhound").build();
        Species cat = Species.builder().species("cat").build();
        Species centaur = Species.builder().species("centaur").build();
        Species ghost = Species.builder().species("ghost").build();
        Species giant = Species.builder().species("giant").build();
        Species goblin = Species.builder().species("goblin").build();
        Species greyOwl = Species.builder().species("Great Grey Owl").build();
        Species halfGiant = Species.builder().species("half-giant").build();
        Species hippogriff = Species.builder().species("hippogriff").build();
        Species horcrux = Species.builder().species("horcrux").build();
        Species houseElf = Species.builder().species("house-elf").build();
        Species human = Species.builder().species("human").build();
        Species humanMetamorphMagus = Species.builder().species("human (metamorphmagus)").build();
        Species norwegianRidgeback = Species.builder().species("Norwegian RidgeBack").build();
        Species partGoblin = Species.builder().species("part-goblin").build();
        Species partHuman = Species.builder().species("part-human").build();
        Species phoenix = Species.builder().species("phoenix").build();
        Species poltergeist = Species.builder().species("poltergeist").build();
        Species portrait = Species.builder().species("portrait").build();
        Species scopsOwl = Species.builder().species("scops owl").build();
        Species snowyOwl = Species.builder().species("Snowy Owl").build();
        Species threeHeadedDog = Species.builder().species("three-headed dog").build();
        Species toad = Species.builder().species("toad").build();
        Species werewolf = Species.builder().species("werewolf").build();

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
        Animagus beetle = Animagus.builder().animagus("beetle").build();
        Animagus dog = Animagus.builder().animagus("dog").build();
        Animagus rat = Animagus.builder().animagus("rat").build();
        Animagus stag = Animagus.builder().animagus("stag").build();
        Animagus tabbyCat = Animagus.builder().animagus("tabby cat").build();

        animagusRepository.saveAll(Lists.newArrayList(beetle, dog, rat, stag, tabbyCat));
    }

    private void initHouseTable() {
        House gryffindor = House.builder().house("Gryffindor").build();
        House hufflepuff = House.builder().house("Hufflepuff").build();
        House ravenclaw = House.builder().house("Ravenclaw").build();
        House slytherin = House.builder().house("Slytherin").build();

        houseRepository
                .saveAll(Lists.newArrayList(gryffindor, hufflepuff, ravenclaw, slytherin));
    }
}

