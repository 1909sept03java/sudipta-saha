package com.expensereimbursementsystem.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.expensereimbursementsystem.beans.Employee_Table;

public class Employee_TableDAOImplTest {

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
	public void testLogin() {
		Employee_TableDAOImpl test = new Employee_TableDAOImpl();
		Employee_Table table  =  test.login("user1", "user1");
		table.getEmployee_id();
		assertEquals(table.getEmployee_id(),1000);
		
	}

	@Test
	public void testEmployeeUnderManager() {
		Employee_TableDAOImpl test = new Employee_TableDAOImpl();
		List<Employee_Table> tables = new ArrayList<Employee_Table>();
		tables = test.employeeUnderManager(1000);
		assertEquals(tables.get(1).getEmployee_id(),1000);
	}

	@Test
	public void testAllRemList() {
		Employee_TableDAOImpl test = new Employee_TableDAOImpl();
		List<Employee_Table> tables = new ArrayList<Employee_Table>();
		tables = test.allRemList();
		assertEquals(tables.get(1).getEmployee_id(),1000);
		
	}

	@Test
	public void testUpdateInfo() {
		Employee_TableDAOImpl test = new Employee_TableDAOImpl();
		
		assertTrue(test.updateInfo(1000, "John", "Adam"));
	}

	@Test
	public void testUpdatedName() {
		Employee_TableDAOImpl test = new Employee_TableDAOImpl();
		Employee_Table table  =  test.updatedName(1000);
		assertEquals(table.getFirstName(),"John");
	}

}
