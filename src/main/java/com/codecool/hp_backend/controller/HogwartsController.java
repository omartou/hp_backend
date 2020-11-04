package com.codecool.hp_backend.controller;

import com.codecool.hp_backend.model.generated.PotterCharacter;
import com.codecool.hp_backend.service.DataHandler;
import com.codecool.hp_backend.service.JsonHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.json.*;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/hogwarts")
public class HogwartsController {

    private final JsonHandler jsonHandler;

    private final DataHandler dataHandler;

    @Autowired
    HogwartsController(JsonHandler jsonHandler, DataHandler dataHandler) {
        this.jsonHandler = jsonHandler;
        this.dataHandler = dataHandler;
    }

    @GetMapping("/houses/{houseName}")
    public List<PotterCharacter> getCharactersByHouseName(@PathVariable("houseName") String houseName) {
        return dataHandler.getHogwartsHouseCharacters(houseName);
    }

    @GetMapping("/employees")
    public String getEmployees() throws FileNotFoundException {
        JsonArray characters = jsonHandler.readCharactersFromFile();

        List<JsonObject> employeeCharacters = characters.getValuesAs(JsonObject.class)
                .stream()
                .filter(obj -> obj.containsKey("role"))
                .filter(obj -> obj.get("role").toString().split(",")[0].equals("Professor"))
                .collect(Collectors.toList());

        return employeeCharacters.toString();
    }


}
