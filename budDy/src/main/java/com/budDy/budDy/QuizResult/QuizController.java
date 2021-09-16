package com.budDy.budDy.QuizResult;

import com.budDy.budDy.Plant.Plant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    // Quiz option plantType to be "Indoor" or "Outdoor"
    @PutMapping(path = "updatePlantType/{quizId}")
    public void updateQuizPlantType(@PathVariable("quizId") Long quizId, @RequestBody Quiz quiz){
        quizService.updateQuizPlantType(quizId, quiz);
    }

    // Quiz option plantExperience to be "Beginner", "Intermediate" and "Advanced"
    @PutMapping(path = "updatePlantExperience/{quizId}")
    public void updateQuizPlantExperience(@PathVariable("quizId") Long quizId, @RequestBody Quiz quiz){
        quizService.updateQuizPlantExperience(quizId, quiz);
    }

    // Quiz option userExperience to be "Beginner", "Intermediate" and "Advanced"
    @PutMapping(path = "updateUserExperience/{quizId}")
    public void updateQuizUserExperience(@PathVariable("quizId") Long quizId, @RequestBody Quiz quiz){
        quizService.updateQuizUserExperience(quizId, quiz);
    }
//    Give a list of top three plants accordingly and saves them so the user can view them in future
    @GetMapping(path = "getTopThree/{quizId}")
    public List<Plant> getTopThreePlants(@PathVariable("quizId") Long quizId){
        return quizService.getTopThreePlants(quizId);
    }

    @GetMapping(path = "showSavedTopThree/{quizId}")
    public List<Optional<Plant>> showSavedTopThree(@PathVariable("quizId") Long quizId){
        return quizService.getSavedTopThreePlants(quizId);
    }

    @DeleteMapping (path = "{quizId}")
    public void deleteQuizResult(@PathVariable("quizId") Long quizId){
        quizService.deleteQuizResult(quizId);
    }

}
