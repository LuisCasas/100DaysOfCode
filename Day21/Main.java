package com.luiscasas;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Vehicle ferrari = (Vehicle) context.getBean("raceCar");
		ferrari.startUp();
	}

}
