package com.budDy.budDy.QuizResult;

import java.util.Scanner;

public class QuizQuestions {

    public static void intro() {
        System.out.println("Thank you for choosing to take the budDy personality quiz!");
        System.out.println("Your answers will be used to help us find your one true bud!");

        //Get user id
        System.out.println("To begin enter your user id!");
        Scanner scanner = new Scanner(System.in);
        int answer = scanner.nextInt();

        //Create new quiz results object using the id
        QuizResult results = new QuizResult(answer);

        // Check if id is correct - if not ask again, if yes run askLevel
        askLevel(results);
    }

    static void askLevel (QuizResult results) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Great let's begin!");
        System.out.println("What level gardener would you count yourself as?");
        System.out.println("Total beginner: press 1");
        System.out.println("Intermediate, I've cared for a few plants which have survived longer than a week: press 2");
        System.out.println("Expert, green thumb who can handle any plant life throws at you: press 3");

        String level = scanner.nextLine();
        //set level (Can use a switch statement if needed)
        results.setUserLevel(level);
        // call askEffort
        askEffort(results);

    }

    static void askEffort (QuizResult results) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How much effort are you looking to put in?");
        System.out.println("Almost no effort, the plant should practically look after itself: press 1");
        System.out.println("A medium amount of effort, I need to feel needed by the plant: press 2");
        System.out.println("I want a challenge: press 3");

        //set effort
        String effort = scanner.nextLine();
        results.setEffort(effort);

        // call askPlant Location
        askPlantLoc(results);
    }

    static void askPlantLoc (QuizResult results) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Will your new budDy be living inside or outside?");
        System.out.println("Inside! I'm looking for a new roommate: press 1");
        System.out.println("Outside, where plants belong: press 2");

        String loc = scanner.nextLine();

        switch (loc) {
            case "1" -> {
                results.setPlantLoc("Inside");
                askPreference(results);
            }
            case "2" ->{
                results.setPlantLoc("Outside");
                askHumidity(results);
            }
            default -> {
                System.out.println("Option not recognised - please select an option between 1 and 2");
                askPlantLoc(results);
            }
        }
    }

    static void askHumidity (QuizResult results) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What would you estimate the average humidity of where you live to be?");
        System.out.println("humid, normal, or dry? type: h, n, or d");

        String hum = scanner.nextLine();
        results.setHumidity(hum);

        askTemp(results);
    }

    static void askTemp (QuizResult results) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What would you estimate the average temperature to be in summer?");
        System.out.println("low, normal, high? type: l, n, or h");
        String summer = scanner.nextLine();
        results.setSumTemp(summer);

        System.out.println("What would you estimate the average temperature to be in winter?");
        System.out.println("low, normal, high? type: l, n, or h");
        String winter = scanner.nextLine();
        results.setWinTemp(winter);

        askPreference(results);
    }

    static void askPreference (QuizResult results) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you have any preference for a type of plant?");

        String pref = scanner.nextLine();
        results.setPlantType1(pref);

        endQuiz(results);
    }

    static void endQuiz(QuizResult results) {
        System.out.println("Thank You for taking the quiz! Your results are being calculated!");
        //Save results to database
    }

}
