package com.luiscasas;

import java.util.*;

public class Theatre {
	
	private final String theatreName;
	private Collection<Seat> seats = new LinkedList<>();
	
	public Theatre(String theatreName, int numRows, int seatsPerRow) {
		this.theatreName = theatreName;
		
		int lastRow = 'A' + (numRows - 1);
		for (char row = 'A'; row <= lastRow; row++) {
			for (int seatNum = 1; seatNum < seatsPerRow; seatNum++) {
				Seat seat = new Seat(row + String.format("%02d", seatNum));
				seats.add(seat);
			}
		}
	}
	
	public String getTheatreName() {
		return this.theatreName;
	}
	
	public boolean reserveSeat(String seatNum) {
		Seat requestedSeat = null;
		
		for(Seat seat: seats) {
			if(seat.getSeatNum().equals(seatNum)) {
				requestedSeat = seat;
				break;
			}
		}
		
		if(requestedSeat == null) {
			System.out.println("Unable to find a seat");
			return false;
		}
		
		return requestedSeat.reserved();
	}
	
	public void getSeats() {
		for(Seat seat: seats) {
			System.out.println(seat.getSeatNum());
		}
	}

	private class Seat{
		
		private final String seatNum;
		private boolean reserved = false;
		
		public Seat(String seatNum) {
			this.seatNum = seatNum;
		}
		
		public boolean reserved() {
			if(!this.reserved) {
				this.reserved = true;
				System.out.println("Seat " + seatNum + " reserved.");
				return true;
			}
			
			return false;
		}
		
		public boolean cancel() {
			if(this.reserved) {
				this.reserved = true;
				System.out.println("Seat " + seatNum + " reserved.");
				return true;
			}
			
			return false;
		}	
		
		public String getSeatNum() {
			return seatNum;
		}
	}
}
