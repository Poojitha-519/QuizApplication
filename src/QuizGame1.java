import java.util.Scanner;

public class QuizGame1 {

    private static final FiftyFiftyLifeLine fiftyFiftyLifeLine = new FiftyFiftyLifeLine();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sample s = new Sample(); // Assume Sample is a class to store player info
        Rewards rewards = new Rewards(); // Manage total rewards

        // Player details
        System.out.println("Enter name:");
        String name = sc.nextLine();
        s.setname(name);

        System.out.println("Enter email:");
        String email = sc.nextLine();
        s.setemail(email);

        System.out.println("Enter phone:");
        String phn = sc.nextLine();
        s.setphn(phn);

        System.out.println("Enter password:");
        String password = sc.nextLine();
        s.setpassword(password);

        System.out.println("Enter age:");
        int age = sc.nextInt();
        sc.nextLine();
        s.setage(age);

        // Confirm details
        System.out.println("Player Details:");
        System.out.println("Name: " + s.getname());
        System.out.println("Email: " + s.getemail());
        System.out.println("Phone: " + s.getphn());
        System.out.println("Age: " + s.getage());

        System.out.println("Do you want to start the game? (yes or no):");
        String choice = sc.nextLine();

        if (choice.equalsIgnoreCase("yes")) {
            System.out.println("Start the game...");
            System.out.println("Rules:");
            System.out.println("1. Answer the questions correctly to win rewards.");
            System.out.println("2. Two lifelines are available: 50-50 and skip.");
            System.out.println("3. A wrong answer terminates the game.");
            System.out.println("4. Lifelines can only be used once.");

           
            String[] options1 = {"A. Delhi", "B. Rome", "C. Paris", "D. Tokyo"};
            Questions question1 = new Questions("What is the capital of India?", options1, "A", 100);
            askQuestion(sc, question1, rewards);

            String[] options2 = {"A. Earth", "B. Jupiter", "C. Sun", "D. Mars"};
            Questions question2 = new Questions("What is the largest planet in our solar system?", options2, "B", 100);
            askQuestion(sc, question2, rewards);
            String[] options3 = {"A. 2", "B. 4", "C. 3", "D. 1"};
            Questions question3 = new Questions("What is the size of int?", options3, "B", 100);
            askQuestion(sc, question3,rewards);
            String[] options4 = {"A. 2", "B. 4", "C. 3", "D. 1"};
            Questions question4 = new Questions("What is the size of float?", options4, "B", 100);
            askQuestion(sc, question4,rewards);
            String[] options5 = {"A. 2", "B. 4", "C. 8", "D. 1"};
            Questions question5 = new Questions("What is the size of double?", options5, "C", 100);
            askQuestion(sc, question5,rewards);
            String[] options6 = {"A. 2", "B. 4", "C. 8", "D. 1"};
            Questions question6 = new Questions("What is the size of char?", options6, "A", 100);
            askQuestion(sc, question6,rewards);
            String[] options7 = {"A. 2", "B. 4", "C. 8", "D. 1"};
            Questions question7 = new Questions("What is the size of long?", options7, "C", 100);
            askQuestion(sc, question7,rewards);
            String[] options8 = {"A. 2", "B. 4", "C. 8", "D. 9"};
            Questions question8 = new Questions("how many planets in the solarsystem?", options8, "D", 100);
            askQuestion(sc, question8,rewards);
            String[] options9 = {"A. 2", "B. 4", "C. 8", "D. 9"};
            Questions question9 = new Questions("size of short int?", options9, "A", 100);
            askQuestion(sc, question9,rewards);
            String[] options10 = {"A. 2", "B. 4", "C. 8", "D. 9"};
            Questions question10 = new Questions("size of byte?", options10, "A", 100);
            askQuestion(sc, question10,rewards);
           
            
            System.out.println("You completed the quiz!");
            System.out.println("Your total rewards: " + Rewards.getTotalRewards() + " points.");
        } else {
            System.out.println("You quit the game.");
        }

        sc.close();
    }

    private static FiftyFiftyLifeLine FiftyFiftyLifeLine() {
    	
		// TODO Auto-generated method stub
		return null;
	}

	public static void askQuestion(Scanner sc, Questions question, Rewards rewards) {
        System.out.println("Question: " + question.getQuestion());
        for (String option : question.getOptions()) {
            System.out.println(option);
        }
        System.out.print("Your answer (or type 'lifeline' for 50-50): ");
        String userAnswer = sc.nextLine();

        if (userAnswer.equals("lifeline")) {
            if (fiftyFiftyLifeLine.isAvailable()) {
                fiftyFiftyLifeLine.use();
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

        if (userAnswer.equals(question.getAnswer())) {
            System.out.println("Correct! You earned " + question.getRewards() + " points.");
            Rewards.addRewards(question.getRewards());
        } else {
            System.out.println("Wrong answer. Game over.");
            System.out.println("Your total rewards: " + Rewards.getTotalRewards() + " points.");
            System.exit(0);
        }
    }

    private static String[] applyFiftyFiftyLifeLine(String[] options, String answer) {
        String[] filteredOptions = new String[2];
        filteredOptions[0] = answer;

        for (String option : options) {
            if (!option.equals(answer)) {
                filteredOptions[1] = option;
                break;
            }
        }

        return filteredOptions;
    }
}

