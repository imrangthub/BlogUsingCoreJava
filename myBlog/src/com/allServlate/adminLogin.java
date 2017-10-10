package com.allServlate;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.adminCls;

/**
 * Servlet implementation class adminLogin
 */
@WebServlet("/adminLogin")
public class adminLogin extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("Get me admin");
		HttpSession session = request.getSession(true);
		String adminEmail = request.getParameter("email");
		String adminPassword = request.getParameter("password");
		
//		System.out.println(adminEmail +" "+adminPassword);
		
		adminCls adminClsObj = new adminCls();
		String loginId = adminClsObj.AdminLogin(adminEmail, adminPassword);
		if(loginId != null){		
			 session.setAttribute("loginID", loginId);
			 response.sendRedirect("index.jsp");
		}else{
			response.sendRedirect("index.jsp");
		}
		
		
	}

}
