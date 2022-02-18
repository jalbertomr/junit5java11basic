package com.bext.junit5java11basic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyClassTest {

	
	@Test
	void testExceptionIsThrown() {
		MyClass tester = new MyClass();
		assertThrows(IllegalArgumentException.class, () -> tester.multiply( 1000, 5));
	}
	
	@Test
	void testMultiply() {
		MyClass tester = new MyClass();
		assertEquals(50, tester.multiply(10, 5), "10 x 5 must be 50");
	}

}