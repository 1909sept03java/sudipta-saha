package com.week2challenge.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.week2challenge.employee.Employee;
import com.week2challenge.util.ConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO{

	@Override
	public List<Employee> getDepartments() {
		// TODO Auto-generated method stub
		List<Employee> cl = new ArrayList<>();
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT E.DEPARTMENT_ID, DEPARTMENT_NAME, AVG(SALARY) AS AVG FROM EMPLOYEE E INNER JOIN DEPARTMENT D ON D.DEPARTMENT_ID = E.DEPARTMENT_ID GROUP BY E.DEPARTMENT_ID ,DEPARTMENT_NAME"
;			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int dep_id = rs.getInt("DEPARTMENT_ID");
				String dep_name = rs.getString("DEPARTMENT_NAME");
				int avg = rs.getInt("AVG");
				//System.out.println(avg);
				cl.add(new Employee(dep_id, dep_name, avg));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return cl;
	}

}
