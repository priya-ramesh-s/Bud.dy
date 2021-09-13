package com.budDy.budDy.Plant;

import java.util.Objects;

public class Plant {
    private String name;
    private String latinName;
    private String plantType;
    private String water;
    private String light;
    private String experience;
    private int rating;

    public Plant(String name, String latinName, String plantType, String water, String light, String experience, int rating) {
        this.name = name;
        this.latinName = latinName;
        this.plantType = plantType;
        this.water = water;
        this.light = light;
        this.experience = experience;
        this.rating = rating;
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

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
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
        return rating == plant.rating && Objects.equals(name, plant.name) && Objects.equals(latinName, plant.latinName) && Objects.equals(plantType, plant.plantType) && Objects.equals(water, plant.water) && Objects.equals(light, plant.light) && Objects.equals(experience, plant.experience);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, latinName, plantType, water, light, experience, rating);
    }

    @Override
    public String toString() {
        return "Plant{" +
                "name='" + name + '\'' +
                ", latinName='" + latinName + '\'' +
                ", plantType='" + plantType + '\'' +
                ", water='" + water + '\'' +
                ", light='" + light + '\'' +
                ", experience='" + experience + '\'' +
                ", rating=" + rating +
                '}';
    }

}
