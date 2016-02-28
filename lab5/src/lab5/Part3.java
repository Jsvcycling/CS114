package lab5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Part3 {
	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			LStack<Float> stack = new LStack<>();
			boolean running = true;
			
			while (running) {
				stack.clear();
				
				System.out.print("Please enter an postfix mathematical sequence (or \"exit\" to terminate): ");
				String textInput = reader.readLine();
				
				if (textInput.equals("exit")) {
					System.out.println("Goodbye...");
					running = false;
				} else {
					String[] input = textInput.split(" ");
					
					for (String element : input) {
						if (element.equals("+")) {
							// Do addition
							float item1 = stack.pop();
							float item2 = stack.pop();
							stack.push(item2 + item1);
						} else if (element.equals("-") | element.equals("–")) {
							// Do subtraction
							float item1 = stack.pop();
							float item2 = stack.pop();
							stack.push(item2 - item1);
						} else if (element.equals("*")) {
							// Do multiplication
							float item1 = stack.pop();
							float item2 = stack.pop();
							stack.push(item2 * item1);
						} else if (element.equals("/")) {
							// Do division
							float item1 = stack.pop();
							float item2 = stack.pop();
							stack.push(item2 / item1);
						} else if (element.equals("^")) {
							// Do power
							float item1 = stack.pop();
							float item2 = stack.pop();
							stack.push((float)Math.pow(item2, item1));
						} else if (element.equals("%")) {
							// Do modulo
							float item1 = stack.pop();
							float item2 = stack.pop();
							stack.push(item2 % item1);
						} else {
							stack.push(Float.valueOf(element));
						}
					}
					
					if (stack.length() == 1) {
						float result = stack.pop();
						System.out.println("Result: " + result);
					} else {
						System.out.println("Whoops, there was an error. Please try again.");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
