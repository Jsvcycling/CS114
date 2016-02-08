package lab2;

import java.util.Scanner;

public class Part2 {
	static double rpow2(double base, int power) {
		if (power == 0) {
			return 1.0;
		}
			
		if (power % 2 == 1) {
			double y = rpow2(base, (power-1)/2);
			
			return base * y * y;
		} else {
			double y = rpow2(base, power / 2);
			
			return y * y;
		}
	}
	
	public static void main(String[] args) {
		while (true) {
			try {
				Scanner scanner = new Scanner(System.in);
				
				// Get the base.
				System.out.print("Please enter a base number: ");
				int base = Integer.parseInt(scanner.nextLine());
				
				// Check for termination by user.
				if (base == 0) {
					System.out.println("Goodbye...");
					break;
				}
				
				// Get the exponent.
				System.out.print("Please enter an exponent: ");
				int exp = Integer.parseInt(scanner.nextLine());
				
				// Test our implementation.
				double startTime1 = System.nanoTime();
				System.out.println(rpow2(base, exp));
				System.out.println("Custom runtime: " + (System.nanoTime() - startTime1));
				
				// Test the built-in implementation.
				double startTime2 = System.nanoTime();
				System.out.println(Math.pow(base, exp));
				System.out.println("Built-in runtime: " + (System.nanoTime() - startTime2));
			} catch (Exception e) {
				System.out.println("There was an error, please try again.");
			}
			
		}
		
	}
}
