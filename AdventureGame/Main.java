package com.luiscasas;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	
	private static Map<Integer, Location> locations = new HashMap<Integer, Location>();
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Map<String, Integer> tempExit = new HashMap<String, Integer>();
		locations.put(0, new Location(0, "You are in a room in front of a computer learning java",tempExit));
		
		tempExit = new HashMap<String, Integer>();
		tempExit.put("W", 2);
		tempExit.put("E", 3);
		tempExit.put("S", 4);
		tempExit.put("N", 5);
		locations.put(1, new Location(1, "You are standing the middle of a road", tempExit));
				
		tempExit = new HashMap<String, Integer>();
		tempExit.put("N", 1);
		locations.put(2, new Location(2, "You are at the top of a hill", tempExit));
				
		tempExit = new HashMap<String, Integer>();
		tempExit.put("W", 1);
		locations.put(3, new Location(3, "You are inside a house", tempExit));
				
		tempExit = new HashMap<String, Integer>();
		tempExit.put("N", 1);
		tempExit.put("W", 2);
		locations.put(4, new Location(4, "You are in a valley", tempExit));
		
		tempExit = new HashMap<String, Integer>();
		tempExit.put("S", 1);
		tempExit.put("W", 2);
		locations.put(5, new Location(5, "You are in a forest", tempExit));
		
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
