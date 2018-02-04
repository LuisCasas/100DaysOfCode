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

}
