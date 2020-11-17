package com.codecool.hp_backend.repository;

import com.codecool.hp_backend.entity.Species;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeciesRepository extends JpaRepository<Species, Long> {

}
