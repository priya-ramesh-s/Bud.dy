package com.budDy.budDy;

//import com.budDy.budDy.Plant.PlantService;
////import com.budDy.budDy.QuizResult.QuizQuestions;
////import com.budDy.budDy.QuizResult.QuizService;
//import com.budDy.budDy.User.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BudDyApplication {
//	private static PlantService plantService;
//	private static QuizService quizService;
//	private static UserService userService;
//
//	public BudDyApplication(PlantService plantService, QuizService quizService, UserService userService){
//		this.plantService = plantService;
//		this.quizService = quizService;
//		this.userService = userService;
//	}

	public static void main(String[] args) {
		SpringApplication.run(BudDyApplication.class, args);
//		QuizQuestions q = new QuizQuestions(plantService, quizService, userService);
//		q.intro();
	}
}
