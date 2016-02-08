package lab2;

import java.util.Scanner;

public class Part3 {
	public static int oddEvenFactorial(int n) {
		int result = n;
		
		if (n % 2 == 0) {
			if (n > 2) {
				result *= oddEvenFactorial(n - 2);
			}
		} else {
			if (n > 1) {
				result *= oddEvenFactorial(n - 2);
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		while(true) {
			System.out.print("Please enter a number to calculate the odd-even factorial for: ");
			
			Scanner scanner = new Scanner(System.in);
			
			try {
				int value = Integer.parseInt(scanner.nextLine());
				
				if (value == 0) {
					System.out.println("Goodbye...");
					break;
				}
				
				int result = oddEvenFactorial(value);
				
				System.out.println(result);
			} catch (Exception e) {
				System.out.println("There was an error, please try again.");
			}
		}
	}
}
