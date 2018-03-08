package com.luiscasas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Locations implements Map<Integer, Location>{

	private static Map<Integer, Location> locations = new LinkedHashMap<Integer, Location>();
	
	public static void main(String[] args) throws IOException {
	
		try (ObjectOutputStream locFile = new ObjectOutputStream(new BufferedOutputStream( new FileOutputStream("locations.dat")))){		
			for(Location location : locations.values()) {
				locFile.writeObject(location);
			}		
		}
	}

	static {
		
		try (ObjectInputStream locFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("locations.dat")))){
			
			boolean endFile = false;
			
			while(!endFile) {
				
				try {
					Location location = (Location) locFile.readObject();
					
					System.out.println("Read location: " + location.getLocationID() + " : " + location.getDescription());
					System.out.println("Found " + location.getExits().size() + " exits");
					
					locations.put(location.getLocationID(), location);
				} catch (EOFException e) {
					endFile = true;
				}
			}
		} catch (IOException io) {
			System.out.println("IOException:" + io.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFound" + e.getMessage());
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
