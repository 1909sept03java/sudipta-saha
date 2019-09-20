package com.jdbcbank.dao;

import java.util.List;

import com.jdbcbank.beans.BankUser;

public interface BankUserDAO {
	public List<BankUser> getAllAccounts();//done
	public boolean createBankUser();//done
	public boolean deleteUserAccount (int bankUserId);//done
	public int login(String userName, String userPassword);//done
	public boolean updateUserAccount (int bankUserId, String firstName, String lastName);//done
}
