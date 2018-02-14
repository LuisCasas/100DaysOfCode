package com.luiscasas;

public class Main {

	public static void main(String[] args) {
		// Basics of Objects [again]
		
		Vehicle focus = new Car("Focus","Ford");
		focus.printDetails();
		
		Vehicle leon = new Car("Leon","Seat");
		leon.printDetails();
		leon.startUp();
	}

}
