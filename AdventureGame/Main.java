package com.luiscasas;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	
	private static Map<Integer, Location> locations = new HashMap<Integer, Location>();
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		locations.put(0, new Location(0, "You are in a room in front of a computer learning java"));
		locations.put(1, new Location(1, "You are standing the middle of a road"));
		locations.put(2, new Location(2, "You are at the top of a hill"));
		locations.put(3, new Location(3, "You are inside a house"));
		locations.put(4, new Location(4, "You are in a valley"));
		locations.put(5, new Location(5, "You are in a forest"));
		
		locations.get(1).addExist("W", 2);
		locations.get(1).addExist("E", 3);
		locations.get(1).addExist("S", 4);
		locations.get(1).addExist("N", 5);
		
		locations.get(2).addExist("N", 1);
		
		locations.get(3).addExist("W", 1);
		
		locations.get(4).addExist("N", 1);
		locations.get(4).addExist("W", 2);
		
		locations.get(5).addExist("S", 1);
		locations.get(5).addExist("W", 2);
		
		Map<String, String> vocabulary = new HashMap<String, String>();
		vocabulary.put("QUIT", "Q");
		vocabulary.put("NORTH", "N");
		vocabulary.put("SOUTH", "S");
		vocabulary.put("WEST", "W");
		vocabulary.put("EAST", "E");
		
		int loc = 1;
		while(true) {
			System.out.println(locations.get(loc).getDescription());
			if(loc == 0) {
				break;
			}
			
			Map<String, Integer> exits = locations.get(loc).getExits();
			System.out.println("Available exits:");
			
			for(String exit : exits.keySet()) {
				System.out.print( exit + ", ");
			}
			System.out.println();
			
			String direction = scanner.nextLine().toUpperCase();
			
			if(direction.length() > 1) {
				String[] words = direction.split(" ");
				
				for(String word : words) {
					if(vocabulary.containsKey(word)) {
						direction = vocabulary.get(word);
						break;
					}
				}
			}
			
			if(exits.containsKey(direction)) {
				loc = exits.get(direction);
			} else{
				System.out.println("You cannot go in that direction");
			}
			
//			else {
//				direction = convertDirection(direction);
//				
//				if (exits.containsKey(direction)){
//					loc = exits.get(direction);
//				} else{
//					System.out.println("You cannot go in that direction");
//				}
//			}
		}
	}	
	
	
//	public static String convertDirection(String text) {
//		
//		String[] words = text.split(" ");
//		
//		for(String word : words) {
//			
//			if(word.toLowerCase().equals("north")) {
//				return "N";
//			} else if(word.toLowerCase().equals("south")) {
//				return "S";
//			} else if(word.toLowerCase().equals("west")) {
//				return "W";
//			} else if(word.toLowerCase().equals("east")) {
//				return "E";
//			} else if(word.toLowerCase().equals("quit")) {
//				return "Q";
//			}
//		}
//		
//		return null;
//	}
	

}
