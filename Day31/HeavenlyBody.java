package com.luiscasas;

import java.util.HashSet;
import java.util.Set;

public final class HeavenlyBody {
	
	private final String name;
	private final double orbitalPlanet;
	private final Set<HeavenlyBody> satellites;
	
	public HeavenlyBody(String name, double orbitalPlanet) {
		super();
		this.name = name;
		this.orbitalPlanet = orbitalPlanet;
		this.satellites = new HashSet<>();
	}

	public String getName() {
		return name;
	}

	public double getOrbitalPlanet() {
		return orbitalPlanet;
	}
	
	public boolean addMoon(HeavenlyBody moon) {
		return this.satellites.add(moon);
	}
	
	public Set<HeavenlyBody> getSatellites(){
		return new HashSet(this.satellites);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		
		System.out.println("Object obj class " + obj.getClass());
		System.out.println("Object this class " + this.getClass());
		
		if((obj == null) || (obj.getClass() != this.getClass())) {
			return false;
		} 
		
		String objName = ((HeavenlyBody) obj).getName();	
		return this.name.equals(objName);
	}

	@Override
	public int hashCode() {
		System.out.println("Hashcode called");
		return this.name.hashCode() + 57;
	}
	
	

}
