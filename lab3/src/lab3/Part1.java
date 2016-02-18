package lab3;

import java.util.Scanner;

public class Part1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// Initialization
		AList<Integer> arrayList = new AList<Integer>();
		
		// Part i: Append integer array to AList.
		int[] a = {11, 4, 15, 20};
		
		// Append each item from the array `a` onto `arrayList`.
		for (int i : a) {
			arrayList.append(i);
		}
		
		// Part ii: Insert each element at a specific position.
		int [] b = {9, 3, 7, 22, 13};
		
		// Insert each item from the array `b` into `arrayList` before the third position.
		for (int i : b) {
			// Move to index `1` (second position).
			arrayList.moveToPos(1);
			
			// Insert out integer at the current index.
			arrayList.insert(i);
		}
		
		// Part iii: Print the list with it's length.
		
		// First, print the list using the built-in `toString()` method.
		System.out.print(arrayList.toString());
		
		// Now, print the string length at the end of the line.
		System.out.println(" (length: " + arrayList.length() + ")");
		
		// Part iv
		while (arrayList.length() > 0) {
			System.out.print("Enter an item to remove (enter 0 to terminate): ");
			
			int val = scanner.nextInt();
			
			// Check to see if the user terminated.
			if (val == 0) {
				break;
			} else {
				int initialLength = arrayList.length();
				
				// Make sure we're at the beginning of our list.
				arrayList.moveToStart();
				
				// Check to see if the value exists in our list.
				while (arrayList.currPos() != arrayList.length()) {
					if (val == arrayList.getValue()) {
						arrayList.remove();
						break;
					} else {
						arrayList.next();
					}
				}
				
				// Check to see if we made any changes to the list.
				if (initialLength == arrayList.length()) {
					System.out.println("Not found");
				}
				
				// First, print the list using the built-in `toString()` method.
				System.out.print(arrayList.toString());
				
				// Now, print the string length at the end of the line.
				System.out.println(" (length: " + arrayList.length() + ")");
			}
		}
		
		// part v
		while (arrayList.length() < arrayList.getMaxsize()) {
			System.out.print("Enter an item to add (enter 0 to terminate): ");
			
			int val = scanner.nextInt();
			
			// Check to see if the user terminated.
			if (val == 0) {
				break;
			} else {
				// Append our value.
				arrayList.append(val);
				
				// First, print the list using the built-in `toString()` method.
				System.out.print(arrayList.toString());
				
				// Now, print the string length at the end of the line.
				System.out.println(" (length: " + arrayList.length() + ")");
			}
		}
	}
}
