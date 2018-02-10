package com.luiscasas;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
//		int x = 85;
//		int y = 0;
//		
//		System.out.println(divideL(x,y));
//		System.out.println(divideE(x,y));
	//	System.out.println(divide(x,y));
		
		int e = getIntE();
		System.out.println("x is " + e);
		
	}
	
	private static int getInt() {
		Scanner s = new Scanner(System.in);
		return s.nextInt();
	}
	
	private static int getIntE() {
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter a integer");
		
		try {
			return s.nextInt();
		} catch (InputMismatchException e) {
			return 0;
		}
	}
	
	private static int getIntL() {
		Scanner s = new Scanner(System.in);
		boolean isValid = true;
		System.out.println("Please enter a integer");
		String input = s.next();
		
		for(int i = 0; i < input.length(); i++) {
			if(!Character.isDigit(input.charAt(i))) {
				isValid = false;
				break;
			}
		}
		
		if(isValid) {
			return Integer.parseInt(input);
		}
		return 0;
	}
	
	private static int divideL(int x, int y) {
		if(y != 0) {
			return x / y;
		} else {
			return 0;
		}
	}
	
	private static int divideE(int x, int y) {
		try {
			return x / y;
		} catch(ArithmeticException e) {
			return 0;
		}
	}
	
	private static int divide(int x, int y) {
		return x / y;
	}	
}
