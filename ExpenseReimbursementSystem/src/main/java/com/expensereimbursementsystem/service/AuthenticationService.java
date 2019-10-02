package com.expensereimbursementsystem.service;

import com.expensereimbursementsystem.beans.Credentials;
import com.expensereimbursementsystem.beans.Employee_Table;
import com.expensereimbursementsystem.dao.Employee_TableDAO;
import com.expensereimbursementsystem.dao.Employee_TableDAOImpl;

public class AuthenticationService {
	
	// if credentials are not recognized, return null
	// if they are, return user associated with them
	public Employee_Table authenticateUser(Credentials creds) {
		//User u = null;
		Employee_Table table = null;
		Employee_TableDAO employee_TableDAO = new Employee_TableDAOImpl();
		//System.out.println(creds.getUsername());
		table = employee_TableDAO.login(creds.getUsername(), creds.getPassword());
		//System.out.println(table);
		if(table != null) {
			return table;
		}
		return null;
	}

}
