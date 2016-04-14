package lab9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Part1 {
	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File("inventory.txt")));
			String[] strings = new String[20];
			MaxHeap<String> heap = new MaxHeap<String>(strings, 0, 20);
			
			while (reader.ready()) {
				heap.insert(reader.readLine());
				
				for (String item : strings) {
					if (item != null) {
						System.out.print(item + " ");
					}
				}
				
				System.out.println();
			}
			
			System.out.println();
			
			heap.removemax();
			
			for (String item : strings) {
				if (item != null) {
					System.out.print(item + " ");
				}
			}
			
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
