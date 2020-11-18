package com.codecool.hp_backend.repository;

import com.codecool.hp_backend.entity.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SpeciesRepository extends JpaRepository<Species, Long> {
    Species findSpeciesByName(String species);

    @Query("SELECT sp.name FROM Species sp WHERE sp.id = :id")
    String getSpeciesNameById(@Param("id") Long id);
}
