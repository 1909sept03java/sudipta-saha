package com.jdbcbank.beans;

public class BankUser {
	private int bankUser;
	private String userName;
	private String userPassword;
	private String firstName;
	private String lastName;
	private int isAdmin;
	private BankAccount bankAccount;
	public BankUser(int bankUser, String userName, String firstName, String lastName) {
		super();
		this.bankUser = bankUser;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "BankUser [bankUser=" + bankUser + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", isAdmin=" + isAdmin + ", bankAccount="
				+ bankAccount + "]";
	}
	public BankAccount getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	public BankUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BankUser(int bankUser, String userName, String userPassword, String firstName, String lastName,
			int isAdmin) {
		super();
		this.bankUser = bankUser;
		this.userName = userName;
		this.userPassword = userPassword;
		this.firstName = firstName;
		this.lastName = lastName;
		this.isAdmin = isAdmin;
	}
	public int getBankUser() {
		return bankUser;
	}
	public void setBankUser(int bankUser) {
		this.bankUser = bankUser;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
	
}
