package com.allServlate;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class editPost
 */
@WebServlet("/editPost")
public class editPost extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get Edit");
		String id = request.getParameter("id");
//		System.out.println(id);
		
		response.sendRedirect("admin/edit.jsp?id="+id);
	}

}
