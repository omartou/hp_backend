package com.codecool.hp_backend;

import com.codecool.hp_backend.service.DBInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class HpBackendApplication {

    @Autowired
    private DBInitializer dbInitializer;

    public static void main(String[] args) {
        SpringApplication.run(HpBackendApplication.class, args);
    }

    @Bean
    @Profile("production")
    public CommandLineRunner init() {
        return args -> {
            dbInitializer.initDB();
        };
    }

}
