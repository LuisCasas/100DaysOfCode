package com.luiscasas;

public class Main {

	public static void main(String[] args) {
		User user1 = new User.Builder("casasl", "msdkm2").build();
		User user2 = new User.Builder("mikeT", "fsdkn3").firstname("Mike").lastname("Smith").email("mike@smith.com").build();
		
		System.out.println(user1.toString());
		System.out.println(user2.toString());
	}

}
