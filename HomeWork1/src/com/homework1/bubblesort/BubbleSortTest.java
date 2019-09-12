package com.homework1.bubblesort;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BubbleSortTest {

	@Test
	void testBSort() {
		int input[] = {1,3,4,2,5};
		int ans[] = {1,2,3,4,5};
		input = BubbleSort.bSort(input);
		assertArrayEquals(ans, input);
	}
}
