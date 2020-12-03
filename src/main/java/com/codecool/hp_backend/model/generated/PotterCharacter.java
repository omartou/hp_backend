package com.codecool.hp_backend.model.generated;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PotterCharacter {

//    public PotterCharacter() {
//    }

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




    @JsonProperty("_id")
    private String id;

    @JsonProperty("user")
    private boolean user;

    @JsonProperty("name")
    private String name;

    @JsonProperty("role")
    private String role;

    @JsonProperty("house")
    private String house;

    @JsonProperty("school")
    private String school;

    @JsonProperty("__v")
    private int V;

    @JsonProperty("ministryOfMagic")
    private boolean ministryOfMagic;

    @JsonProperty("orderOfThePhoenix")
    private boolean orderOfThePhoenix;

    @JsonProperty("dumbledoresArmy")
    private boolean dumbledoresArmy;

    @JsonProperty("bloodStatus")
    private String bloodStatus;

    @JsonProperty("deathEater")
    private boolean deathEater;

    @JsonProperty("species")
    private String species;

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