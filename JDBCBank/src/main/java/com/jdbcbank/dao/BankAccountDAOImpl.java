package com.jdbcbank.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.jdbcbank.beans.BankAccount;
import com.jdbcbank.util.ConnectionUtil;

public class BankAccountDAOImpl implements BankAccountDAO{

	public List<BankAccount> getAccounts(int id) {
		List<BankAccount> bl = new ArrayList<BankAccount>();
		try (Connection con = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM BANK_ACCOUNT WHERE BANKUSER_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeQuery();
			ResultSet rs=pstmt.getResultSet();
			while(rs.next()) {
				int accountId  = rs.getInt("ACCOUNT_ID");
				String accountName = rs.getString("ACCOUNTNAME");
				double balance  = rs.getDouble("BALANCE");
				//LocalDate birthdate = rs.getDate("BIRTHDATE").toLocalDate();
				int bankUserId  = rs.getInt("BANKUSER_ID");
				bl.add(new BankAccount(accountId, accountName, balance, bankUserId));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bl;


	}
	
	@Override
	public double balance(int accountId) {
		try (Connection con = ConnectionUtil.getConnection()) {
			String sql = "SELECT BALANCE FROM BANK_ACCOUNT WHERE ACCOUNT_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, accountId);
			pstmt.executeQuery();
			ResultSet rs=pstmt.getResultSet();
			while(rs.next()) {
				double balance  = rs.getDouble("BALANCE");
				return balance;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;	
	}

	@Override
	public void withDraw(int accountId, double balance) {
		CallableStatement cs = null;
		try(Connection con = ConnectionUtil.getConnection()){
			
			String sql = "{call WITHDRAW (?,?)}";
			cs = con.prepareCall(sql);
			cs.setInt(1, accountId);
			cs.setDouble(2, balance);
			cs.execute();
			//System.out.println(cs.execute());
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deposit(int accountId,double balance) {
		CallableStatement cs = null;
		try(Connection con = ConnectionUtil.getConnection()){
			
			String sql = "{call DEPOSIT (?,?)}";
			cs = con.prepareCall(sql);
			cs.setInt(1, accountId);
			cs.setDouble(2, balance);
			cs.execute();
			//System.out.println(cs.execute());
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public boolean deleteBankAccount(int accountId) {
		try (Connection con = ConnectionUtil.getConnection()) {
			String sql = "DELETE BANK_ACCOUNT WHERE ACCOUNT_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,accountId);
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

	@Override
	public boolean createBankAccount(int bankUserId) {
		String accountName;
		double balance=0;
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter Account Name: ");
		accountName = sc.nextLine().toLowerCase();
		System.out.println("Initial deposit amount: ");
		String numString = sc.nextLine();
		try {
			balance = Double.parseDouble(numString);
		}
		catch(NumberFormatException e) {
			System.out.println("You entered an invalid value.");
			System.out.println("Please Start Over!");
			createBankAccount(bankUserId);
		}
		
		try (Connection con = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO BANK_ACCOUNT VALUES(1,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,accountName);
			pstmt.setDouble(2,balance);
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
