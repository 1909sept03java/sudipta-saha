package com.expensereimbursementsystem.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.expensereimbursementsystem.beans.Reimbursement_Table;
import com.expensereimbursementsystem.service.ConnectionService;

public class Reimbursement_TableDAOImpl implements Reimbursement_TableDAO {

	@Override
	public List<Reimbursement_Table> getPersonalRemList(int employee_id) {
		List<Reimbursement_Table> tables = new ArrayList<Reimbursement_Table>();
		try (Connection con = ConnectionService.getConnection()) {
			String sql = "SELECT * FROM REIMBURSEMENT_TABLE WHERE EMPLOYEE_ID = ? ORDER BY REIMBURSEMENT_ID DESC";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, employee_id);
			pstmt.executeQuery();
			ResultSet rs=pstmt.getResultSet();
			while(rs.next()) {
				int reimbursement_id = rs.getInt("REIMBURSEMENT_ID");
				String details = rs.getString("DETAILS");
				String status = rs.getString("STATUS");
				double balance = rs.getDouble("BALANCE");
				//int employee_id = rs.getInt("EMPLOYEE_ID");
				LocalDate s_date = rs.getDate("S_DATE").toLocalDate();
				
				tables.add(new Reimbursement_Table(reimbursement_id, details, balance, employee_id, status,
						s_date));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tables;
	}

	@Override
	public boolean newTicket(int employee_id, String details, double balance) {
		try (Connection con = ConnectionService.getConnection()) {
			LocalDate s_date;
			String sql = "INSERT INTO REIMBURSEMENT_TABLE VALUES(1, ? , ? ,'Pending', ? , ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,details);
			pstmt.setDouble(2,balance);
			pstmt.setInt(3,employee_id);
			pstmt.setDate(4, java.sql.Date.valueOf(java.time.LocalDate.now()));
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

	@Override
	public boolean acceptTicket(int reimbursement_id) {
		try (Connection con = ConnectionService.getConnection()) {
			LocalDate s_date;
			String sql = "UPDATE REIMBURSEMENT_TABLE\r\n" + 
					"SET STATUS = 'Accepted'\r\n" + 
					"WHERE REIMBURSEMENT_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,reimbursement_id);
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

	@Override
	public boolean rejectTicket(int reimbursement_id) {
		try (Connection con = ConnectionService.getConnection()) {
			LocalDate s_date;
			String sql = "UPDATE REIMBURSEMENT_TABLE\r\n" + 
					"SET STATUS = 'Rejected'\r\n" + 
					"WHERE REIMBURSEMENT_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,reimbursement_id);
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

}
