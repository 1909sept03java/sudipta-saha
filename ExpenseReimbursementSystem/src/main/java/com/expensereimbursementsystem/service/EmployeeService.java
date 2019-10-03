package com.expensereimbursementsystem.service;

import java.util.List;

import com.expensereimbursementsystem.beans.Employee_Table;
import com.expensereimbursementsystem.dao.Employee_TableDAO;
import com.expensereimbursementsystem.dao.Employee_TableDAOImpl;

public class EmployeeService {
	private Employee_TableDAO tableDAO = new Employee_TableDAOImpl();
	
		public List<Employee_Table> employeeUnderManager(int employee_id) {
			return tableDAO.employeeUnderManager(employee_id);
		}
		public List<Employee_Table>  allRemList () {
			return tableDAO.allRemList();
		}

}
