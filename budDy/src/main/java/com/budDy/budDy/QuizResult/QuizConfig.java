package com.budDy.budDy.QuizResult;

import com.budDy.budDy.Plant.PlantExperience;
import com.budDy.budDy.Plant.PlantType;
import com.budDy.budDy.User.UserExperience;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class QuizConfig {
    @Bean
    CommandLineRunner commandLineRunner2(QuizResultRepository repository){
        return args -> {
            QuizResult quizResult1 = new QuizResult(
                    UserExperience.BEGINNER,
                    PlantExperience.BEGINNER,
                    PlantType.INDOOR,
                    1,
                    2,
                    3
            );
            repository.saveAll(
                    List.of(quizResult1)
            );
        };
    }
}
