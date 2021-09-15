package com.budDy.budDy.QuizResult;

import com.budDy.budDy.Plant.Plant;
import com.budDy.budDy.Plant.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    private QuizRepository quizRepository;
    private PlantRepository plantRepository;

    @Autowired
    public QuizService(QuizRepository quizRepository, PlantRepository plantRepository) {
        this.quizRepository = quizRepository;
        this.plantRepository = plantRepository;
    }

    public List<Quiz> getQuizResults(){
        return quizRepository.findAll();
    }

//    public List<Plant> getTopThreePlants(Long quizId){
//        Quiz quizToFind = quizRepository.getById(quizId);
//        boolean existsById = quizRepository.existsById(quizId);
//        if (!existsById) {
//            throw new IllegalStateException("Quiz result cannot be updated as id does not exist!");
//        } else {
//            String plantType = quizToFind.getPlantType();
//            String plantExperience = quizToFind.getPlantExperience();
//            String userExperience = quizToFind.getUserExperience();
//            System.out.println(quizToFind);
//            return plantRepository.getTopThreePlants(plantType, plantExperience);
//        }
//    }

    // need a method to save plants to the database

    public void addQuizResult(Quiz quiz){
        Optional<Quiz> quizOptional = quizRepository.getQuizById(quiz.getId());
        if (quizOptional.isPresent()){
            throw new IllegalStateException("Quiz Result with that id already exists.");
        }
        quizRepository.save(quiz);
        System.out.println(quiz);
    }

    public void deleteQuizResult(Long quizId){
        boolean existsById = quizRepository.existsById(quizId);
        if (!existsById) {
            throw new IllegalStateException("Quiz Result ID " + quizId + " was not found");
        } else {
            quizRepository.deleteById(quizId);
        }
    }
    public void updateQuizPlantType(Long quizId, Quiz quiz){
        String plantType = quiz.getPlantType();
        Quiz updateQuizPlantType = quizRepository.getById(quizId);
        boolean existsById = quizRepository.existsById(quizId);
        if (!existsById){
            throw new IllegalStateException("Quiz result cannot be updated as id does not exist!");
        } else {
            updateQuizPlantType.setPlantType(plantType);
            System.out.println(updateQuizPlantType);
            quizRepository.save(updateQuizPlantType);
        }
    }
    public void updateQuizPlantExperience(Long quizId, Quiz quiz) {
        String plantExperience = quiz.getPlantExperience();
        Quiz updateQuizPlantExperience = quizRepository.getById(quizId);
        boolean existsById = quizRepository.existsById(quizId);
        if (!existsById) {
            throw new IllegalStateException("Quiz result cannot be updated as id does not exist!");
        } else {
            updateQuizPlantExperience.setPlantExperience(plantExperience);
            System.out.println(updateQuizPlantExperience);
            quizRepository.save(updateQuizPlantExperience);
        }
    }
    public void updateQuizUserExperience(Long quizId, Quiz quiz) {
        String userExperience = quiz.getUserExperience();
        Quiz updateQuizUserExperience = quizRepository.getById(quizId);
        boolean existsById = quizRepository.existsById(quizId);
        if (!existsById) {
            throw new IllegalStateException("Quiz result cannot be updated as id does not exist!");
        } else {
            updateQuizUserExperience.setUserExperience(userExperience);
            System.out.println(updateQuizUserExperience);
            quizRepository.save(updateQuizUserExperience);
        }
    }

}
