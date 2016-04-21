package lab10;

import java.util.HashMap;
import java.util.Set;

public class StaffEmployees {
	private HashMap<String, StaffMember> staffMap;
	
	public StaffEmployees() {
		staffMap = new HashMap<String, StaffMember>();
	}
	
	public void addEmployee(StaffMember member) {
		staffMap.put(member.getEmployeeId(), member);
	}
	
	public StaffMember getEmployee(String employeeId) {
		return staffMap.get(employeeId);
	}
	
	public Set<String> getEmployeeIds() {
		return staffMap.keySet();
	}
}
