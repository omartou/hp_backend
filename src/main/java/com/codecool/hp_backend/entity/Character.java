package com.codecool.hp_backend.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    private String role;

    @ManyToOne
    private House house;

    private String school;

    private boolean ministryOfMagics;

    private boolean orderOfPhoenix;

    private boolean dumbledoresArmy;

    @ManyToOne
    private BloodStatus bloodStatus;

    private boolean deathEater;

    @ManyToOne
    private Species species;

    private String boggart;

    private String alias;

    private String wand;

    private String patronus;

    @ManyToOne
    private Animagus animagus;

}