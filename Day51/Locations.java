package com.luiscasas;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Locations implements Map<Integer, Location>{

	private static Map<Integer, Location> locations = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		FileWriter locFile = null;
		try {
			
			locFile = new FileWriter("location.txt");
			for(Location location : locations.values()) {
				locFile.write(location.getLocationID() + ", "+location.getDescription() + "\n");
			}
			
		} catch(IOException e) {
			System.out.println("In catch block");
			e.printStackTrace();
		} finally {
			System.out.println("");
			try {
				if(locFile != null) {
					locFile.close();
				}
			} catch(IOException e) {
				System.out.println("Finally catch block");
				e.printStackTrace();
			}
		}
	}
	
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
