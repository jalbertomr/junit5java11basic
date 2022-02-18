package com.bext.junit5java11basic;


public class MyClass {  //In eclipse Ctrl-1 over MyClass to create new JUnit Test

	public int multiply(int x, int y) {
		if (x < 999) {
			throw new IllegalArgumentException("X should be less than 100");
		}
		return x / y;
	}
}
