package com.homework1.arraylistprime;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

class ArraylistPrimeTest {

	@Test
	void testPrimeChecker() {
		ArrayList<Integer> arraylist = new ArrayList<Integer>();
		arraylist.add(2);
		arraylist.add(6);
		arraylist.add(7);
		arraylist = ArraylistPrime.primeChecker(arraylist);
		
		assertEquals(Arrays.asList(2,7), arraylist);
	}

}
