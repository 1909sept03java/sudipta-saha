package com.jdbcbank.dao;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;
import junit.framework.Assert;

import static org.junit.Assert.assertEquals;


public class BankUserDAOImplTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIsRegistered() {
		String s= "admin";
		BankUserDAOImpl bankUserDAOImpl = new BankUserDAOImpl();
		boolean b = BankUserDAOImpl.isRegistered(s);
		//System.out.println(b);
		boolean expected = true;
		assertEquals(b,expected);
	}

	@Test
	public void testDeleteUserAccount() {
		
	}

	@Test
	public void testLogin() {
		BankUserDAOImpl bankUserDAOImpl = new BankUserDAOImpl();
		int b = bankUserDAOImpl.login("admin", "password");
		//System.out.println(b);
		assertEquals(1000,b);
		//assertTrue(bankUserDAOImpl.login("admin", "password"));
	}

	@Test
	public void testUpdateUserAccount() {
		BankUserDAOImpl bankUserDAOImpl = new BankUserDAOImpl();
		assertEquals(true,bankUserDAOImpl.updateUserAccount(1003, "unittest", "junit"));
	}

}
