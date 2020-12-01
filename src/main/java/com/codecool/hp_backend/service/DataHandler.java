package com.codecool.hp_backend.service;

import com.codecool.hp_backend.entity.HPUser;
import com.codecool.hp_backend.model.generated.PotterCharacter;

import java.util.List;

public interface DataHandler {

    List<PotterCharacter> getHogwartsHouseCharacters(String house);

    List<PotterCharacter> getHogwartsEmployees();

    List<PotterCharacter> getOtherCharacters();

    List<PotterCharacter> getMinistryOfMagicCharacters();

    PotterCharacter getCharacterById(String id);

    PotterCharacter getRandomHouseQuizCharacter();

    void saveUser(HPUser hpuser);

    boolean checkIfUsernameExists(String username);

    boolean checkIfEmailExists(String email);

    public HPUser getHpUserByName(String name);
}
