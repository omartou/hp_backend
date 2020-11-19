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

    @ManyToOne
    private School school;

    @Column(nullable = false)
    private boolean ministryOfMagics;

    @Column(nullable = false)
    private boolean orderOfPhoenix;

    @Column(nullable = false)
    private boolean dumbledoresArmy;

    @ManyToOne
    private BloodStatus bloodStatus;

    @Column(nullable = false)
    private boolean deathEater;

    @ManyToOne
    private Species species;

    private String boggart;

    private String alias;

    @OneToOne
    private Wand wand;

    private String patronus;

    @ManyToOne
    private Animagus animagus;

}