package com.homework1.interestCalculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.homework1.factorial.Factorial;

class InterestCalculatorTest {

	@Test
	void testInterestCal() {
		assertEquals(8, InterestCalculator.interestCal(2, 2, 2));
	}

}
