package com.codecool.hp_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.json.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.stream.Stream;

@RestController
@RequestMapping("/hogwarts")
public class HogwartsController {

    @GetMapping("/houses/gryffindor")
    public String getGryffindorCharacters() throws FileNotFoundException {
        JsonReader reader = Json.createReader(new FileReader("src/main/resources/static/characters.json"));
        return reader.readArray().toString();
    }

}
