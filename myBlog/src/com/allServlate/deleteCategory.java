package com.allServlate;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.categoryCls;

/**
 * Servlet implementation class deleteCategory
 */
@WebServlet("/deleteCategory")
public class deleteCategory extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");	
		HttpSession session = request.getSession(true);
		
		categoryCls categoryObj = new categoryCls();
        categoryObj.deleteCategory(id);
        session.setAttribute("deleteSuccessMsg", "Successfully delete category.");

		
		response.sendRedirect("admin/Category/index.jsp");
	}
}
