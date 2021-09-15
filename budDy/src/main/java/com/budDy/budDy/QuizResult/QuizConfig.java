package com.budDy.budDy.QuizResult;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class QuizConfig {
    @Bean
    CommandLineRunner commandLineRunner2(QuizRepository repository){
        return args -> {
            Quiz quiz1 = new Quiz(
                    "Beginner",
                    "Beginner",
                    "Indoor",
                    1,
                    2,
                    3
            );
            repository.saveAll(
                    List.of(quiz1)
            );
        };
    }
}
