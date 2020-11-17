package com.codecool.hp_backend.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.startup.HomesUserDatabase;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Character {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne
    private House house;

}