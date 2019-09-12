package com.homework1.evencheck;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EvenCheckerTest {

	@Test
	void testevenCheck() {
		assertTrue(EvenChecker.evenCheck(6));
		assertFalse(EvenChecker.evenCheck(3));
	}

}
