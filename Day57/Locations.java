package com.luiscasas;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location>{

	private static Map<Integer, Location> locations = new LinkedHashMap<>();
	private static Map<Integer, IndexRecord> index = new LinkedHashMap<>();
	
	public static void main(String[] args) throws IOException {
	
		try (RandomAccessFile rao = new RandomAccessFile("locations_rand.dat","rwd")){		
			rao.writeInt(locations.size());
			int indexSize = locations.size() * 3 * Integer.BYTES;
			int locationStart = (int) (indexSize + rao.getFilePointer() + Integer.BYTES);
			rao.writeInt(locationStart);
			
			long indexStart = rao.getFilePointer();
			
			int startPointer = locationStart;
			rao.seek(startPointer);
			
			for(Location location : locations.values()) {
				rao.writeInt(location.getLocationID());
				rao.writeUTF(location.getDescription());
				
				StringBuilder builder = new StringBuilder();
				for(String direction : location.getExits().keySet()) {
					if(!direction.equalsIgnoreCase("Q")) {
						builder.append(direction);
						builder.append(",");
						builder.append(location.getExits().get(direction));
						builder.append(",");
					}
				}
				
				rao.writeUTF(builder.toString());
				
				IndexRecord record = new IndexRecord(startPointer, (int) (rao.getFilePointer() - startPointer));
				index.put(location.getLocationID(), record);
				
				startPointer = (int) rao.getFilePointer();
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
		} catch (InvalidClassException e) {
			System.out.println("InvalidClassException:" + e.getMessage());
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
