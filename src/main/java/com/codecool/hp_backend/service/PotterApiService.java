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

import javax.json.JsonArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PotterApiService {

    @Value("${potterapi.url}")
    private String potterApiUrl;

    @Value("${apikey}")
    private String apiKey;



    public List<PotterCharacter> generateCharacter(List<String> idOfCharacters) {
        List<PotterCharacter> characters = new ArrayList<>();

        for (String idOfCharacter : idOfCharacters) {
            System.out.println(idOfCharacter);
            characters.add(getCharacterById(idOfCharacter));
        }

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

    public List<String> getAllCharactersId() {
        RestTemplate template = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();
        List<String> idOfCharacters = new ArrayList<>();

        var response = template.getForEntity(potterApiUrl + apiKey,
                String.class);
        try {
            JsonNode root = mapper.readTree(response.getBody());
            for (var elem : root) {
                var id =  elem.get("_id").toString();
                id = id.substring(1, id.length() -1);
                idOfCharacters.add(id);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return idOfCharacters;
    }
}
