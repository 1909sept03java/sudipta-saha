package com.jdbcbank.dao;

import java.util.List;

import com.jdbcbank.beans.BankAccount;

public interface BankAccountDAO {
	public List<BankAccount> getAccounts(int id);//done
	public void withDraw (int accountId, double balance);//done
	public void deposit (int accountId, double balance);//done
	public boolean createBankAccount(int bankUserId);//done
	public boolean deleteBankAccount (int accountId);//done
	public double balance(int accountId);//done
}
