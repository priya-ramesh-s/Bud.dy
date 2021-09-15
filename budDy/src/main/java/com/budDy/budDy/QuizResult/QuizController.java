package com.budDy.budDy.QuizResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "buddy/quizResults")
public class QuizController {

    private QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService){
        this.quizService = quizService;
    }

    @GetMapping
    public List<Quiz> getQuizResults() {
        return quizService.getQuizResults();
    }
    @PostMapping
    public void addQuizResult(@RequestBody Quiz quizResult){
        quizService.addQuizResult(quizResult);
    }

    @DeleteMapping (path = "{quizId}")
    public void deleteQuizResult(@PathVariable("quizId") Long quizId){
        quizService.deleteQuizResult(quizId);
    }

}
