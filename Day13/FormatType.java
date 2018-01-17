package com.luiscasas;

public class FormatType {
	
	public String convertObjectToXML(Employee employee) {
		return "Report to XML for employee <employee>" + employee.getName() + "</employee>";
	}

	public String convertObjectToCSV(Employee employee) {
		return "Report to CSV for employee ,,,," + employee.getName() + ",,,,";
	}	
	
}
