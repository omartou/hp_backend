package com.codecool.hp_backend.repository;

import com.codecool.hp_backend.entity.House;
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
public class HouseRepositoryTest {

    @Autowired
    private HouseRepository houseRepository;

    @Test
    public void findHouseByNameReturnHouseEntity() {
        House house1 = House.builder()
                .name("house1")
                .build();

        House house2 = House.builder()
                .name("house2")
                .build();

        houseRepository.saveAll(Lists.newArrayList(house1, house2));

        House house = houseRepository.findHouseByName("house1");
        assertEquals(house1, house);
    }

}