package com.luiscasas;

public class SmallEngine implements Engine{
	
	private int horsePower;

	public SmallEngine(int horsePower) {
		this.horsePower = horsePower;
	}
	
	public void startEngine() {
		System.out.println("Start Small engine with " + horsePower + " horsePower!");
	}	

}
