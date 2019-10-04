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
		public boolean updateInfo(int employee_id,String firstName,String lastName) {
			return tableDAO.updateInfo(employee_id, firstName, lastName);
		}
		public Employee_Table updatedName(int employee_id) {
			return tableDAO.updatedName(employee_id);
		}
}
