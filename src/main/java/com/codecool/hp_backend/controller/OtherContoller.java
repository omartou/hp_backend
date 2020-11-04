package com.codecool.hp_backend.controller;

import com.codecool.hp_backend.model.generated.PotterCharacter;
import com.codecool.hp_backend.service.CharacterStorage;
import com.codecool.hp_backend.service.DataHandler;
import com.codecool.hp_backend.service.JsonHandler;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.xml.crypto.Data;

import com.codecool.hp_backend.service.PotterApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class OtherContoller {

    private final JsonHandler jsonHandler;
    private PotterApiService potterApiService;
    private CharacterStorage characterStorage;
    private final DataHandler dataHandler;

    @Autowired
    public OtherContoller(JsonHandler jsonHandler,
                          PotterApiService potterApiService,
                          CharacterStorage characterStorage,
                          DataHandler dataHandler) {
        this.jsonHandler = jsonHandler;
        this.potterApiService = potterApiService;
        this.characterStorage = characterStorage;
        this.dataHandler = dataHandler;
    }

    @GetMapping("/other")
    public List<PotterCharacter> getOtherCharacters() {
        return dataHandler.getOtherCharacters();
    }

    @GetMapping("/ministry")
    public String getMinistryCharacters() {
        return null;
    }

    @GetMapping("/character/{id}")
    public PotterCharacter getCharacterById(@PathVariable("id") String id) {
        return potterApiService.getCharacterById(id);
    }

    @GetMapping("/characters")
    public List<PotterCharacter> getCharacters() {
        return characterStorage.getCharacterList();
    }
}


