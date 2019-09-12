package com.homework1.reversestring;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ReverseStringTest {

	@Test
	void testReverse() {
		assertEquals("cba", ReverseString.reverse("abc"));
	}

}
