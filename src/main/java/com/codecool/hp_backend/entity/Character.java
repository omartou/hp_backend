package com.codecool.hp_backend.entity;

import javax.persistence.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Character {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    @Builder.Default
    private boolean user = true;

    @Column(nullable = false, unique = true)
    private String name;

    private String role;

    @EqualsAndHashCode.Exclude
    @ManyToOne
    private House house;

    @EqualsAndHashCode.Exclude
    @ManyToOne
    private School school;

    @Column(nullable = false)
    private boolean ministryOfMagics;

    @Column(nullable = false)
    private boolean orderOfPhoenix;

    @Column(nullable = false)
    private boolean dumbledoresArmy;

    @EqualsAndHashCode.Exclude
    @ManyToOne
    private BloodStatus bloodStatus;

    @Column(nullable = false)
    private boolean deathEater;

    @EqualsAndHashCode.Exclude
    @ManyToOne
    private Species species;

    private String boggart;

    private String alias;

    @EqualsAndHashCode.Exclude
    @OneToOne
    private Wand wand;

    private String patronus;

    @EqualsAndHashCode.Exclude
    @ManyToOne
    private Animagus animagus;

}