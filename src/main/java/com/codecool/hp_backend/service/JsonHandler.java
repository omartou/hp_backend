package com.codecool.hp_backend.service;

import org.springframework.stereotype.Service;

import javax.json.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

        Optional<JsonObject> membersObject = (houseMembers.getValuesAs(JsonObject.class)
                .stream()
                .filter(obj -> obj.get("name").toString().toUpperCase().equals((houseName.toUpperCase())))
                .findFirst());

        JsonArray members = null;
        if (membersObject.isPresent()) {
            members = membersObject.get().getJsonArray("members");
        }

        List<String> idOfHouseMembers = new ArrayList<>();
        if (members != null) {
            for (JsonValue member : members) {
                idOfHouseMembers.add(member.toString());
            }
        }

        return idOfHouseMembers;
    }

}
