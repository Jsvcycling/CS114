package lab10;

import java.util.Scanner;

public class StaffManagement {
	public static void main(String[] args) {
		Staff staff = new Staff();
		StaffEmployees employees = new StaffEmployees();
		
		for (int i = 0; i < staff.getSize(); i++) {
			employees.addEmployee(staff.getStaff(i));
		}
		
		Scanner scan = new Scanner(System.in);
		String eid;
		StaffMember employee;
		
		for (String employeeId : employees.getEmployeeIds())  {
			System.out.println(employees.getEmployee(employeeId));
			System.out.println();
		}
		
		do {
			System.out.print("Enter employee ID (DONE to quit): ");
			eid = scan.nextLine();
			
			if (!eid.equalsIgnoreCase("DONE")) {
				employee = employees.getEmployee(eid);
				
				if (employee == null) {
					System.out.println("Employee not found.");
				} else {
					System.out.println(employee);
				}
			}
		} while (!eid.equalsIgnoreCase("DONE"));
		
		System.out.println("\nAll Employees:\n");
		
		for (String employeeId : employees.getEmployeeIds())  {
			System.out.println(employees.getEmployee(employeeId));
		}
	}
}
