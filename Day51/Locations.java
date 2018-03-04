package com.luiscasas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Locations implements Map<Integer, Location>{

	private static Map<Integer, Location> locations = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
	
		try(FileWriter locFile = new FileWriter("locations.txt");
			FileWriter dirFile = new FileWriter("directions.txt")){
			for(Location location : locations.values()) {
				locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
				for(String direction : location.getExits().keySet()) {
					dirFile.write(location.getLocationID() + "," + direction + "," + location.getExits().get(direction) + "\n");
				}
			}
		}	
	}

	static {

		Scanner scanner = null;
		
		try {
			scanner = new Scanner(new FileReader("locations.txt"));
			scanner.useDelimiter(",");
			
			while(scanner.hasNextLine()) {
				int loc = scanner.nextInt();
				scanner.skip(scanner.delimiter());
				String description = scanner.nextLine();
				System.out.println("Imported location: " + loc + ": " + description);
				Map<String, Integer> tempExits = new HashMap<>();
				locations.put(loc, new Location(loc, description, tempExits));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(scanner != null) {
				scanner.close();
			}
		}
		
		// read exits
		try {
			scanner = new  Scanner(new BufferedReader(new FileReader("directions.txt")));
			scanner.useDelimiter(",");
			
			while(scanner.hasNextLine()) {
//				int loc = scanner.nextInt();
//				String direction = scanner.next();
//				scanner.skip(scanner.delimiter());
//				String dest = scanner.nextLine();
//				int destination = Integer.parseInt(dest);
			
				String input = scanner.nextLine();
				String[] data = input.split(",");
				int loc = Integer.parseInt(data[0]);
				String direction = data[1];
				int destination = Integer.parseInt(data[2]);
				
				System.out.println(loc + ": " + direction + ": " + destination);
				Location location = locations.get(loc);
				location.addExit(direction, destination);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(scanner != null) {
				scanner.close();
			}
		}		
	}
	
	/*	
	static {
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
	}	
*/		

	@Override
	public void clear() {
		locations.clear();
	}

	@Override
	public boolean containsKey(Object key) {
		return locations.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return locations.containsValue(value);
	}

	@Override
	public Set<Entry<Integer, Location>> entrySet() {
		return locations.entrySet();
	}

	@Override
	public Location get(Object key) {
		return locations.get(key);
	}

	@Override
	public boolean isEmpty() {
		return locations.isEmpty();
	}

	@Override
	public Set<Integer> keySet() {
		return locations.keySet();
	}

	@Override
	public Location put(Integer key, Location value) {
		return locations.put(key, value);
	}

	@Override
	public void putAll(Map<? extends Integer, ? extends Location> arg0) {
		
	}

	@Override
	public Location remove(Object key) {
		return locations.remove(key);
	}

	@Override
	public int size() {
		return locations.size();
	}

	@Override
	public Collection<Location> values() {
		return locations.values();
	}
	
}
