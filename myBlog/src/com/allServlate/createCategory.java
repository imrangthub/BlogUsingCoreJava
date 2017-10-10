package com.allServlate;

import java.io.IOException;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.categoryCls;

/**
 * Servlet implementation class createCategory
 */
@WebServlet("/createCategory")
public class createCategory extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		HttpSession session = request.getSession(true);
		String categoryTitle = request.getParameter("categoryTitle");

		if(categoryTitle.equals("")){
			 session.setAttribute("storeErrorMsg", "Category adding failed..!");
      	     response.sendRedirect("admin/Category/index.jsp");
      	     return;
		}else{
			    LinkedHashMap hashData = new LinkedHashMap();
		    	hashData.put("categoryTitle", categoryTitle);
		    	
		    	categoryCls categoryObj = new categoryCls();
		    	categoryObj.prepareData(hashData);
		        categoryObj.store();
		           session.setAttribute("storeSuccessMsg", "Seccessfully add your category..!");
		           response.sendRedirect("admin/Category/index.jsp");
		}
		   
	   
	
		
	}

}
