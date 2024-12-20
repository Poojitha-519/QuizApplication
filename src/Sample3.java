import java.util.Scanner;
public class Sample3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Sample s = new Sample();
		System.out.println("enter a yes 0r no:");
		String a = sc.nextLine();
		if(a.equals("yes")) {
			System.out.println("Start game");
			
		
			//System.out.println("quit game");
	
	
			System.out.println("rules");
			System.out.println("Answer correctly the given questions to win the reward");
			System.out.println("two life lines are available 50-50 and skip the question");
			System.out.println("wrong answer terminate the game");
			System.out.println("life lines can only used once");
			System.out.println("Lest start the QuizGame");
		}else {
			System.out.println("Quit the game");
		}
			
		// TODO Auto-generated method stub

	}

}
