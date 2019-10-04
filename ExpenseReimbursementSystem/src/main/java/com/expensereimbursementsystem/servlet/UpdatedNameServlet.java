package com.expensereimbursementsystem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.expensereimbursementsystem.beans.Employee_Table;
import com.expensereimbursementsystem.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/uname")
public class UpdatedNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatedNameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		try {
			// grab session attributes and place them within a user object
			int employee_id = Integer.parseInt(session.getAttribute("employee_id").toString());
			EmployeeService service = new EmployeeService();
			Employee_Table table = service.updatedName(employee_id);
			// use ObjectMapper (part of the Jackson api) to convert Java object to JSON
			// representation
			//System.out.println(table);
			resp.getWriter().write((new ObjectMapper()).writeValueAsString(table));
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
