package com.expensereimbursementsystem.dao;

import java.util.List;

import com.expensereimbursementsystem.beans.Employee_Table;
public interface Employee_TableDAO {
	public Employee_Table login(String userName, String userPassword);
	public List<Employee_Table> employeeUnderManager(int employee_id);
	public List<Employee_Table> allRemList();
	public boolean updateInfo(int employee_id,String firstName,String lastName);
	public Employee_Table updatedName(int employee_id);
}
