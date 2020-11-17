package com.codecool.hp_backend.service;

import com.codecool.hp_backend.model.generated.PotterCharacter;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import org.springframework.stereotype.Service;

import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class JsonHandler implements CharacterProvider {

    private static final String FILE_PATH =  "./src/main/resources/static/characters.json";

    @Override
    public Map<String, PotterCharacter> getAllCharacters() {
        Map<String, PotterCharacter> characters = new LinkedHashMap<>();
        ObjectMapper mapper = new ObjectMapper();

        try {
            JsonNode content = mapper.readTree(Paths.get(FILE_PATH).toFile());
            if (content.getNodeType().equals(JsonNodeType.ARRAY)) {
                for (JsonNode jsonNode : content) {
                    PotterCharacter character = mapper.treeToValue(jsonNode, PotterCharacter.class);
                    characters.put(character.getId(), character);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return characters;
    }

}
