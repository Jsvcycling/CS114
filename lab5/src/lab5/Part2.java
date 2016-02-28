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
