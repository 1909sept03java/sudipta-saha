package com.expensereimbursementsystem.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.expensereimbursementsystem.beans.Employee_Table;
import com.expensereimbursementsystem.service.ConnectionService;
public class Employee_TableDAOImpl implements Employee_TableDAO  {

	@Override
	public Employee_Table login(String userName, String userPassword) {
		try (Connection con = ConnectionService.getConnection()) {
			Employee_Table table = new Employee_Table();
			String sql = "SELECT * FROM EMPLOYEE_TABLE WHERE USERNAME =? AND USERPASSWORD =?";			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.setString(2, userPassword);
			pstmt.executeQuery();
			ResultSet rs=pstmt.getResultSet();
			while(rs.next()) {
				table.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
				table.setFirstName(rs.getString("FIRSTNAME"));
				table.setLastName(rs.getString("LASTNAME"));
				table.setIsAdmin(rs.getInt("ISADMIN"));
				table.setManager_id(rs.getInt("MANAGER_ID"));
				return table;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

}
