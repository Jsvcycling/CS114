package lab9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Part2 {
	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File("inventory.txt")));
			PriorityQueue<String> queue = new PriorityQueue<String>(Collections.reverseOrder());
			
			while (reader.ready()) {
				queue.add(reader.readLine());
			}
			
			Iterator itor = queue.iterator();
			
			while(itor.hasNext()) {
				System.out.print(itor.next() + " ");
			}
			
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
