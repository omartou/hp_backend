package com.codecool.hp_backend.repository;

import com.codecool.hp_backend.entity.School;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class SchoolRepositoryTest {

    @Autowired
    private SchoolRepository schoolRepository;

    @Test
    public void findSchoolByNameReturnSchoolEntity() {
        School school1 = School.builder()
                .name("school1")
                .build();

        School school2 = School.builder()
                .name("school2")
                .build();

        schoolRepository.saveAll(Lists.newArrayList(school1, school2));

        School school = schoolRepository.findSchoolByName("school1");
        assertEquals(school1, school);
    }

}