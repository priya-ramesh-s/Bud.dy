package com.budDy.budDy.QuizResult;

import com.budDy.budDy.Plant.PlantExperience;
import com.budDy.budDy.Plant.PlantType;
import com.budDy.budDy.User.UserExperience;

import javax.persistence.*;
import java.util.Objects;
@Entity
@Table(name = "quiz")
public class Quiz {
    @Id
    @SequenceGenerator(
            name = "quiz_sequence",
            sequenceName = "quiz_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "quiz_sequence"
    )

    Long id;
    String userExperience;
    String plantExperience;
    String plantType;
    Long plantId_1;
    Long plantId_2;
    Long plantId_3;

    public Quiz(){
    }

    public Quiz(Long id, String userExperience, String plantExperience, String plantType, Long plantId_1, Long plantId_2, Long plantId_3) {
        this.id = id;
        this.userExperience = userExperience;
        this.plantExperience = plantExperience;
        this.plantType = plantType;
        this.plantId_1 = plantId_1;
        this.plantId_2 = plantId_2;
        this.plantId_3 = plantId_3;
    }

    public Quiz(String userExperience, String plantExperience, String plantType, Long plantId_1, Long plantId_2, Long plantId_3) {
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

    public String getUserExperience() {
        return userExperience;
    }

    public void setUserExperience(String userExperience) {
        this.userExperience = userExperience;
    }

    public String getPlantExperience() {
        return plantExperience;
    }

    public void setPlantExperience(String plantExperience) {
        this.plantExperience = plantExperience;
    }

    public String getPlantType() {
        return plantType;
    }

    public void setPlantType(String plantType) {
        this.plantType = plantType;
    }

    public Long getPlantId_1() {
        return plantId_1;
    }

    public void setPlantId_1(Long plantId_1) {
        this.plantId_1 = plantId_1;
    }

    public Long getPlantId_2() {
        return plantId_2;
    }

    public void setPlantId_2(Long plantId_2) {
        this.plantId_2 = plantId_2;
    }

    public Long getPlantId_3() {
        return plantId_3;
    }

    public void setPlantId_3(Long plantId_3) {
        this.plantId_3 = plantId_3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quiz quiz = (Quiz) o;
        return Objects.equals(id, quiz.id) && Objects.equals(userExperience, quiz.userExperience) && Objects.equals(plantExperience, quiz.plantExperience) && Objects.equals(plantType, quiz.plantType) && Objects.equals(plantId_1, quiz.plantId_1) && Objects.equals(plantId_2, quiz.plantId_2) && Objects.equals(plantId_3, quiz.plantId_3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userExperience, plantExperience, plantType, plantId_1, plantId_2, plantId_3);
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", userExperience='" + userExperience + '\'' +
                ", plantExperience='" + plantExperience + '\'' +
                ", plantType='" + plantType + '\'' +
                ", plantId_1=" + plantId_1 +
                ", plantId_2=" + plantId_2 +
                ", plantId_3=" + plantId_3 +
                '}';
    }
}

