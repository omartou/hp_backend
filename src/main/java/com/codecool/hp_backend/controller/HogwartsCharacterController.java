package com.codecool.hp_backend.controller;

import com.codecool.hp_backend.service.DataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/hogwarts")
public class HogwartsCharacterController {

    private final DataHandler dataHandler;

    @Autowired
    HogwartsCharacterController(@Qualifier("dataHandlerDB") DataHandler dataHandler) {
        this.dataHandler = dataHandler;
    }

    @GetMapping("/houses/{houseName}")
    public ResponseEntity<Object> getCharactersByHouseName(@PathVariable("houseName") String houseName) {
        return ResponseEntity.ok(dataHandler.getHogwartsHouseCharacters(houseName));
    }

    @GetMapping("/employees")
    public ResponseEntity<Object> getEmployees() {
        return ResponseEntity.ok(dataHandler.getHogwartsEmployees());
    }
}
