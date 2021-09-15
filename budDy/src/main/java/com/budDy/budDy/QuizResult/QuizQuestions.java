package com.budDy.budDy.QuizResult;

import com.budDy.budDy.Plant.Plant;
import com.budDy.budDy.Plant.PlantExperience;
import com.budDy.budDy.Plant.PlantService;
import com.budDy.budDy.Plant.PlantType;
import com.budDy.budDy.User.UserExperience;
import com.budDy.budDy.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;


public class QuizQuestions {
//    private PlantService plantService;
//    private QuizService quizService;
//    private UserService userService;
//
//    @Autowired
//    public QuizQuestions(PlantService plantService, QuizService quizService, UserService userService){
//        this.plantService = plantService;
//        this.quizService = quizService;
//        this.userService = userService;
//    }
//
//    public void intro() {
//        System.out.println("Thank you for choosing to take the budDy personality quiz!");
//        System.out.println("Your answers will be used to help us find your one true bud!");
//
//        QuizResult newQuizResult = new QuizResult(null, null, null, null);
//
//        askLevel(newQuizResult);
//    }
//
//    public void askLevel(QuizResult newQuizResult) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Let's begin!");
//        System.out.println("What level gardener would you count yourself as?");
//        System.out.println("Total beginner: press 1");
//        System.out.println("Intermediate, I've cared for a few plants which have survived longer than a week: press 2");
//        System.out.println("Expert, green thumb who can handle any plant life throws at you: press 3");
//        label:
//        while(true) {
//            String level = scanner.nextLine();
//            switch (level) {
//                case "1" -> {
////                    String levelResult = "BEGINNER";
//                    UserExperience levelResult = UserExperience.BEGINNER;
//                    newQuizResult.setUserExperience(UserExperience.BEGINNER);
//                    System.out.println(levelResult);
//                    break label;
//                }
//                case "2" -> {
////                    String levelResult = "INTERMEDIATE";
//                    UserExperience levelResult = UserExperience.INTERMEDIATE;
//                    newQuizResult.setUserExperience(UserExperience.INTERMEDIATE);
//                    System.out.println(levelResult);
//                    break label;
//                }
//                case "3" -> {
////                    String levelResult = "ADVANCED";
//                    UserExperience levelResult = UserExperience.ADVANCED;
//                    newQuizResult.setUserExperience(UserExperience.ADVANCED);
//                    System.out.println(levelResult);
//                    break label;
//                }
//                default -> {
//                    System.out.println("Invalid input, try again!");
//                }
//            }
//        }
//        askEffort(newQuizResult);
//    }
//
//    public void askEffort(QuizResult newQuizResult) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("How much effort are you looking to put in?");
//        System.out.println("Almost no effort, the plant should practically look after itself: press 1");
//        System.out.println("A medium amount of effort, I need to feel needed by the plant: press 2");
//        System.out.println("I want a challenge: press 3");
//
//        label:
//        while (true) {
//            String effort = scanner.nextLine();
//            switch (effort) {
//                case "1" -> {
//                    String effortResult = "Basic";
//                    System.out.println(effortResult);
//                    newQuizResult.setPlantExperience(PlantExperience.BEGINNER);
//                    break label;
//                }
//                case "2" -> {
//                    String effortResult = "Intermediate";
//                    System.out.println(effortResult);
//                    newQuizResult.setPlantExperience(PlantExperience.INTERMEDIATE);
//                    break label;
//                }
//                case "3" -> {
//                    String effortResult = "Advanced";
//                    System.out.println(effortResult);
//                    newQuizResult.setPlantExperience(PlantExperience.ADVANCED);
//                    break label;
//                }
//                default -> {
//                    System.out.println("Invalid input, try again!");
//                }
//            }
//        }
//        askPlantLoc(newQuizResult);
//    }
//
//    public void askPlantLoc(QuizResult newQuizResult) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Will your new budDy be living inside or outside?");
//        System.out.println("Inside! I'm looking for a new roommate: press 1");
//        System.out.println("Outside, where plants belong: press 2");
//
//        label:
//        while(true) {
//            String loc = scanner.nextLine();
//            switch (loc) {
//                case "1" -> {
////                    String locationResult = "INDOOR";
//                    PlantType locationResult = PlantType.INDOOR;
//                    newQuizResult.setPlantType(PlantType.INDOOR);
//                    System.out.println(locationResult);
//                    break label;
//                }
//                case "2" -> {
////                    String locationResult = "OUTDOOR";
//                    PlantType locationResult = PlantType.OUTDOOR;
//                    newQuizResult.setPlantType(PlantType.OUTDOOR);
//                    System.out.println(locationResult);
//                    break label;
//                }
//                default -> {
//                    System.out.println("Option not recognised - please select an option between 1 and 2");
//                }
//            }
//        }
//        askHumidity(newQuizResult);
//    }
//
//    public void askHumidity(QuizResult newQuizResult) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("What would you estimate the average humidity of where you live to be?");
//        System.out.println("humid, normal, or dry? type: h, n, or d");
//        while(true) {
//            String hum = scanner.nextLine();
//            if(hum.equalsIgnoreCase("h")) {
//                String humidityResult = "Humid";
//                System.out.println("humid");
//                break;
//            } else if(hum.equalsIgnoreCase("n")){
//                String humidityResult = "Normal";
//                System.out.println("normal");
//                break;
//            } else if (hum.equalsIgnoreCase("d")){
//                String humidityResult = "Dry";
//                System.out.println("dry");
//                break;
//            } else {
//                System.out.println("Option not recognised - please select an option between h, n or d");
//            }
//        }
//        askTemp(newQuizResult);
//    }
//
//    public void askTemp(QuizResult newQuizResult) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("What would you estimate the average temperature to be in summer?");
//        System.out.println("low, normal, high? type: l, n, or h");
//        while (true) {
//            String summer = scanner.nextLine();
//            if (summer.equalsIgnoreCase("l")) {
//                String tempSummerResult = "Low";
//                System.out.println("low");
//                break;
//            } else if(summer.equalsIgnoreCase("n")) {
//                String tempSummerResult = "Normal";
//                System.out.println("normal");
//                break;
//            } else if(summer.equalsIgnoreCase("h")) {
//                String tempSummerResult = "High";
//                System.out.println("high");
//                break;
//            } else {
//                System.out.println("Option not recognised - please select an option between h, n or d");
//            }
//
//        }
//        endQuiz(newQuizResult);
//    }
//
//    public List<Plant> getThreePlants(QuizResult newQuizResult) {
//        return plantService.getTopThreePlants(newQuizResult.getPlantType(), newQuizResult.getPlantExperience());
//    }
//
//    public void endQuiz(QuizResult newQuizResult) {
//        System.out.println("Thank You for taking the quiz! Your results are being calculated!");
//        System.out.println(newQuizResult);
////        //waiting period
//////        Thread.sleep(3000);
//        //Search through database for a list of plant on the basis of the options - big switch statement
//        List<Plant> suitablePlants = getThreePlants(newQuizResult);
//        newQuizResult.setTopThreePlants(suitablePlants);
////        //Print the plants that are recommended
//        System.out.println(suitablePlants);
////        System.out.println(suitablePlants);
////        //ask if the user wants to create an account or login or exit(the result will not be saved)
////        Scanner scanner = new Scanner(System.in);
////        System.out.println("Would you like to save this quiz result to view it in future? \n Create a new account: Press 1 \n Already got an account? Log in: Press 2 \n Quit and lose your result: Press 3");
////        label:
////        while(true) {
////            String option = scanner.nextLine();
////            switch (option) {
////                case "1" -> {
////                    System.out.println("Creating a new account:");
////                    addNewQuizResult(effortResult, locationResult, suitablePlants);
////                    //get test id
////                    System.out.println("Enter a username:");
////                    String username = scanner.nextLine();
////                    System.out.println("Enter a email:");
////                    String email = scanner.nextLine();
////                    System.out.println("Enter a password:");
////                    String password = scanner.nextLine();
////                    userService.addNewUser(username, email, password, levelResult, test_id);
////                    System.out.println("New User created!");
////                    break label;
////                }
////                case "2" -> {
////                    System.out.println("Log into existing account:");
////                    System.out.println("Username: ");
////                    String username = scanner.nextLine();
////                    System.out.println("Password: ");
////                    String password = scanner.nextLine();
////
////                    //find matching username and password
////                    //add a new test to that user id
////                    break label;
////                }
////                case "3" -> {
////                    System.out.println("Leaving quiz result page");
////                    break label;
////                }
////                default -> {
////                    System.out.println("Option not recognised - please select an option between 1, 2 and 3");
////                }
////            }
//        }
        ///////////////////////////////////////////////////////////////

        //option 1: create a new user
        //create a new test with those results saved it and the test id sa
    // ved to the new user
        //option 2: sort through users on the basis of correct password and assign a new instance of quiz result to that user
        //option 3: quit the test but warn them that the test results will not be saved
        //are you sure you want to?
        //Save results to database

        // Get user id
//        System.out.println("To begin enter your user id!");
//        Scanner scanner = new Scanner(System.in);
//        int answer = scanner.nextInt();
//
//        //Create new quiz results object using the id
//        QuizResult results = new QuizResult(answer);
//
//        // Check if id is correct - if not ask again, if yes run askLevel
//        askLevel(results);
//    public void addNewQuizResult(UserExperience effortResult, PlantType locationResult, List<Plant> suitablePlants){
//        QuizResult newQuizResult = new QuizResult(effortResult, locationResult, suitablePlants);
//        quizService.addQuizResult(newQuizResult);
    //}
}










//public class QuizQuestions {
//
//    public static void intro() {
//        System.out.println("Thank you for choosing to take the budDy personality quiz!");
//        System.out.println("Your answers will be used to help us find your one true bud!");
//
//        //Get user id
//        System.out.println("To begin enter your user id!");
//        Scanner scanner = new Scanner(System.in);
//        int answer = scanner.nextInt();
//
//        //Create new quiz results object using the id
//        QuizResult results = new QuizResult(answer);
//
//        // Check if id is correct - if not ask again, if yes run askLevel
//        askLevel(results);
//    }
//
//    static void askLevel (QuizResult results) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Great let's begin!");
//        System.out.println("What level gardener would you count yourself as?");
//        System.out.println("Total beginner: press 1");
//        System.out.println("Intermediate, I've cared for a few plants which have survived longer than a week: press 2");
//        System.out.println("Expert, green thumb who can handle any plant life throws at you: press 3");
//
//        String level = scanner.nextLine();
//        //set level (Can use a switch statement if needed)
//        results.setUserLevel(level);
//        // call askEffort
//        askEffort(results);
//
//    }
//
//    static void askEffort (QuizResult results) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("How much effort are you looking to put in?");
//        System.out.println("Almost no effort, the plant should practically look after itself: press 1");
//        System.out.println("A medium amount of effort, I need to feel needed by the plant: press 2");
//        System.out.println("I want a challenge: press 3");
//
//        //set effort
//        String effort = scanner.nextLine();
//        results.setEffort(effort);
//
//        // call askPlant Location
//        askPlantLoc(results);
//    }
//
//    static void askPlantLoc (QuizResult results) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Will your new budDy be living inside or outside?");
//        System.out.println("Inside! I'm looking for a new roommate: press 1");
//        System.out.println("Outside, where plants belong: press 2");
//
//        String loc = scanner.nextLine();
//
//        switch (loc) {
//            case "1" -> {
//                results.setPlantLoc("Inside");
//                askPreference(results);
//            }
//            case "2" ->{
//                results.setPlantLoc("Outside");
//                askHumidity(results);
//            }
//            default -> {
//                System.out.println("Option not recognised - please select an option between 1 and 2");
//                askPlantLoc(results);
//            }
//        }
//    }
//
//    static void askHumidity (QuizResult results) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("What would you estimate the average humidity of where you live to be?");
//        System.out.println("humid, normal, or dry? type: h, n, or d");
//
//        String hum = scanner.nextLine();
//        results.setHumidity(hum);
//
//        askTemp(results);
//    }
//
//    static void askTemp (QuizResult results) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("What would you estimate the average temperature to be in summer?");
//        System.out.println("low, normal, high? type: l, n, or h");
//        String summer = scanner.nextLine();
//        results.setSumTemp(summer);
//
//        System.out.println("What would you estimate the average temperature to be in winter?");
//        System.out.println("low, normal, high? type: l, n, or h");
//        String winter = scanner.nextLine();
//        results.setWinTemp(winter);
//
//        askPreference(results);
//    }
//
//    static void askPreference (QuizResult results) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Do you have any preference for a type of plant?");
//
//        String pref = scanner.nextLine();
//        results.setPlantType1(pref);
//
//        endQuiz(results);
//    }
//
//    static void endQuiz(QuizResult results) {
//        System.out.println("Thank You for taking the quiz! Your results are being calculated!");
//        //Save results to database
//    }
//
//}
