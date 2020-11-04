package com.codecool.hp_backend.controller;

import com.codecool.hp_backend.model.generated.PotterCharacter;
import com.codecool.hp_backend.service.CharacterStorage;
import com.codecool.hp_backend.service.JsonHandler;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import javax.json.JsonArray;
import javax.json.JsonObject;

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

    @Autowired
    public OtherContoller(JsonHandler jsonHandler,
                          PotterApiService potterApiService,
                          CharacterStorage characterStorage) {
        this.jsonHandler = jsonHandler;
        this.potterApiService = potterApiService;
        this.characterStorage = characterStorage;
    }

    @GetMapping("/other")
    public String getOtherCharacters() throws FileNotFoundException {
        JsonArray characters = jsonHandler.readCharactersFromFile();

        List<JsonObject> otherCharacters = characters.getValuesAs(JsonObject.class)
                .stream()
                .filter(obj -> obj.containsKey("ministryOfMagic"))
                .filter(obj -> !Boolean.parseBoolean(obj.get("ministryOfMagic").toString()))
                .filter(obj -> !obj.containsKey("school") || !obj.get("school").toString()
                        .equals("Hogwarts School of Witchcraft and Wizardry"))
                .collect(Collectors.toList());

        return otherCharacters.toString();
    }

    @GetMapping("/ministry")
    public String getMinistryCharacters() throws FileNotFoundException {
        JsonArray characters = jsonHandler.readCharactersFromFile();

        List<JsonObject> ministryOfMagicCharacters = characters.getValuesAs(JsonObject.class)
                .stream()
                .filter(obj -> obj.containsKey("ministryOfMagic"))
                .filter(obj -> Boolean.parseBoolean(obj.get("ministryOfMagic").toString()))
                .collect(Collectors.toList());

        return ministryOfMagicCharacters.toString();
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


