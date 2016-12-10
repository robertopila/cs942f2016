import java.util.Scanner;

/*
 * This program will determine the greatest common divisor
 * between two numbers entered by the user.
 * @author Miguel Martinez
 */
public class GCD {

	public static void main(String[] args) {
		
		int num1, num2, ans;
		Scanner keyboard = new Scanner(System.in);
		
		// Ask user for two numbers to determine their gcd
		System.out.println("Please enter two numbers to find their GCD");
		num1 = keyboard.nextInt();
		num2 = keyboard.nextInt();
		
		// Call gcd method sending num1, num2
		ans = gcd(num1,num2);
		
		// Display return value
		System.out.println("The GCD of " + num1 + " and " + num2 + " is " + ans);
	}

	private static int gcd(int a, int b) {
		
		// base case
		if (a == 0)
				return b;
		else return gcd(b % a , a);
	}

}
