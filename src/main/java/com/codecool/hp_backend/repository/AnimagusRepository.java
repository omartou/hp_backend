package com.codecool.hp_backend.repository;

import com.codecool.hp_backend.entity.Animagus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AnimagusRepository extends JpaRepository<Animagus, Long> {
    Animagus findAnimagusByName(String animagus);

    @Query("SELECT a.name FROM Animagus a WHERE a.id = :id")
    String getAnimagusNameById(@Param("id") Long id);
}
