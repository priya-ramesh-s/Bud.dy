package com.budDy.budDy.QuizResult;

import com.budDy.budDy.Plant.Plant;
import com.budDy.budDy.Plant.PlantExperience;
import com.budDy.budDy.Plant.PlantType;
import com.budDy.budDy.User.UserExperience;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
@Entity
@Table
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
    List<Plant> topThreePlants;

    public QuizResult(){

    }

    public QuizResult(Long id, UserExperience userExperience, PlantExperience plantExperience, PlantType plantType, List<Plant> topThreePlants) {
        this.id = id;
        this.userExperience = userExperience;
        this.plantExperience = plantExperience;
        this.plantType = plantType;
        this.topThreePlants = topThreePlants;
    }

    public QuizResult(UserExperience userExperience, PlantExperience plantExperience, PlantType plantType, List<Plant> topThreePlants) {
        this.userExperience = userExperience;
        this.plantExperience = plantExperience;
        this.plantType = plantType;
        this.topThreePlants = topThreePlants;
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

    public List<Plant> getTopThreePlants() {
        return topThreePlants;
    }

    public void setTopThreePlants(List<Plant> topThreePlants) {
        this.topThreePlants = topThreePlants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuizResult that = (QuizResult) o;
        return Objects.equals(id, that.id) && userExperience == that.userExperience && plantExperience == that.plantExperience && plantType == that.plantType && Objects.equals(topThreePlants, that.topThreePlants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userExperience, plantExperience, plantType, topThreePlants);
    }

    @Override
    public String toString() {
        return "QuizResult{" +
                "id=" + id +
                ", userExperience=" + userExperience +
                ", plantExperience=" + plantExperience +
                ", plantType=" + plantType +
                ", topThreePlants=" + topThreePlants +
                '}';
    }
}




//public class QuizResult {
//    private int quizResultId;
//    private int userId;
//    private String userLevel; //beginner, intermediate or advanced gardener
//    private String effort; // Low, medium or advanced effort plants
//    private String plantLoc; // choose if they want to recommended indoor or outdoor plants
//    private String humidity; // average humidity - humid, normal, dry
//    private String SumTemp; // average Summer temperature - low, normal, high
//    private String WinTemp; //average Winter temperature
//    private String plantType1; // preference for specific types of plants
//    private String plantType2;
//    private String plantType3;
//
//    public QuizResult(int userId) {
//        this.quizResultId = quizResultId;
//        this.userId = userId;
//        this.userLevel = userLevel;
//        this.effort = effort;
//        this.plantLoc = plantLoc;
//        this.humidity = humidity;
//        this.SumTemp = SumTemp;
//        this.WinTemp = WinTemp;
//        this.plantType1 = plantType1;
//        this.plantType2 = plantType2;
//        this.plantType3 = plantType3;
//    }
//
//    public int getQuizResultId() {
//        return quizResultId;
//    }
//
//    public void setQuizResultId(int quizResultId) {
//        this.quizResultId = quizResultId;
//    }
//
//    public int getUserId() {
//        return userId;
//    }
//
//    public void setUserId(int userId) {
//        this.userId = userId;
//    }
//
//    public String getUserLevel() {
//        return userLevel;
//    }
//
//    public void setUserLevel(String userLevel) {
//        this.userLevel = userLevel;
//    }
//
//    public String getEffort() {
//        return effort;
//    }
//
//    public void setEffort(String effort) {
//        this.effort = effort;
//    }
//
//    public String getPlantLoc() {
//        return plantLoc;
//    }
//
//    public void setPlantLoc(String plantLoc) {
//        this.plantLoc = plantLoc;
//    }
//
//    public String getHumidity() {
//        return humidity;
//    }
//
//    public void setHumidity(String humidity) {
//        this.humidity = humidity;
//    }
//
//    public String getSumTemp() {
//        return SumTemp;
//    }
//
//    public void setSumTemp(String sumTemp) {
//        this.SumTemp = sumTemp;
//    }
//
//    public String getWinTemp() {
//        return WinTemp;
//    }
//
//    public void setWinTemp(String winTemp) {
//        WinTemp = winTemp;
//    }
//
//    public String getPlantType1() {
//        return plantType1;
//    }
//
//    public void setPlantType1(String plantType1) {
//        this.plantType1 = plantType1;
//    }
//
//    public String getPlantType2() {
//        return plantType2;
//    }
//
//    public void setPlantType2(String plantType2) {
//        this.plantType2 = plantType2;
//    }
//
//    public String getPlantType3() {
//        return plantType3;
//    }
//
//    public void setPlantType3(String plantType3) {
//        this.plantType3 = plantType3;
//    }
//
//    @Override
//    public String toString() {
//        return "QuizResult{" +
//                "quizResultId=" + quizResultId +
//                ", userId=" + userId +
//                ", userLevel='" + userLevel + '\'' +
//                ", effort='" + effort + '\'' +
//                ", plantLoc='" + plantLoc + '\'' +
//                ", humidity='" + humidity + '\'' +
//                ", SumTemp='" + SumTemp + '\'' +
//                ", WinTemp='" + WinTemp + '\'' +
//                ", plantType1='" + plantType1 + '\'' +
//                ", plantType2='" + plantType2 + '\'' +
//                ", plantType3='" + plantType3 + '\'' +
//                '}';
//    }
//}

