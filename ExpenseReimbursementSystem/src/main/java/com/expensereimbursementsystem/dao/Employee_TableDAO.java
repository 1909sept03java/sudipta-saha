package com.expensereimbursementsystem.dao;

import com.expensereimbursementsystem.beans.Employee_Table;

public interface Employee_TableDAO {
	public Employee_Table login(String userName, String userPassword);
}
