package employment;

import java.util.Date;

public class Employee {
	
	private String name;
	private int age;
	private Date hireDate;
	private int salary;
	private int employeeId;
	private boolean working;
	
	private static int COUNTER;

	public Employee(String name, int age, Date hireDate, int salary, boolean working) {
		
		this.name = name;
		this.age = age;
		this.hireDate = hireDate;
		this.salary = salary;
		this.working = working;
		
		this.employeeId = ++COUNTER;
		
		toString();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Employee name: " + name + ", age: " + age + ", salary: " + salary + ", date: " + hireDate + ", id: "+ employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEmployeeId() {
		return employeeId;
	}
}
