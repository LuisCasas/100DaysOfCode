package com.luiscasas;

import processes.Laptop;
import processes.Mobile;

public class Main {

	public static void main(String[] args) {
		
		Mobile galaxy8 = new Mobile("Galaxy S8");
		galaxy8.startProcess();
		
		Laptop hp = new Laptop("HP pro");
		hp.startProcess();
	}

}
