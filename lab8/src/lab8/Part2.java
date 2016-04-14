package lab8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Part2 {
	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File("inventory.txt")));
			BST<String, String> bstTree = new BST<String, String>();
			
			while (reader.ready()) {
				String line = reader.readLine();
				bstTree.insert(line, line);
			}
			
			bstTree.printRange(bstTree.getRoot(), "KI04D2593C", "BM12E1000A");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
