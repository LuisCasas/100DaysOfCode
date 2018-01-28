package com.luiscasas;

import java.util.Date;

import departments.*;
import employment.Employee;

public class Main {

	public static void main(String[] args) {
		
		// EmployeeDAO employees = new EmployeeDAO();
		// employees.generateNewEmployees();
		
		IObserver hrDepartment = new HRDepartment();
		IObserver itDepartment = new ITDepartment();
		
		EmployementManagementSystem ems = new EmployementManagementSystem();
		
		ems.registerObserver(hrDepartment);
		ems.registerObserver(itDepartment);
		
		Employee emp1 = new Employee("George", 35, new Date(),25000, true);
		ems.hireEmployee(emp1);
		
		ems.modifyEmployeeName(1, "Lucas");
	}

}
