package com.jdbcbank.beans;

public class BankAccount {
	private int accountId;
	private String accountName;
	private double balance;
	private int bankUserId;
	public BankAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BankAccount(int accountId, String accountName, double balance, int bankUserId) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.balance = balance;
		this.bankUserId = bankUserId;
	}
	public BankAccount(int accountId, String accountName) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getBankUserId() {
		return bankUserId;
	}
	public void setBankUserId(int bankUserId) {
		this.bankUserId = bankUserId;
	}
}
