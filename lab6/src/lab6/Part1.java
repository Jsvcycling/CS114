package lab6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Random;

public class Part1 {
	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File("test.dat")));
			LQueue<String> queue1 = new LQueue<String>();
			LQueue<String> queue2 = new LQueue<String>();
			Random random = new Random();
			boolean running = true;
			
			while (reader.ready()) {
				// Part a
				int linesToRead = random.nextInt(4) + 1;
				
				// Part b
				for (int i = 0; i < linesToRead; i++) {
					String line = reader.readLine();
					
					// Check to make sure not EOF
					if (line == null) {
						running = false;
						break;
					}
					
					// Part d: Add the element to the queue.
					queue1.enqueue(line);
				}
				
				if (!running) {
					break;
				} else {
					// Part e: Transfer one element to the second queue.
					String val = queue1.dequeue();
					queue2.enqueue(val);
				}
			}
			
			System.out.println(queue1.toString());
			System.out.println(queue2.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
