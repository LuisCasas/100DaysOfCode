package com.luiscasas;

import java.util.*;

public class Theatre {
	
	private final String theatreName;
	public List<Seat> seats = new LinkedList<>();
	
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
		Seat requestedSeat = new Seat(seatNum);
		int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
		
		if(foundSeat >= 0) {
			return seats.get(foundSeat).reserved	();
		} else {
			System.out.println("Unable to find a seat");
			return false;
		}
		
		// old method
//		for(Seat seat: seats) {
//			System.out.print(".");
//			if(seat.getSeatNum().equals(seatNum)) {
//				requestedSeat = seat;
//				break;
//			}
//		}
//		
//		if(requestedSeat == null) {
//			System.out.println("Unable to find a seat");
//			return false;
//		}
//		
//		return requestedSeat.reserved();
	}
	
/*
	public boolean reserveSeatSample(String seatNum) {
		int low = 0;
		int high = seats.size()-1;
		
		while(low <= high) {
		//	System.out.print(".");
			int mid = (low + high) /2;
			Seat midVal = seats.get(mid);
			int cmp = midVal.getSeatNum().compareTo(seatNum);
			
		//	System.out.println(cmp + " " + low + " " + mid + " " + high);
			
			if(cmp < 0) {
				low = mid +1;
			} else if (cmp > 0) {
				high = mid -1;
			} else {
				return seats.get(mid).reserved();
			}
			
		}
		
		System.out.println("Not found");
		return false;
	}
*/
	
	public void getSeats() {
		for(Seat seat: seats) {
			System.out.println(seat.getSeatNum());
		}
	}

	public class Seat implements Comparable<Seat>{
		
		private final String seatNum;
		private boolean reserved = false;
		
		public Seat(String seatNum) {
			this.seatNum = seatNum;
		}
		
		@Override
		public int compareTo(Seat seat) {
			return this.seatNum.compareToIgnoreCase(seat.getSeatNum());
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
