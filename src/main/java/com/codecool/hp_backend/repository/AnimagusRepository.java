package com.codecool.hp_backend.repository;

import com.codecool.hp_backend.entity.Animagus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimagusRepository extends JpaRepository<Animagus, Long> {
    Animagus findAnimagusByName(String animagus);
}
