package com.tsl.example.cars.model;

import junit.framework.TestCase;

public class CarTest extends TestCase {

	public void testEquals() {
		Car c1 = new Car(1l, "Alfa Romeo", "159");
		Car c2 = new Car(1l, "Alfa Romeo", "159");
		assertEquals(c1, c2);
	}
	
}
