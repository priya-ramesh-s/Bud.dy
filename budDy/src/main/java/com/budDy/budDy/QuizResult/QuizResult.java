package com.budDy.budDy.QuizResult;

import com.budDy.budDy.Plant.Plant;
import com.budDy.budDy.Plant.PlantExperience;
import com.budDy.budDy.Plant.PlantType;
import com.budDy.budDy.User.UserExperience;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
@Entity
@Table(name = "quizResult")
public class QuizResult {
    @Id
    @SequenceGenerator(
            name = "quizResult_sequence",
            sequenceName = "quizResult_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "quizResult_sequence"
    )

    Long id;
    UserExperience userExperience;
    PlantExperience plantExperience;
    PlantType plantType;
//    List<Plant> topThreePlants;
    int plantId_1;
    int plantId_2;
    int plantId_3;

    public QuizResult(){
    }

    public QuizResult(Long id, UserExperience userExperience, PlantExperience plantExperience, PlantType plantType, int plantId_1, int plantId_2, int plantId_3) {
        this.id = id;
        this.userExperience = userExperience;
        this.plantExperience = plantExperience;
        this.plantType = plantType;
        this.plantId_1 = plantId_1;
        this.plantId_2 = plantId_2;
        this.plantId_3 = plantId_3;
    }

    public QuizResult(UserExperience userExperience, PlantExperience plantExperience, PlantType plantType, int plantId_1, int plantId_2, int plantId_3) {
        this.userExperience = userExperience;
        this.plantExperience = plantExperience;
        this.plantType = plantType;
        this.plantId_1 = plantId_1;
        this.plantId_2 = plantId_2;
        this.plantId_3 = plantId_3;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserExperience getUserExperience() {
        return userExperience;
    }

    public void setUserExperience(UserExperience userExperience) {
        this.userExperience = userExperience;
    }

    public PlantExperience getPlantExperience() {
        return plantExperience;
    }

    public void setPlantExperience(PlantExperience plantExperience) {
        this.plantExperience = plantExperience;
    }

    public PlantType getPlantType() {
        return plantType;
    }

    public void setPlantType(PlantType plantType) {
        this.plantType = plantType;
    }

    public int getPlantId_1() {
        return plantId_1;
    }

    public void setPlantId_1(int plantId_1) {
        this.plantId_1 = plantId_1;
    }

    public int getPlantId_2() {
        return plantId_2;
    }

    public void setPlantId_2(int plantId_2) {
        this.plantId_2 = plantId_2;
    }

    public int getPlantId_3() {
        return plantId_3;
    }

    public void setPlantId_3(int plantId_3) {
        this.plantId_3 = plantId_3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuizResult that = (QuizResult) o;
        return plantId_1 == that.plantId_1 && plantId_2 == that.plantId_2 && plantId_3 == that.plantId_3 && Objects.equals(id, that.id) && userExperience == that.userExperience && plantExperience == that.plantExperience && plantType == that.plantType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userExperience, plantExperience, plantType, plantId_1, plantId_2, plantId_3);
    }

    @Override
    public String toString() {
        return "QuizResult{" +
                "id=" + id +
                ", userExperience=" + userExperience +
                ", plantExperience=" + plantExperience +
                ", plantType=" + plantType +
                ", plantId_1=" + plantId_1 +
                ", plantId_2=" + plantId_2 +
                ", plantId_3=" + plantId_3 +
                '}';
    }
}

