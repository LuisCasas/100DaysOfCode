package com.luiscasas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Locations implements Map<Integer, Location>{

	private static Map<Integer, Location> locations = new LinkedHashMap<>();
	
	public static void main(String[] args) throws IOException {
	
		try(BufferedWriter locFile = new BufferedWriter(new FileWriter("locations.txt"));
			BufferedWriter dirFile = new BufferedWriter(new FileWriter("directions.txt"))){
			
			for(Location location : locations.values()) {
				locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
				for(String direction : location.getExits().keySet()) {
					if(!direction.equalsIgnoreCase("Q")) {
						dirFile.write(location.getLocationID() + "," + direction + "," + location.getExits().get(direction) + "\n");
					}
				}
			}
		}	
	}

	static {
		
		try (BufferedReader locFile = new BufferedReader(new FileReader("locations_big.txt"))){
			
			String input;
			
			while((input = locFile.readLine()) != null) {
				
				String[] data = input.split(",");
				int loc = Integer.parseInt(data[0]);
				String description = data[1];
				System.out.println("Imported location: " + loc + ": " + description);
				Map<String, Integer> tempExits = new HashMap<>();
				locations.put(loc, new Location(loc, description, tempExits));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		try(BufferedReader dirFile = new BufferedReader(new FileReader("directions_big.txt"))){
			
			String input;
			
			while((input = dirFile.readLine()) != null) {
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
		} 	
	}
	
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
