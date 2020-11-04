package com.codecool.hp_backend.model.generated;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PotterCharacter {

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

	public String getRole(){
		return role;
	}

	public String getBloodStatus(){
		return bloodStatus;
	}

	public String getSchool(){
		return school;
	}

	public String getSpecies(){
		return species;
	}

	public boolean isDeathEater(){
		return deathEater;
	}

	public int getV(){
		return V;
	}

	public boolean isDumbledoresArmy(){
		return dumbledoresArmy;
	}

	public String getName(){
		return name;
	}

	public boolean isMinistryOfMagic(){
		return ministryOfMagic;
	}

	public String getId(){
		return id;
	}

	public boolean isOrderOfThePhoenix(){
		return orderOfThePhoenix;
	}

	public String getHouse(){
		return house;
	}

	public String getBoggart() {
		return boggart;
	}

	public String getAlias() {
		return alias;
	}

	public String getWand() {
		return wand;
	}

	public String getPatronus() {
		return patronus;
	}

	public String getAnimagus() {
		return animagus;
	}
}