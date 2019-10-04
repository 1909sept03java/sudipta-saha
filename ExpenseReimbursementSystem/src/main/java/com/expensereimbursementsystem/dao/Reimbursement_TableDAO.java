package com.expensereimbursementsystem.dao;

import java.util.List;

import com.expensereimbursementsystem.beans.Reimbursement_Table;

public interface Reimbursement_TableDAO {
	public List<Reimbursement_Table> getPersonalRemList(int employee_id);
	public boolean newTicket(int employee_id, String details, double balance);
	public boolean acceptTicket(int reimbursement_id);
	public boolean rejectTicket(int reimbursement_id);
	
}
