package com.luiscasas;

import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
	
	private static Map<String, HeavenlyBody> solarSystem = new HashMap<>();	
	private static Set<HeavenlyBody> planets = new HashSet<>();

	public static void main(String[] args) {
		
		HeavenlyBody temp = new HeavenlyBody("Mercury", 88);
		solarSystem.put(temp.getName(), temp);
		planets.add(temp);
		
		temp = new HeavenlyBody("Venus", 255);
		solarSystem.put(temp.getName(), temp);
		planets.add(temp);
		
		temp = new HeavenlyBody("Earth", 365);
		solarSystem.put(temp.getName(), temp);
		planets.add(temp);		
		
		HeavenlyBody tempMoon = new HeavenlyBody("Moon", 27);
		solarSystem.put(tempMoon.getName(), tempMoon);
		temp.addMoon(tempMoon);
		
		System.out.println("Planets");
		
		for(HeavenlyBody planet : planets) {
			System.out.println("\t" + planet.getName());
		}
		
		HeavenlyBody body = solarSystem.get("Earth");
		System.out.println("Moons on " + body.getName());
		
		for(HeavenlyBody moon : body.getSatellites()) {
			System.out.println("\t" + moon.getName());
		}
		
		Set<HeavenlyBody> moons = new HashSet<>();
		for(HeavenlyBody planet : planets) {
			moons.addAll(planet.getSatellites());
		}
		
		System.out.println("Moons:");
		for(HeavenlyBody moon : moons) {
			System.out.println("\t"+ moon.getName());
		}
		
	}

}
