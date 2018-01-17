package com.luiscasas;

public class EmployeeReport {
	
	private Employee employee;
	private FormatType formatType;
	
	public EmployeeReport(Employee employee) {
		this.employee = employee;
		formatType = new FormatType();
	}

	public FormatType getFormatType() {
		return formatType;
	}
	
	
}
