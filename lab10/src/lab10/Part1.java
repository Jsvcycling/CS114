package lab10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Part1 {
	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File("inventory.txt")));
			BufferedReader userReader = new BufferedReader(new InputStreamReader(System.in));
			HashMap<String, String> map = new HashMap<String, String>();
			boolean running = true;
			
			while (reader.ready()) {
				String line = reader.readLine();
				map.put(line, line);
			}
			
			Set set = map.entrySet();
			Iterator i = set.iterator();
			
			while (i.hasNext()) {
				Map.Entry entry = (Map.Entry)i.next();
				System.out.print(entry.getKey() + ": ");
				System.out.println(entry.getValue());
			}
			
			while (running) {
				System.out.print("Please enter a key to delete(or \"exit\" to terminate: ");
				String textInput = userReader.readLine();
				
				if (textInput.toLowerCase().equals("exit")) {
					System.out.println("Goodbye...");
					running = false;
				} else {
					String item = map.remove(textInput.toUpperCase());
					
					if (item == null) {
						System.out.println("Sorry, we couldn't find an item with that key, please try again.");
					} else {
						System.out.println("Item deleted");
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
