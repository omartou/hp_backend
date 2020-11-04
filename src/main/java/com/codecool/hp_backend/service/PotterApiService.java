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
import java.util.*;



@Service
public class PotterApiService {

    @Value("${potterapi.url}")
    private String potterApiUrl;

    @Value("${apikey}")
    private String apiKey;


    public Map<String, PotterCharacter> getAllCharacters() {
        RestTemplate template = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();
        Map<String, PotterCharacter> characters = new LinkedHashMap<>();
        ResponseEntity<String> response = template.getForEntity(potterApiUrl + apiKey, String.class);
        try {
            JsonNode root = mapper.readTree(response.getBody());
            for (JsonNode node : root) {
                String id =  node.get("_id").toString();
                id = id.substring(1, id.length() -1);
                PotterCharacter character = mapper.treeToValue(node, PotterCharacter.class);
                characters.put(id, character);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return characters;
    }
}
