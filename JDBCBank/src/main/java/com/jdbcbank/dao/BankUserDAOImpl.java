package com.jdbcbank.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jdbcbank.beans.BankAccount;
import com.jdbcbank.beans.BankUser;
import com.jdbcbank.util.ConnectionUtil;

public class BankUserDAOImpl implements BankUserDAO{
	@Override
	public List<BankUser> getAllAccounts() {
		List<BankUser> bl = new ArrayList<BankUser>();
		try (Connection con = ConnectionUtil.getConnection()) {
			String sql = "SELECT BANKUSER_ID,USERNAME,FIRSTNAME,LASTNAME FROM BANK_USER";				
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.executeQuery();
			ResultSet rs=pstmt.getResultSet();
			while(rs.next()) {
				int bankUserId  = rs.getInt("BANKUSER_ID");
				String username = rs.getString("USERNAME");
				String firstname = rs.getString("FIRSTNAME");
				String lastname = rs.getString("LASTNAME");
				//double balance  = rs.getDouble("BALANCE");
				//LocalDate birthdate = rs.getDate("BIRTHDATE").toLocalDate();

				bl.add(new BankUser(bankUserId, username, firstname, lastname));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bl;


	}

	@Override
	public boolean createBankUser() {
		String userName;
		String userPassword;
		String firstName;
		String lastName;
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter Your First Name: ");
		firstName = sc.nextLine();
		System.out.println("Enter Your Last Name: ");
		lastName = sc.nextLine().toLowerCase();
		System.out.println("Enter Username: ");
		userName = sc.nextLine().toLowerCase();
		while(isRegistered(userName)) {
			System.out.println("Username has been taken!");
			System.out.println("Please enter a different username.");
			System.out.println("Enter Username: ");
			userName = sc.nextLine().toLowerCase();
		}
		System.out.println("Enter Password: ");
		userPassword = sc.nextLine().toLowerCase();
		try (Connection con = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO BANK_USER (BANKUSER_ID,USERNAME,USERPASSWORD,FIRSTNAME,LASTNAME) VALUES (1,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,userName);
			pstmt.setString(2,userPassword);
			pstmt.setString(3,firstName);
			pstmt.setString(4,lastName);
			if(pstmt.executeUpdate() == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;

	}

	public static boolean isRegistered(String userName) {
		String str;
		try (Connection con = ConnectionUtil.getConnection()) {
			String sql = "SELECT USERNAME FROM BANK_USER WHERE USERNAME =?";			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.executeQuery();
			ResultSet rs=pstmt.getResultSet();
			while(rs.next()) {
				str = rs.getString("USERNAME");
				if(str.equals(userName)) {
					return true;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return false;
	}


	@Override
	public boolean deleteUserAccount(int bankUserId) {
		try (Connection con = ConnectionUtil.getConnection()) {
			String sql = "DELETE BANK_ACCOUNT WHERE BANKUSER_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,bankUserId);
			pstmt.executeUpdate();
			sql = "DELETE BANK_USER WHERE BANKUSER_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,bankUserId);
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
	public int login(String userName, String userPassword) {
		try (Connection con = ConnectionUtil.getConnection()) {
			String sql = "SELECT BANKUSER_ID FROM BANK_USER WHERE USERNAME =? AND USERPASSWORD =?";			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.setString(2, userPassword);
			pstmt.executeQuery();
			ResultSet rs=pstmt.getResultSet();
			while(rs.next()) {
				int pass = rs.getInt("BANKUSER_ID");
				return pass;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public boolean updateUserAccount(int bankUserId, String firstName, String lastName) {
		try (Connection con = ConnectionUtil.getConnection()) {
			String sql = "UPDATE BANK_USER SET FIRSTNAME = ? , LASTNAME = ? WHERE BANKUSER_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, firstName);
			pstmt.setString(2, lastName);
			pstmt.setInt(3,bankUserId);
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
