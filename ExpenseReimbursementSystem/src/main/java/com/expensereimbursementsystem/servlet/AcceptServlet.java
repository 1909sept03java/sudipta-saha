package com.expensereimbursementsystem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.expensereimbursementsystem.service.PersonalReimbursementService;

@WebServlet("/accept")
public class AcceptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public AcceptServlet() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		//System.out.println(session.getId());
		try {
			PersonalReimbursementService prs = new PersonalReimbursementService();
			// grab session attributes and place them within a user object
			if(Integer.parseInt(session.getAttribute("isAdmin").toString()) == 1) {
			int reimbursement_id = Integer.parseInt(req.getParameter("reimbursement_id").toString());
			//Integer.parseInt(session.getAttribute("employee_id").toString());
			prs.acceptTicket(reimbursement_id);
			resp.sendRedirect("Management.html");
			}else resp.sendRedirect("profile");
			//req.getRequestDispatcher("Profile.html").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().write("{\"session\":null}");
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
