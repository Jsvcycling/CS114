package lab8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Part3 {
	public static void main(String[] args) {
		   StringTree tree = new StringTree();
		   
		   try {
			   BufferedReader reader = new BufferedReader(new FileReader(new File("inventory.txt")));
			   
			   while (reader.ready()) {
				   tree.addString(reader.readLine());
			   }
			   
			   // Traverse the tree using our new stack-based function
			   tree.traverseWithStack();
		   } catch (Exception e) {
			   e.printStackTrace();
		   }
	   }
}
