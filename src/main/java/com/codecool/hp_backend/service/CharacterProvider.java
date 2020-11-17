package com.codecool.hp_backend.service;

import com.codecool.hp_backend.model.generated.PotterCharacter;

import java.util.Map;

public interface CharacterProvider {

    Map<String, PotterCharacter> getAllCharacters();
}
