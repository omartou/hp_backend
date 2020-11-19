package com.codecool.hp_backend.repository;

import com.codecool.hp_backend.entity.Animagus;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

//import static org.junit.Assert.*;  //Info: import for junit-vintage-engine (JUnit4)
import static org.junit.jupiter.api.Assertions.*;  //Info: import for junit-jupiter-engine (JUnit5)

@RunWith(SpringRunner.class)
//@ContextConfiguration(classes= OrderServiceConfig.class, loader= AnnotationConfigContextLoader.class)
@DataJpaTest
@ActiveProfiles("test")
public class AnimagusRepositoryTest {

    @Autowired
    private AnimagusRepository animagusRepository;

    @Test
    public void findAnimagusByNameReturnAnimagusEntity() {
        Animagus animagusOne = Animagus.builder()
                .name("animagusOne")
                .build();

        Animagus animagusTwo = Animagus.builder()
                .name("animagusTwo")
                .build();

        animagusRepository.saveAll(Lists.newArrayList(animagusOne, animagusTwo));

        Animagus returnedAnimagus = animagusRepository.findAnimagusByName("animagusTwo");
        assertEquals(animagusTwo, returnedAnimagus);
    }

}