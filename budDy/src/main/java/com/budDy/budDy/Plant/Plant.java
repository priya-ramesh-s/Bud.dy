package com.budDy.budDy.Plant;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table
public class Plant {
    @Id
    @SequenceGenerator(
            name = "plant_sequence",
            sequenceName = "plant_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "plant_sequence"
    )

    Long id;
    String name;
    String latinName;
    String plantType;
    String water;
    String light;
    String plantExperience;
    int rating;

    public Plant(){
    }

    public Plant(Long id, String name, String latinName, String plantType, String water, String light, String plantExperience, int rating) {
        this.id = id;
        this.name = name;
        this.latinName = latinName;
        this.plantType = plantType;
        this.water = water;
        this.light = light;
        this.plantExperience = plantExperience;
        this.rating = rating;
    }

    public Plant(String name, String latinName, String plantType, String water, String light, String plantExperience, int rating) {
        this.name = name;
        this.latinName = latinName;
        this.plantType = plantType;
        this.water = water;
        this.light = light;
        this.plantExperience = plantExperience;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLatinName() {
        return latinName;
    }

    public void setLatinName(String latinName) {
        this.latinName = latinName;
    }

    public String getPlantType() {
        return plantType;
    }

    public void setPlantType(String plantType) {
        this.plantType = plantType;
    }

    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water = water;
    }

    public String getLight() {
        return light;
    }

    public void setLight(String light) {
        this.light = light;
    }

    public String getPlantExperience() {
        return plantExperience;
    }

    public void setPlantExperience(String plantExperience) {
        this.plantExperience = plantExperience;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plant plant = (Plant) o;
        return rating == plant.rating && Objects.equals(id, plant.id) && Objects.equals(name, plant.name) && Objects.equals(latinName, plant.latinName) && Objects.equals(plantType, plant.plantType) && Objects.equals(water, plant.water) && Objects.equals(light, plant.light) && Objects.equals(plantExperience, plant.plantExperience);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, latinName, plantType, water, light, plantExperience, rating);
    }

    @Override
    public String toString() {
        return "Plant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", latinName='" + latinName + '\'' +
                ", plantType='" + plantType + '\'' +
                ", water='" + water + '\'' +
                ", light='" + light + '\'' +
                ", plantExperience='" + plantExperience + '\'' +
                ", rating=" + rating +
                '}';
    }
}
