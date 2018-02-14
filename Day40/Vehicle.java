package com.luiscasas;

public class Vehicle {
	
	private String name;
	private String brand;
	protected int engine;
	
	public Vehicle(String name, String brand) {
		super();
		this.name = name;
		this.brand = brand;
	}
	
	public void startUp() {
		System.out.println("Vehicle " + this.name + "  brand: " + this.brand);
	}	
	
	public void printDetails() {
		System.out.println("Brand: " + this.brand + " model " + this.name);
	}

}
