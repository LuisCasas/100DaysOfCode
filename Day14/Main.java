package com.luiscasas;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		Theatre theatre = new Theatre("Brixton Academy", 12, 15);
		// theatre.getSeats();
		List<Theatre.Seat> seatCopy = new ArrayList<>(theatre.seats);
		printList(seatCopy);
		
		seatCopy.get(1).reserved();
		if(theatre.reserveSeat("A02")) {
			System.out.println("Please pay for seat A02");
		} else {
			System.out.println("A02 already taken");
		}
		
		Collections.shuffle(seatCopy);
		System.out.println("Printing seatCopy");
		printList(seatCopy);
		System.out.println("Print Theatre seat");
		printList(theatre.seats);
		
		Theatre.Seat minSeat = Collections.min(seatCopy);
		Theatre.Seat maxSeat = Collections.max(seatCopy);
		
		System.out.println("Min number: "+ minSeat.getSeatNum());
		System.out.println("Max number " + maxSeat.getSeatNum());
		
		sortList(seatCopy);
		System.out.println("------------");
		printList(seatCopy);
	}

	
	public static void printList(List<Theatre.Seat> list) {
		for(Theatre.Seat seat : list) {
			System.out.print(" " + seat.getSeatNum());
		}
		System.out.println();
		System.out.println("=================");
	}
	
	public static void sortList(List<? extends Theatre.Seat> list) {
		for(int i = 0; i < list.size() -1; i++) {
			for(int j = 0; j < list.size() -1; j++) {
				if(list.get(i).compareTo(list.get(j)) > 0) {
					Collections.swap(list, i, j);
				}
			}
		}
	}
}
