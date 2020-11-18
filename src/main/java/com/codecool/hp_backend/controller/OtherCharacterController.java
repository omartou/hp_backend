package com.codecool.hp_backend.controller;

import com.codecool.hp_backend.service.DataHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class OtherCharacterController {

    private final DataHandler dataHandler;

    @Autowired
    public OtherCharacterController(@Qualifier("DBDataHandler") DataHandler dataHandler) {
        this.dataHandler = dataHandler;
    }

    @GetMapping("/other")
    public ResponseEntity<Object> getOtherCharacters() {
        return ResponseEntity.ok(dataHandler.getOtherCharacters());
    }

    @GetMapping("/ministry")
    public ResponseEntity<Object> getMinistryCharacters() {
        return ResponseEntity.ok(dataHandler.getMinistryOfMagicCharacters());
    }

    @GetMapping("/character/{id}")
    public ResponseEntity<Object> getCharacterById(@PathVariable("id") String id) {
        try {
            return ResponseEntity.ok(dataHandler.getCharacterById(id));
        } catch (NullPointerException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}


