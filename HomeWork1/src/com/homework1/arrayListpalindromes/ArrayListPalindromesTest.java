package com.homework1.arrayListpalindromes;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayListPalindromesTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testPalindrome() {
		ArrayList<String> arraylist = new ArrayList<String>();
		arraylist.add("aabaa");
		arraylist.add("bba");
		arraylist.add("cac");
		arraylist = ArrayListPalindromes.palindrome(arraylist);
		assertEquals(Arrays.asList("aabaa","cac"), arraylist);
		
	}

}
