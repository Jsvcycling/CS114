////////////////////////////////////////////////////////////////////////////////
// Part 1
////////////////////////////////////////////////////////////////////////////////
package lab5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Part1 {
	public static void main(String[] args) {
		try {
			//
			// Part 1.A
			//
			BufferedReader reader = new BufferedReader(new FileReader(new File("test.dat")));
			LStack<String> stack = new LStack<>();
			
			while(reader.ready()) {
				String line = reader.readLine();
				
				if (line.length() > 1) {
					stack.push(line);
				}
			}
			
			System.out.println(stack.toString() + " " + stack.length());
			reader.close();
			
			//
			// Part 1.B
			//
			reader = new BufferedReader(new FileReader(new File("test.dat")));
			LStack<String> opStack = new LStack<>();
			
			while(reader.ready()) {
				String line = reader.readLine();
				opStack.clear();
				
				if (line.length() > 1) {
					for (int i = 0; i < line.length(); i++) {
						if (line.charAt(i) == '(') {
							opStack.push("(");
						} else if (line.charAt(i) == ')') {
							String lastOp = opStack.pop();
							if (!lastOp.equals("(")) {
								break;
							}
						}
					}
					
					if (opStack.length() == 0) {
						System.out.println("valid");
					} else {
						System.out.println("invalid");
					}
				}
			}
			
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

////////////////////////////////////////////////////////////////////////////////
// Part 2
////////////////////////////////////////////////////////////////////////////////
package lab5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Part2 {
	public static void main(String[] args) {
		try {
			//
			// Part 2
			//
			BufferedReader reader = new BufferedReader(new FileReader(new File("testAll.dat")));
			LStack<String> opStack = new LStack<>();
			
			while (reader.ready()) {
				String line = reader.readLine();
				opStack.clear();
				
				if (line.length() > 1) {
					for (int i = 0; i < line.length(); i++) {
						// Handle parentheses
						if (line.charAt(i) == '(') {
							opStack.push("(");
						} else if (line.charAt(i) == ')') {
							String lastOp = opStack.pop();
							if (!lastOp.equals("(")) {
								break;
							}
						}
						
						// Handle square brackets
						if (line.charAt(i) == '[') {
							opStack.push("[");
						} else if (line.charAt(i) == ']') {
							String lastOp = opStack.pop();
							if (!lastOp.equals("[")) {
								break;
							}
						}
						
						// Handle curly braces
						if (line.charAt(i) == '{') {
							opStack.push("{");
						} else if (line.charAt(i) == '}') {
							String lastOp = opStack.pop();
							if (!lastOp.equals("{")) {
								break;
							}
						}
					}
					
					if (opStack.length() == 0) {
						System.out.println("valid");
					} else {
						System.out.println("invalid");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

////////////////////////////////////////////////////////////////////////////////
// Part 3
////////////////////////////////////////////////////////////////////////////////
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

