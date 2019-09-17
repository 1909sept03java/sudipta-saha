package com.week2challenge.main;
import com.week2challenge.dao.EmployeeDAO;
import com.week2challenge.dao.EmployeeDAOImpl;
import com.week2challenge.employee.Employee;

public class Driver {

	public static void main(String[] args) {
		
//		try {
//			Connection conn = ConnectionUtil.getConnection();
//			System.out.println(conn);
//			System.out.println(conn.getMetaData().getDatabaseMajorVersion());
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
		EmployeeDAO cd = new EmployeeDAOImpl();
		System.out.printf( "%-15s %-20s %-15s %n","Department ID", "Department Name", "Average Salary");
		for (Employee c : cd.getDepartments()) {
			System.out.printf( "%-15s %-20s %-15s %n",c.getDepratment_id(),c.getDepName(),c.getAvg());
		}
	
	}

}