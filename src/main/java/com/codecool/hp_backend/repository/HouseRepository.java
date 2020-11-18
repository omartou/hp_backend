package com.codecool.hp_backend.repository;

import com.codecool.hp_backend.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepository extends JpaRepository<House, Long> {
    House findHouseByName(String house);
}
