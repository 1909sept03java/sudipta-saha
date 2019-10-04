package com.expensereimbursementsystem.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.expensereimbursementsystem.beans.Employee_Table;
import com.expensereimbursementsystem.beans.Reimbursement_Table;
import com.expensereimbursementsystem.service.ConnectionService;
public class Employee_TableDAOImpl implements Employee_TableDAO  {
	//verifies the username and password
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
	//Returns all the reimbursement list with employee name under a specific manager
	@Override
	public List<Employee_Table> employeeUnderManager(int employee_id) {
		List<Employee_Table> tables = new ArrayList<Employee_Table>();
		try (Connection con = ConnectionService.getConnection()) {
			
			String sql = "SELECT * FROM (SELECT * FROM (SELECT E.EMPLOYEE_ID ,E.FIRSTNAME, E.LASTNAME, E.ISADMIN, E.MANAGER_ID, M.FIRSTNAME AS M_F, M.LASTNAME AS M_L\r\n" + 
					"FROM EMPLOYEE_TABLE E, EMPLOYEE_TABLE M\r\n" + 
					"WHERE E.MANAGER_ID = M.EMPLOYEE_ID) E\r\n" + 
					"JOIN REIMBURSEMENT_TABLE R\r\n" + 
					"ON E.EMPLOYEE_ID = R.EMPLOYEE_ID)\r\n" + 
					"WHERE MANAGER_ID = ? ORDER\r\n" + 
					"BY REIMBURSEMENT_ID DESC";			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, employee_id);
			pstmt.executeQuery();
			ResultSet rs=pstmt.getResultSet();
			while(rs.next()) {
				Employee_Table table = new Employee_Table();
				table.setEmployee_id(rs.getInt("EMPLOYEE_ID")); 
				table.setFirstName(rs.getString("FIRSTNAME"));
				table.setLastName(rs.getString("LASTNAME"));
				table.setIsAdmin(rs.getInt("ISADMIN"));
				table.setManager_id(rs.getInt("MANAGER_ID"));
				table.setM_f(rs.getString("M_F"));
				table.setM_l(rs.getString("M_L"));
				int reimbursement_id = rs.getInt("REIMBURSEMENT_ID");
				String details = rs.getString("DETAILS");
				String status = rs.getString("STATUS");
				double balance = rs.getDouble("BALANCE");
				//int employee_id = rs.getInt("EMPLOYEE_ID");
				LocalDate s_date = rs.getDate("S_DATE").toLocalDate();
				table.setRtable(new Reimbursement_Table(reimbursement_id, details, balance, employee_id, status, s_date));
				tables.add(table);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tables;
	}
	
	//Returns all the reimbursement list with manager name
	@Override
	public List<Employee_Table> allRemList() {
		List<Employee_Table> tables = new ArrayList<Employee_Table>();
		try (Connection con = ConnectionService.getConnection()) {
			
			String sql = "SELECT * FROM (SELECT E.EMPLOYEE_ID ,E.FIRSTNAME, E.LASTNAME, E.ISADMIN, E.MANAGER_ID, M.FIRSTNAME AS M_F, M.LASTNAME AS M_L\r\n" + 
					"FROM EMPLOYEE_TABLE E, EMPLOYEE_TABLE M\r\n" + 
					"WHERE E.MANAGER_ID = M.EMPLOYEE_ID) E\r\n" + 
					"JOIN REIMBURSEMENT_TABLE R\r\n" + 
					"ON E.EMPLOYEE_ID = R.EMPLOYEE_ID "+ 
					"ORDER BY REIMBURSEMENT_ID DESC";			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.executeQuery();
			ResultSet rs=pstmt.getResultSet();
			while(rs.next()) {
				Employee_Table table = new Employee_Table();
				table.setEmployee_id(rs.getInt("EMPLOYEE_ID")); 
				table.setFirstName(rs.getString("FIRSTNAME"));
				table.setLastName(rs.getString("LASTNAME"));
				table.setIsAdmin(rs.getInt("ISADMIN"));
				table.setManager_id(rs.getInt("MANAGER_ID"));
				table.setM_f(rs.getString("M_F"));
				table.setM_l(rs.getString("M_L"));
				int reimbursement_id = rs.getInt("REIMBURSEMENT_ID");
				String details = rs.getString("DETAILS");
				String status = rs.getString("STATUS");
				double balance = rs.getDouble("BALANCE");
				int employee_id = rs.getInt("EMPLOYEE_ID");
				LocalDate s_date = rs.getDate("S_DATE").toLocalDate();
				table.setRtable(new Reimbursement_Table(reimbursement_id, details, balance, employee_id, status, s_date));
				tables.add(table);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tables;
	}
	//Updates the the firstname and lastname
	@Override
	public boolean updateInfo(int employee_id, String firstName, String lastName) {
		try (Connection con = ConnectionService.getConnection()) {
			String sql = "UPDATE EMPLOYEE_TABLE\r\n" + 
					"SET FIRSTNAME = ? , LASTNAME = ?\r\n" + 
					"WHERE EMPLOYEE_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, firstName);
			pstmt.setString(2, lastName);
			pstmt.setInt(3,employee_id);
			if(pstmt.executeUpdate() == 1) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//Returns the firstname and lastname 
	@Override
	public Employee_Table updatedName(int employee_id) {
		try (Connection con = ConnectionService.getConnection()) {
			String sql = "SELECT FIRSTNAME,LASTNAME FROM EMPLOYEE_TABLE WHERE EMPLOYEE_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, employee_id);
			pstmt.executeQuery();
			ResultSet rs=pstmt.getResultSet();
			while(rs.next()) {
				Employee_Table table = new Employee_Table(); 
				table.setFirstName(rs.getString("FIRSTNAME"));
				table.setLastName(rs.getString("LASTNAME"));
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
