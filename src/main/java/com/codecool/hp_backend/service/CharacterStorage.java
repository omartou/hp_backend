package com.codecool.hp_backend.service;

import com.codecool.hp_backend.model.generated.PotterCharacter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CharacterStorage {

    private PotterApiService potterApiService;

    @Autowired
    public CharacterStorage(PotterApiService potterApiService) {
        this.potterApiService = potterApiService;
        this.allCharactersId = potterApiService.getIdOfCharacters();
        this.characters = potterApiService.generateCharacters(allCharactersId);
    }

    private List<String> allCharactersId;
    private Map<String, PotterCharacter> characters;

    public List<String> getAllCharactersId() {
        return allCharactersId;
    }

    public Map<String, PotterCharacter> getCharacters() {
        return characters;
    }

    public List<PotterCharacter> getCharacterList() {
        return new ArrayList<PotterCharacter>(characters.values());
    }
}
