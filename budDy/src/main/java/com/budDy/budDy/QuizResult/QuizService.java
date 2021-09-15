package com.budDy.budDy.QuizResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    private QuizResultRepository quizResultRepository;

    @Autowired
    public QuizService(QuizResultRepository quizResultRepository) {
        this.quizResultRepository = quizResultRepository;
    }

    public List<QuizResult> getQuizResults(){
        return quizResultRepository.findAll();
    }


    public void addQuizResult(QuizResult quizResult){
        Optional<QuizResult> quizResultOptional = quizResultRepository.getQuizResultById(quizResult.getId());
        if (quizResultOptional.isPresent()){
            throw new IllegalStateException("Quiz Result with that id already exists.");
        }
        quizResultRepository.save(quizResult);
        System.out.println(quizResult);
    }

    public void deleteQuizResult(Long quizResultId){
        boolean existsById = quizResultRepository.existsById(quizResultId);
        if (!existsById) {
            throw new IllegalStateException("Quiz Result ID " + quizResultId + " was not found");
        } else {
            quizResultRepository.deleteById(quizResultId);
        }
    }
}
