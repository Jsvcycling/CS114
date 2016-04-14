package lab8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Part1 {
	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File("inventory.txt")));
			BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
			BST<String, String> bstTree = new BST<String, String>();
			
			while (reader.ready()) {
				String line = reader.readLine();
				bstTree.insert(line, line);
			}
			
			System.out.println("In-order:\t" + bstTree.toString(0));
			System.out.println("Post-order:\t" + bstTree.toString(1));
			System.out.println("Pre-order:\t" + bstTree.toString(2));
			System.out.println();
			
			// Remove items
			while (true) {
				System.out.print("Enter a Part # to remove (or EXIT to terminate): ");
				
				String input = userInput.readLine();
				
				if (input.equals("EXIT")) {
					break;
				} else {
					String item = bstTree.remove(input);
					
					if (item == null) {
						System.out.println("Whoops, couldn't find that Part #. Try again.");
					} else {
						System.out.println("Successfully removed part.");

						System.out.println();
						System.out.println("In-order:\t" + bstTree.toString(0));
						System.out.println("Post-order:\t" + bstTree.toString(1));
						System.out.println("Pre-order:\t" + bstTree.toString(2));
						System.out.println();
					}
				}
			}
			
			// Add items
			while (true) {
				System.out.print("Enter a Part # to add (or EXIT to terminate): ");
				
				String input = userInput.readLine();
				
				if (input.equals("EXIT")) {
					break;
				} else {
					bstTree.insert(input, input);

					System.out.println();
					System.out.println("In-order:\t" + bstTree.toString(0));
					System.out.println("Post-order:\t" + bstTree.toString(1));
					System.out.println("Pre-order:\t" + bstTree.toString(2));
					System.out.println();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
