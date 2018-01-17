package com.luiscasas;

public class Employee {
	
	private long id;
	private String name;
	private String department;
	private boolean working;
	
	public Employee(long id, String name, String department, boolean working) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.working = working;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
	}

	public boolean getIsWorking() {
		return working;
	}
	
	public void setIsWorking(boolean working) {
		this.working = working;
	}

	@Override
	public String toString() {
		return "New hire name " + name + " joins the department" + department + " ";
	}
	
	

}
