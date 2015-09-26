package br.com.ceduphh.bruno.pokedex;

import java.io.Serializable;

public class Pokemon implements Serializable {

    private final String name;
    private final int nationalNumber;
    private final Type primaryType;
    private final Type secondaryType;
    private final String species;
    private final String height;
    private final String weight;
    private final String abilities1;
    private final String abilities2;
    private final String abilities3;


    public Pokemon(String name, int nationalNumber,String species, String height,  String weight, String abilities1, String abilities2, String abilities3,  Type primaryType, Type secondaryType) {
        this.name = name;
        this.nationalNumber = nationalNumber;
        this.primaryType = primaryType;
        this.secondaryType = secondaryType;
        this.species = species;
        this.height = height;
        this.weight = weight;
        this.abilities1 = abilities1;
        this.abilities2 = abilities2;
        this.abilities3 = abilities3;
    }

    public String getName() {
        return name;
    }

    public int getNationalNumber() {
        return nationalNumber;
    }

    public Type getPrimaryType() {
        return primaryType;
    }

    public Type getSecondaryType() {
        return secondaryType;
    }
    public String getSpecies() {
        return species;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }

    public String getAbilities1() {
        return abilities1;
    }

    public String getAbilities2() {
        return abilities2;
    }

    public String getAbilities3() {
        return abilities3;
    }


}
