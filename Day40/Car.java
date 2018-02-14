package com.luiscasas;

public class Car extends Vehicle{
	
	public Car(String make, String brand){
		super(make, brand);
	}

	@Override
	public void startUp() {
		System.out.println("Start up car");
	}
	
	public void turboEngine() {
		this.engine += 200;
	}

}
