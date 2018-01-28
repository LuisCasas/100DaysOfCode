package com.luiscasas;

import java.util.List;

import departments.IObserver;

import java.util.ArrayList;
import employment.Employee;
import subjects.ISubject;

public class EmployementManagementSystem implements ISubject{
	
	private List<Employee> employees;
	private List<IObserver> observers;
	
	private EmployeeDAO employeesDao;
	
	private Employee employee;
	private String msg;

	
	
	public EmployementManagementSystem() {
		this.observers = new ArrayList<>();
		this.employeesDao = new EmployeeDAO();
		this.employees = employeesDao.generateNewEmployees();
	}

	@Override
	public void registerObserver(IObserver o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(IObserver o) {
		observers.remove(o);
	}

	@Override
	public void notifyObserver(Employee emp, String msg) {
		for(IObserver departments : observers) {
			departments.callEmployee(emp, msg);
		}
	}
	
	public void hireEmployee(Employee emp) {
		employee = emp;
		msg = "New hire";
		employees.add(emp);
		notifyObserver(emp,  msg);
	}
	
	public void modifyEmployeeName(int id, String newName) {
		boolean notify = false;
		
		for(Employee emp :  employees) {
			if(id == emp.getEmployeeId()) {
				emp.setName(newName);
				this.employee = emp;
				this.msg = "Employee name modified";
				notify = true;
			}
		}
		
		
		if(notify) {
			notifyObserver(this.employee, this.msg);
		}
	}
	
}
