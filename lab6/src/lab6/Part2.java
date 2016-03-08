package lab6;

import java.util.LinkedList;
import java.util.Random;

public class Part2 {
	public static void main(String[] args) {
		LinkedList<Customer> serviceLine = new LinkedList<Customer>();
		Random random = new Random();
		int currentId = 0;
		int numTellers = random.nextInt(4) + 1;
		boolean running = true;
		
		// Perform 10 iterations.
		for (int i = 0; i < 10; i++) {
			running = true;
			
			// Add new customers to the service line.
			for (int j = 0; j <= random.nextInt(5) + 1; j++) {
				Customer customer = new Customer(currentId);
				serviceLine.addLast(customer);
				currentId++;
				System.out.println(customer.toString() + " has joined the line.");
			}
			
			while (running) {
				// The tellers handle the customers.
				for (int j = 0; j < numTellers; j++) {
					if (serviceLine.peek() != null) {
						Customer customer = serviceLine.remove();
						System.out.println(customer.toString() + " is being served.");
					} else {
						running = false;
						break;
					}
				}
			}
		}
	}
}
