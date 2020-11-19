package com.codecool.hp_backend.repository;

import com.codecool.hp_backend.entity.BloodStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BloodStatusRepository extends JpaRepository<BloodStatus, Long> {
    BloodStatus findBloodStatusByName(String bloodStatus);

}
