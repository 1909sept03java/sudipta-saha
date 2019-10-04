package com.expensereimbursementsystem.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.expensereimbursementsystem.beans.Reimbursement_Table;

public class Reimbursement_TableDAOImplTest {

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
	public void testGetPersonalRemList() {
		Reimbursement_TableDAO tableDAO = new Reimbursement_TableDAOImpl();
		List<Reimbursement_Table> tables = new ArrayList<Reimbursement_Table>();
		tables = tableDAO.getPersonalRemList(1000);
		//System.out.println(tables);
		assertEquals(tables.get(0).getEmployee_id(), 1000);
	}

	@Test
	public void testNewTicket() {
		Reimbursement_TableDAO tableDAO = new Reimbursement_TableDAOImpl();
		assertTrue(tableDAO.newTicket(1000, "Junit Test", 101));
	}

	@Test
	public void testAcceptTicket() {
		Reimbursement_TableDAO tableDAO = new Reimbursement_TableDAOImpl();
		assertTrue(tableDAO.acceptTicket(1000));
	}

	@Test
	public void testRejectTicket() {
		Reimbursement_TableDAO tableDAO = new Reimbursement_TableDAOImpl();
		assertTrue(tableDAO.acceptTicket(1000));
	}

}
