package com.homework1.factorial;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FactorialTest {

	@Test
	void testFactorial() {
		assertEquals(6, Factorial.factorial(3));
	}

}
