package com.codecool.hp_backend.repository;

import com.codecool.hp_backend.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SchoolRepository extends JpaRepository<School, Long> {
    School findSchoolByName(String school);
}
