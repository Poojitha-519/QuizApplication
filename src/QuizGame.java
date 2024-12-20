import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class QuizGame {

    private static boolean fiftyFiftyUsed = false; // Track if 50-50 lifeline is used

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Rewards rewards = new Rewards(); // Assume Rewards handles the total rewards

        // Game introduction
        System.out.println("Enter name:");
        String name = sc.nextLine();

        System.out.println("Do you want to start the game? (yes or no):");
        String choice = sc.nextLine();

        if (choice.equalsIgnoreCase("yes")) {
            System.out.println("Start the game...");
            System.out.println("Rules:");
            System.out.println("1. Answer the questions correctly to win rewards.");
            System.out.println("2. Two lifelines are available: 50-50.");
            System.out.println("3. A wrong answer terminates the game.");
            System.out.println("4. Lifelines can only be used once.");

            // Questions
            String[] options1 = {"A. Delhi", "B. Rome", "C. Paris", "D. Tokyo"};
            Questions question1 = new Questions("What is the capital of India?", options1, "A", 100);
            askQuestion(sc, question1, rewards);

            String[] options2 = {"A. Earth", "B. Jupiter", "C. Sun", "D. Mars"};
            Questions question2 = new Questions("What is the largest planet in our solar system?", options2, "B", 100);
            askQuestion(sc, question2, rewards);

            System.out.println("You completed the quiz!");
            System.out.println("Your total rewards: " + Rewards.getTotalRewards() + " points.");
        } else {
            System.out.println("You quit the game.");
        }

        sc.close();
    }

    public static void askQuestion(Scanner sc, Questions question, Rewards rewards) {
        System.out.println("Question: " + question.getQuestion());
        for (String option : question.getOptions()) {
            System.out.println(option);
        }

        System.out.print("Your answer (or type 'lifeline' for 50-50): ");
        String userAnswer = sc.nextLine();

        if (userAnswer.equalsIgnoreCase("lifeline")) {
            if (!fiftyFiftyUsed) {
                fiftyFiftyUsed = true;
                System.out.println("50-50 lifeline used.");

                String[] filteredOptions = applyFiftyFiftyLifeLine(question.getOptions(), question.getAnswer());
                System.out.println("Remaining options:");
                for (String option : filteredOptions) {
                    if (option != null) {
                        System.out.println(option);
                    }
                }

                System.out.print("Your answer: ");
                userAnswer = sc.nextLine();
            } else {
                System.out.println("50-50 lifeline already used. Please answer the question.");
                System.out.print("Your answer: ");
                userAnswer = sc.nextLine();
            }
        }

        if (userAnswer.equalsIgnoreCase(question.getAnswer())) {
            System.out.println("Correct! You earned " + question.getRewards() + " points.");
            Rewards.addRewards(question.getRewards());
        } else {
            System.out.println("Wrong answer. Game over.");
            System.out.println("Your total rewards: " + Rewards.getTotalRewards() + " points.");
            System.exit(0);
        }
    }

    private static String[] applyFiftyFiftyLifeLine(String[] options, String answer) {
        List<String> filteredOptions = new ArrayList<>();
        filteredOptions.add(answer);

        Random random = new Random();
        while (filteredOptions.size() < 2) {
            String randomOption = options[random.nextInt(options.length)];
            if (!filteredOptions.contains(randomOption)) {
                filteredOptions.add(randomOption);
            }
        }

        return filteredOptions.toArray(new String[0]);
    }
}
		

 
