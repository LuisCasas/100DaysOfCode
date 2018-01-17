package com.luiscasas;

public class EmployeeDAO{
	
	public void saveEmployee(Employee employee) {
		DatabaseConnection connection =  new DatabaseConnection("SQL connection");
		connection.connectToDatabase();
		employee.setIsWorking(true);
		System.out.println("Employee " + employee.getName() + " saved");
	}
	
	public void deleteEmployee(Employee employee) {
		DatabaseConnection connection =  new DatabaseConnection("SQL connection");
		connection.connectToDatabase();
		employee.setIsWorking(true);
		System.out.println("Employee " + employee.getName() + " deleted");
	}	

}
