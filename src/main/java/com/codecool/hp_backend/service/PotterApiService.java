package com.codecool.hp_backend.service;

import com.codecool.hp_backend.model.generated.PotterCharacter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class PotterApiService {

    @Value("${potterapi.url}")
    private String potterApiUrl;

    @Value("${apikey}")
    private String apiKey;

    List<String> idOfCharacters = new ArrayList<>();

    public List<PotterCharacter> generateAllCharacter() {
        List<PotterCharacter> characters = new ArrayList<>();

        for (String idOfCharacter : idOfCharacters) {
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
}
