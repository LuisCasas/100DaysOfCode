package com.luiscasas;

public class Vehicle {
	
	private Engine engine;
	
	public Vehicle(Engine engine) {
		this.engine = engine;
	}
	
	public void startUp() {
		this.engine.startEngine();
		System.out.println("Engine started");
	}

}
