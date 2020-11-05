package com.codecool.hp_backend.model.generated;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class PotterCharacter {

    public PotterCharacter() {
    }

    public PotterCharacter(String species, String name, String id, String house, String school) {
        this.species = species;
        this.name = name;
        this.id = id;
        this.house = house;
        this.school = school;
    }

    public PotterCharacter(String species, String name, String id, String house, String role, String school) {
        this.species = species;
        this.name = name;
        this.id = id;
        this.house = house;
        this.role = role;
        this.school = school;
    }

    public PotterCharacter(String school, String name, boolean ministryOfMagic) {
        this.school = school;
        this.name = name;
        this.ministryOfMagic = ministryOfMagic;
    }





    @JsonProperty("role")
    private String role;

    @JsonProperty("bloodStatus")
    private String bloodStatus;

    @JsonProperty("school")
    private String school;

    @JsonProperty("species")
    private String species;

    @JsonProperty("deathEater")
    private boolean deathEater;

    @JsonProperty("__v")
    private int V;

    @JsonProperty("dumbledoresArmy")
    private boolean dumbledoresArmy;

    @JsonProperty("name")
    private String name;

    @JsonProperty("ministryOfMagic")
    private boolean ministryOfMagic;

    @JsonProperty("_id")
    private String id;

    @JsonProperty("orderOfThePhoenix")
    private boolean orderOfThePhoenix;

    @JsonProperty("house")
    private String house;

    @JsonProperty("boggart")
    private String boggart;

    @JsonProperty("alias")
    private String alias;

    @JsonProperty("wand")
    private String wand;

    @JsonProperty("patronus")
    private String patronus;

    @JsonProperty("animagus")
    private String animagus;

}