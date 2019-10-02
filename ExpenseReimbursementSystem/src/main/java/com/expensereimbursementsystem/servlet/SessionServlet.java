package com.expensereimbursementsystem.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.expensereimbursementsystem.beans.Employee_Table;
import com.fasterxml.jackson.databind.ObjectMapper;

// taking the place of a mapping within my web.xml - annotation-based config vs xml config
@WebServlet("/session")
public class SessionServlet extends HttpServlet {

	private static final long serialVersionUID = -1319793763433572026L;

	// return a JSON representation of the currently authenticated user for a
	// request's JSESSIONID
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// grab current session, if it exists, otherwise return null
		HttpSession session = req.getSession(false);
		try {
			// grab session attributes and place them within a user object
			int employee_id = Integer.parseInt(session.getAttribute("employee_id").toString());
			String firstName = session.getAttribute("firstName").toString();
			String lastName = session.getAttribute("lastName").toString();
			int isAdmin = Integer.parseInt(session.getAttribute("isAdmin").toString());
			int manager_id = Integer.parseInt(session.getAttribute("manager_id").toString());
			Employee_Table table = new Employee_Table(employee_id, firstName, lastName , isAdmin, manager_id);
			// use ObjectMapper (part of the Jackson api) to convert Java object to JSON
			// representation
			//System.out.println(table);
			resp.getWriter().write((new ObjectMapper()).writeValueAsString(table));
		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().write("{\"session\":null}");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
