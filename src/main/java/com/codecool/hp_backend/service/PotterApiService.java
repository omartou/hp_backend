package com.codecool.hp_backend.service;

import com.codecool.hp_backend.model.generated.PotterCharacter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//import javax.json.JsonArray;
import java.util.*;
//import java.util.Arrays;


@Service
public class PotterApiService {

    @Value("${potterapi.url}")
    private String potterApiUrl;

    @Value("${apikey}")
    private String apiKey;

    public Map<String, PotterCharacter> generateCharacters(List<String> idOfCharacters) {
        System.out.println("Start generating characters...");
        Map<String, PotterCharacter> characters = new LinkedHashMap<>();

        int counter = 1;
        for (String idOfCharacter : idOfCharacters) {
            System.out.println(counter + ": " + idOfCharacter);
            characters.put(idOfCharacter, getCharacterById(idOfCharacter));
            counter++;
        }
        System.out.println(characters.size() + " characters generated successfully!");
        return characters;
    }

    public PotterCharacter getCharacterById(String id) {
        RestTemplate template = new RestTemplate();
        ResponseEntity<PotterCharacter> potterCharacterResponseEntity =
                template.exchange(potterApiUrl + id + apiKey,
                        HttpMethod.GET,
                        null,
                        PotterCharacter.class);
        return potterCharacterResponseEntity.getBody();
    }

    public List<String> getIdOfCharacters() {
        RestTemplate template = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();
        List<String> idOfCharacters = new ArrayList<>();

        ResponseEntity<String> response = template.getForEntity(potterApiUrl + apiKey,
                String.class);
        try {
            JsonNode root = mapper.readTree(response.getBody());
            for (JsonNode elem : root) {
                String id =  elem.get("_id").toString();
                id = id.substring(1, id.length() -1);
                idOfCharacters.add(id);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return idOfCharacters;
    }
}
