package com.codecool.hp_backend.controller;

import com.codecool.hp_backend.service.JsonHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.json.*;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/hogwarts")
public class HogwartsController {

    private final JsonHandler jsonHandler;

    @Autowired
    HogwartsController(JsonHandler jsonHandler) {
        this.jsonHandler = jsonHandler;
    }

    @GetMapping("/houses/{houseName}")
    public String getCharactersByHouseName(@PathVariable("houseName") String houseName) throws FileNotFoundException {
        JsonArray characters = jsonHandler.readCharactersFromFile();

        List<JsonObject> houseCharacters = characters.getValuesAs(JsonObject.class)
                .stream()
                .filter(obj -> obj.containsKey("house"))
                .filter(obj -> obj.get("house").toString().toUpperCase().equals(houseName.toUpperCase()))
                .collect(Collectors.toList());

        return houseCharacters.toString();
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
