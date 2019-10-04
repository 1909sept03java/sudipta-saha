package com.expensereimbursementsystem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.expensereimbursementsystem.service.EmployeeService;

@WebServlet("/update")
public class UpdateInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */  
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("Update.html").forward(req, resp);
	}
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		int employee_id;
		String firstName;
		String lastName;
		try {
			firstName = req.getParameter("first_name");
			lastName = req.getParameter("last_name");
			employee_id = Integer.parseInt(session.getAttribute("employee_id").toString());
			
			EmployeeService service = new EmployeeService();
			service.updateInfo(employee_id, firstName, lastName);
			resp.sendRedirect("update");
		}catch(Exception e) {
			e.printStackTrace();
			resp.getWriter().write("{\"session\":null}");
		}
		
	}

} 
 