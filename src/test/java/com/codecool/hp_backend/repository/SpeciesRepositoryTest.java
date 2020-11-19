package com.codecool.hp_backend.repository;

import com.codecool.hp_backend.entity.Species;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

//import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class SpeciesRepositoryTest {

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