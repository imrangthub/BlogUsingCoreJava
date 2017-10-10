package com.allServlate;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class adminLogout
 */
@WebServlet("/adminLogout")
public class adminLogout extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
		System.out.println("Get met Logout");
		String action = request.getParameter("action");
   //  	System.out.println(action);
		if(action.equals("logout")){
	       session.setAttribute("loginID", null);
		}
	
		response.sendRedirect("index.jsp");
		
	}

}
