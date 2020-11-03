package com.codecool.hp_backend.service;

import org.springframework.stereotype.Service;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

@Service
public class JsonHandler {

    public JsonArray readCharactersFromFile() throws FileNotFoundException {
        JsonReader reader = Json.createReader(new FileReader("src/main/resources/static/characters.json"));
        return reader.readArray();
    }

    public JsonArray readHousesFromFile() throws FileNotFoundException {
        JsonReader reader = Json.createReader(new FileReader("src/main/resources/static/houses.json"));
        return reader.readArray();
    }

}
