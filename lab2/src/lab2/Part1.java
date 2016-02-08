package lab2;

import java.util.Scanner;

public class Part1 {
	// Our recursive factorial function
	public static int factorial(int n) {
		int result = n;
		
		if (n > 1) {
			result *= factorial(n - 1);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		while (true) {
			System.out.print("Please enter a number to calculate the factorial for: ");
			
			// (a) Accept factorial number from keyboard.
			Scanner scanner = new Scanner(System.in);
			
			try {				
				// (b) Validate the input.
				int value = Integer.parseInt(scanner.nextLine());
				
				// (e) Check for termination by user.
				if (value == 0) {
					System.out.println("Goodbye...");
					break;
				}
				
				// (c) Use recursive call to calculate the factorial value.
				int result = factorial(value);
				
				// (d) Print the result
				System.out.println(result);
			} catch (Exception e) {
				System.out.println("There was an error, please try again.");
			}
			
			
		}
	}
}
