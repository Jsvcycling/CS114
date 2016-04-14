package lab7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Part1 {
	public static void main(String[] args) {
		try {
			BufferedReader fileReader = new BufferedReader(new FileReader(new File("test.txt")));
			BufferedReader userReader = new BufferedReader(new InputStreamReader(System.in));
			UALdictionary<String, StaffMember> dictionary = new UALdictionary<String, StaffMember>();
			
			while (fileReader.ready()) {
				String line = fileReader.readLine();
				
				if (line.equals("")) {
					break;
				}
				
				String[] data = line.split(",");
				
				StaffMember staffMember = new StaffMember();
				staffMember.SetStaffMember(data[0], data[1], data[2], data[3], Double.parseDouble(data[4]));
				dictionary.insert(data[3], staffMember);
			}
			
			System.out.println(dictionary.toString());
			
			while (true) {
				System.out.print("Please enter an SSN to delete (or enter \"exit\" to terminate): ");
				String input = userReader.readLine();
				
				if (input.equals("exit")) {
					break;
				}
				
				StaffMember removed = dictionary.remove(input);
				
				if (removed == null) {
					System.out.println("Whoops, you entered an incorrect SSN, please try again.");
				} else {
					System.out.println("Removed " + removed.name + " from dictionary.");
					System.out.println(dictionary.toString());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
