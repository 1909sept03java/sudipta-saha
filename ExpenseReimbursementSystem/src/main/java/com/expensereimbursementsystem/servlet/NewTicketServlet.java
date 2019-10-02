package com.expensereimbursementsystem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.expensereimbursementsystem.beans.Employee_Table;
import com.expensereimbursementsystem.service.PersonalReimbursementService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class NewTicketServlet
 */
@WebServlet("/newticket")
public class NewTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public NewTicketServlet() {
        super();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// grab current session, if it exists, otherwise return null
		//HttpSession session = req.getSession(false);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		//System.out.println(session.getId());
		try {
			PersonalReimbursementService prs = new PersonalReimbursementService();
			// grab session attributes and place them within a user object
			int employee_id = Integer.parseInt(session.getAttribute("employee_id").toString());
			String details = req.getParameter("details").toString();
			double balance = Double.parseDouble(req.getParameter("balance").toString());
			prs.newTicket(employee_id, details, balance);
			
			resp.sendRedirect("profile");
			//req.getRequestDispatcher("Profile.html").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().write("{\"session\":null}");
		}
	}
}
