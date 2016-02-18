package lab3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Part2 {
	public static void main(String[] args) {
		Staff staff = new Staff();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<StaffMember> staffList = new ArrayList<StaffMember>();
		
		// Copy data from staff to our own array list
		for (int i = 0; i < staff.getSize(); i++) {
			staffList.add(staff.getStaff(i));
		}
		
		// part a: Print all our staff members and their pay
		for (StaffMember staffMember : staffList) {
			System.out.println(staffMember.toString());
			System.out.println(staffMember.pay());
		}
		
		while (staffList.size() > 0) {
			System.out.print("Please enter a name to remove (enter \"exit\" to terminate): ");
			
			int initialSize = staffList.size();
			
			try {
				String name = reader.readLine();
				
				if (name.equals("exit")) {
					break;
				} else {
					// Find the requested staff member, make sure they aren't an executive and remove them if not.
					for (int i = 0; i < staffList.size(); i++) {
						if (name.equals(staffList.get(i).name)) {
							if (staffList.get(i) instanceof Executive) {
								System.out.println("Whoops, " + name + " is an Executive.");
								break;
							} else {
								staffList.remove(i);
								break;
							}
						}
					}
					
					// Check if we did anything
					if (initialSize == staffList.size()) {
						System.out.println("Not found");
					} else {
						System.out.println(name + " was deleted.");
					}
				}	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		boolean running = true;
		
		while (running) {
			System.out.print("Please enter a staff member's name to edit their address (enter \"exit\" to terminate): ");
			
			try {
				String name = reader.readLine();
				
				if (name.equals("exit")) {
					break;
				} else {
					// Find the requested staff member and update their address.
					for (int i = 0; i < staffList.size(); i++) {
						if (name.equals(staffList.get(i).name)) {
							System.out.print("Please enter the new address: ");
							String addr = reader.readLine();
							
							StaffMember staffMember = staffList.get(i);
							staffMember.address = addr;
							staffList.set(i, staffMember);
							running = false;
							break;
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// Print all our staff members and their pay
		for (StaffMember staffMember : staffList) {
			System.out.println(staffMember.toString());
			System.out.println(staffMember.pay());
		}
	}
}
