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
