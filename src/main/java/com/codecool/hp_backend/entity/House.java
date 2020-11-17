package com.codecool.hp_backend.entity;

import com.codecool.hp_backend.repository.HouseRepository;
import com.codecool.hp_backend.service.DBInitializer;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class House {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String house;

}
