package com.luiscasas;

public class DatabaseConnection {
	
	private String managerName;

	public DatabaseConnection(String managerName) {
		this.managerName = managerName;
	}
	
	public void connectToDatabase() {
		System.out.println("Database connection stablished");
	}
	
	public void getConnectionObject() {
		// return ;
		System.out.println("get connection object");
	}
	
	public String getManagerName() {
		return this.managerName;
	}

}
