package com.codecool.hp_backend.controller;

import com.codecool.hp_backend.model.generated.PotterCharacter;
import com.codecool.hp_backend.service.DataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    private final DataHandler dataHandler;

    @Autowired
    public QuizController(DataHandler dataHandler) {
        this.dataHandler = dataHandler;
    }

    @GetMapping("/house/random")
    public PotterCharacter getRandomHouseQuizCharacter() {
        return dataHandler.getRandomHouseQuizCharacter();
    }

}
