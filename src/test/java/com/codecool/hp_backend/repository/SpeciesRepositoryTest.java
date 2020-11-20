package com.codecool.hp_backend.repository;

import com.codecool.hp_backend.entity.Species;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
class SpeciesRepositoryTest {

    @Autowired
    private SpeciesRepository speciesRepository;


    @Test
    public void findSpeciesByNameReturnSpeciesEntity() {
        Species species1 = Species.builder()
                .name("species1")
                .build();

        Species species2 = Species.builder()
                .name("species2")
                .build();

        speciesRepository.saveAll(Lists.newArrayList(species1, species2));

        Species species = speciesRepository.findSpeciesByName("species1");
        assertEquals(species1, species);
    }

}