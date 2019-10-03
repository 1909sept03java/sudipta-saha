package com.expensereimbursementsystem.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.expensereimbursementsystem.beans.Employee_Table;
import com.expensereimbursementsystem.beans.Reimbursement_Table;
import com.expensereimbursementsystem.service.EmployeeService;
import com.expensereimbursementsystem.service.PersonalReimbursementService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@WebServlet("/empundman")
public class EmployeeUnderManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ObjectMapper om;
	private PersonalReimbursementService prs;
	private EmployeeService eservice;
    public EmployeeUnderManagerServlet() {
    	prs = new PersonalReimbursementService();
    	eservice = new EmployeeService();
		om = new ObjectMapper();
		om.registerModule(new JavaTimeModule());
		om.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		try {
			int employee_id = Integer.parseInt(session.getAttribute("employee_id").toString());
			List<Employee_Table> tables = new ArrayList<Employee_Table>();
			tables = eservice.employeeUnderManager(employee_id);
			//System.out.println(tables);
			resp.getWriter().write((new ObjectMapper()).writeValueAsString(tables));
			
		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().write("{\"user\":null}");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
