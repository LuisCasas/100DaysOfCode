package com.luiscasas;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		Map<String, String> languages = new HashMap<>();
		
		addKey(languages, "Java", "High level Object Oriented programming language");
		addKey(languages, "C#", "Similar to Java, High level Object Oriented programming language");
		addKey(languages, "JavaScrip", "Front-end programming language");
		addKey(languages, "PHP", "Back-end programming language");
		addKey(languages, "Ruby", "Back-end programming language");
		
		System.out.println("=======================");
		
		// remove key
		languages.remove("Ruby");
		
		if(languages.remove("PHP", "language")) {
			System.out.println("PHP removed");
		} else {
			System.out.println("key/value pair not found");
		}
		
		// replace
		
		if(languages.replace("PHP", "test", "Back-end Object Oriented programming language")) {
			System.out.println("PHP replaced");
		} else {
			System.out.println("PHP");
		}
		
		// System.out.println(languages.replace("PHP", "Back-end Object Oriented programming language"));
		
		
		for(String key : languages.keySet()) {
			System.out.println( key + " : " + languages.get(key));
		}
		
	}

	
	public static Map<String, String> addKey(Map<String, String> languages, String key, String value ){
		
		if(languages.containsKey(key)) {
			System.out.println( key + " already exists!");
		} else {
			languages.put(key, value);
			System.out.println( "New value " + key + " : " + value + " added");
		}
		
		
		return languages;
	}
}
