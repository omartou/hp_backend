package com.codecool.hp_backend.controller;

import com.codecool.hp_backend.model.generated.PotterCharacter;
import com.codecool.hp_backend.service.DataHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class OtherCharacterController {

    private final DataHandler dataHandler;

    @Autowired
    public OtherCharacterController(@Qualifier("dataHandlerDB") DataHandler dataHandler) {
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

    @PutMapping("/character/{id}")
    public ResponseEntity<?> updateCharacterById(@PathVariable("id") Long id,
                                                 @RequestBody PotterCharacter character) {
        dataHandler.updateCharacterById(id, character);
        return ResponseEntity.ok("Character [" +  character.getName() + "] updated successfully");
    }

//    @PutMapping("/character/{id}")
//    public ResponseEntity<?> updateCharacterById(@PathVariable("id") String id,
//                                                 @RequestBody PotterCharacter character) {
//        dataHandler.updateCharacterById(Long.parseLong(id), character);
//        return ResponseEntity.ok("Character [" +  character.getName() + "] updated successfully");
//    }

}


