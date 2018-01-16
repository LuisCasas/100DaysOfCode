package com.luiscasas;

public class Main {

	public static void main(String[] args) {
		
		Theatre theatre = new Theatre("Brixton Academy", 6, 10);
		// theatre.getSeats();
		
		if(theatre.reserveSeat("A09")) {
			System.out.println("Seat available!");
		} else {
			System.out.println("This seat is not longer available");
		}
	
		if(theatre.reserveSeat("A09")) {
			System.out.println("Seat available!");
		} else {
			System.out.println("This seat is not longer available");
		}	
	}

}
