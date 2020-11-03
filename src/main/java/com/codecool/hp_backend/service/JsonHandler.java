package com.codecool.hp_backend.service;

import org.springframework.stereotype.Service;

import javax.json.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

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

    public List<String> getMembersIdByHogwartsHouse(String houseName) throws FileNotFoundException {
        JsonArray houseMembers = readHousesFromFile();

        JsonArray members = (houseMembers.getValuesAs(JsonObject.class)
                .stream()
                .filter(obj -> obj.get("name").toString().toUpperCase().equals((houseName.toUpperCase())))
                .findFirst().get().getJsonArray("members"));

        List<String> idOfHouseMembers = new ArrayList<>();
        for (JsonValue member : members) {
            idOfHouseMembers.add(member.toString());
        }

        return idOfHouseMembers;
    }

}
