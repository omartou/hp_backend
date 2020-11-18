package com.codecool.hp_backend.repository;

import com.codecool.hp_backend.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Long> {
    School findSchoolByName(String school);
}
