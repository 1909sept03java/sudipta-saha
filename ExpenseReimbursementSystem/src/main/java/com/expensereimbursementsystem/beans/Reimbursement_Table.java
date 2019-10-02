package com.expensereimbursementsystem.beans;

import java.time.LocalDate;

public class Reimbursement_Table {
	private int reimbursement_id;
	private String details;
	private double balance;
	private int employee_id;
	private String status;
	private LocalDate s_date;
	public Reimbursement_Table() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reimbursement_Table(int reimbursement_id, String details, double balance, int employee_id, String status,
			LocalDate s_date) {
		super();
		this.reimbursement_id = reimbursement_id;
		this.details = details;
		this.balance = balance;
		this.employee_id = employee_id;
		this.status = status;
		this.s_date = s_date;
	}
	public int getReimbursement_id() {
		return reimbursement_id;
	}
	public void setReimbursement_id(int reimbursement_id) {
		this.reimbursement_id = reimbursement_id;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDate getS_date() {
		return s_date;
	}
	public void setS_date(LocalDate s_date) {
		this.s_date = s_date;
	}
	@Override
	public String toString() {
		return "Reimbursement_Table [reimbursement_id=" + reimbursement_id + ", details=" + details + ", balance="
				+ balance + ", employee_id=" + employee_id + ", status=" + status + ", s_date=" + s_date + "]";
	}

	
}
