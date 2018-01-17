package com.luiscasas;

public class Main {

	public static void main(String[] args) {
		
		Employee employee1 = new Employee(3234323,"John","IT",false);
		newHire(employee1);
		employeeReport(employee1);
		terminateEmployeeContract(employee1);

	}
	
	private static void newHire(Employee employee) {
		EmployeeDAO employeedao = new EmployeeDAO();
		employeedao.saveEmployee(employee);
	}

	private static void terminateEmployeeContract(Employee employee) {
		EmployeeDAO employeedao = new EmployeeDAO();
		employeedao.deleteEmployee(employee);
	}	
	
	private static void employeeReport(Employee employee) {
		EmployeeReport report = new EmployeeReport(employee);
		System.out.println(report.getFormatType().convertObjectToXML(employee));
		System.out.println(report.getFormatType().convertObjectToCSV(employee));
		
		System.out.println("Report running");
	}
}
