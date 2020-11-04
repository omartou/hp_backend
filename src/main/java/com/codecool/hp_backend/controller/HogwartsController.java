package com.codecool.hp_backend.controller;

import com.codecool.hp_backend.model.generated.PotterCharacter;
import com.codecool.hp_backend.service.DataHandler;
import com.codecool.hp_backend.service.JsonHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/hogwarts")
public class HogwartsController {

    private final DataHandler dataHandler;

    @Autowired
    HogwartsController(DataHandler dataHandler) {
        this.dataHandler = dataHandler;
    }

    @GetMapping("/houses/{houseName}")
    public List<PotterCharacter> getCharactersByHouseName(@PathVariable("houseName") String houseName) {
        return dataHandler.getHogwartsHouseCharacters(houseName);
    }

    @GetMapping("/employees")
    public List<PotterCharacter> getEmployees() {
        return dataHandler.getHogwartsEmployees();
    }
}
