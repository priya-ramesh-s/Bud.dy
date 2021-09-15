package com.budDy.budDy.QuizResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    private QuizRepository quizRepository;

    @Autowired
    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public List<Quiz> getQuizResults(){
        return quizRepository.findAll();
    }


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
}
