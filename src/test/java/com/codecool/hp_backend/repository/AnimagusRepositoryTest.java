package com.codecool.hp_backend.repository;

import com.codecool.hp_backend.entity.Animagus;
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
class AnimagusRepositoryTest {

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