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
    PlantType plantType;
    String water;
    String light;
    PlantExperience experience;
    int rating;

    public Plant(Long id, String name, String latinName, PlantType plantType, String water, String light, PlantExperience experience, int rating) {
        this.id = id;
        this.name = name;
        this.latinName = latinName;
        this.plantType = plantType;
        this.water = water;
        this.light = light;
        this.experience = experience;
        this.rating = rating;
    }

    public Plant(String name, String latinName, PlantType plantType, String water, String light, PlantExperience experience, int rating) {
        this.name = name;
        this.latinName = latinName;
        this.plantType = plantType;
        this.water = water;
        this.light = light;
        this.experience = experience;
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

    public PlantType getPlantType() {
        return plantType;
    }

    public void setPlantType(PlantType plantType) {
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

    public PlantExperience getExperience() {
        return experience;
    }

    public void setExperience(PlantExperience experience) {
        this.experience = experience;
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
        return rating == plant.rating && Objects.equals(id, plant.id) && Objects.equals(name, plant.name) && Objects.equals(latinName, plant.latinName) && plantType == plant.plantType && Objects.equals(water, plant.water) && Objects.equals(light, plant.light) && experience == plant.experience;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, latinName, plantType, water, light, experience, rating);
    }

    @Override
    public String toString() {
        return "Plant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", latinName='" + latinName + '\'' +
                ", plantType=" + plantType +
                ", water='" + water + '\'' +
                ", light='" + light + '\'' +
                ", experience=" + experience +
                ", rating=" + rating +
                '}';
    }
}
