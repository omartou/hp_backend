package com.codecool.hp_backend.repository;

import com.codecool.hp_backend.entity.Core;
import com.codecool.hp_backend.entity.Wand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface WandRepository extends JpaRepository<Wand, Long> {
    @Query("SELECT w FROM Wand w WHERE w.wood = :wood AND w.length = :length AND w.core = :core")
    Wand getWandByParams(@Param("wood") String wood,
                         @Param("length") String length,
                         @Param("core") Core core);
}
