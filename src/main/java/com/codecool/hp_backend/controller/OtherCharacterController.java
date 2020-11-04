package com.codecool.hp_backend.controller;

import com.codecool.hp_backend.model.generated.PotterCharacter;
import com.codecool.hp_backend.service.DataHandler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class OtherCharacterController {

    private final DataHandler dataHandler;

    @Autowired
    public OtherCharacterController(DataHandler dataHandler) {
        this.dataHandler = dataHandler;
    }

    @GetMapping("/other")
    public List<PotterCharacter> getOtherCharacters() {
        return dataHandler.getOtherCharacters();
    }

    @GetMapping("/ministry")
    public List<PotterCharacter> getMinistryCharacters() {
        return dataHandler.getMinistryOfMagicCharacters();
    }

    @GetMapping("/character/{id}")
    public PotterCharacter getCharacterById(@PathVariable("id") String id) {
        return dataHandler.getCharacterById(id);
    }
}


