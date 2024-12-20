import java.util.Scanner;
public class Sample2 {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		Sample s = new Sample();
		System.out.println("enter name:");
		String name = sc.nextLine();
		s.setname(name);
		System.out.println("enter email:");
		String email = sc.nextLine();
		s.setemail(email);
		System.out.println("enter ph:");
		String phn = sc.nextLine();
		s.setphn(phn);
		System.out.println("enter password:");
		String password = sc.nextLine();
		s.setpassword(password);
		System.out.println("enter age:");
		int age = sc.nextInt();
		s.setage(age);
		System.out.println(s.getname());
		System.out.println(s.getemail());
		System.out.println(s.getphn());
		System.out.println(s.getpassword());
		System.out.println(s.getage());
		//Scanner sc = new Scanner(System.in);
		//Sample s = new Sample();
		System.out.println("enter a yes 0r no:");
		String a = sc.nextLine();
		if(a.equals("yes")) {
			System.out.println("Start game");
		
	
			System.out.println("rules");
			System.out.println("Answer correctly the given questions to win the reward");
			System.out.println("two life lines are available 50-50 and skip the question");
			System.out.println("wrong answer terminate the game");
			System.out.println("life lines can only used once");
			System.out.println("Lest start the QuizGame");
		}else {
			System.out.println("Quit the game");
		}
	}
}
			
		
		
		
		
		
		
		
		
		
		
		
		// TODO Auto-generated method	
		


