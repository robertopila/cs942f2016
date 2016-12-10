import java.util.Scanner;

/*
 * This program will determine what n! mod m is.
 * @author Miguel Martinez
 * Sample data 	m = 31, n = 5; n! mod m will be 27
 * 				m = 4, n = 3; n! mod m will be 2 
 * 				m = 22, n = 9; n! mod m will be 12
 */
public class ModFactorial {

	public static void main(String[] args) {
		int num1, num2, ans;
		Scanner keyboard = new Scanner(System.in);
		
		// Ask user for two numbers to determine n! mod m
		System.out.println("This program will determine n! mod m"
				+ "\nPlease enter two numbers, the first will be n,"
				+ " the second will be m.");
		num1 = keyboard.nextInt();
		num2 = keyboard.nextInt();
		
		// Call modFact method
		ans = modFact(num1, num2);
		System.out.println(num1+"! mod " + num2 + " is " + ans);
	}

	private static int modFact(int n, int m) {
		// Base case
		if (n == 1)
			return 1;
		else return (n*modFact(n-1,m)%m);
		
	}

}
