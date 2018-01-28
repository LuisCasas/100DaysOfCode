package com.luiscasas;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import employment.Employee;

public class EmployeeDAO {
	
	Employee emp1 = new Employee("John", 23, new Date(),22000, true);
	Employee emp2 = new Employee("Mike", 43, new Date(),52000, true);
	Employee emp3 = new Employee("Peter", 51, new Date(),42000, true);
	
	List<Employee> employees;
	
	public List<Employee> generateNewEmployees(){
		
		employees = new ArrayList<>();
		
		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);
		
		return employees;
		
	}

}
