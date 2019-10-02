package com.expensereimbursementsystem.service;

import java.util.List;

import com.expensereimbursementsystem.beans.Reimbursement_Table;
import com.expensereimbursementsystem.dao.Reimbursement_TableDAO;
import com.expensereimbursementsystem.dao.Reimbursement_TableDAOImpl;

public class PersonalReimbursementService {
	private Reimbursement_TableDAO reimbursement_TableDAO = new Reimbursement_TableDAOImpl();
	
	public PersonalReimbursementService () {
		
	}
	
	public List<Reimbursement_Table> getPersonalRemList(int employee_id){
		return reimbursement_TableDAO.getPersonalRemList(employee_id);
	}
	public boolean newTicket(int employee_id, String details, double balance) {
		return reimbursement_TableDAO.newTicket(employee_id, details, balance);
	}

}
