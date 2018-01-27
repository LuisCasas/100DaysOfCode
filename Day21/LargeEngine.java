package com.luiscasas;

public class LargeEngine implements Engine{
	
	private int horsePower;

	public LargeEngine(int horsePower) {
		this.horsePower = horsePower;
	}
	
	public void startEngine() {
		System.out.println("Start Large engine with " + horsePower + " horsePower!");
	}

}
