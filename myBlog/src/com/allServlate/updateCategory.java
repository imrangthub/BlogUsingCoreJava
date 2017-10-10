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
 * Servlet implementation class updateCategory
 */
@WebServlet("/updateCategory")
public class updateCategory extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		
		String categoryTitle = request.getParameter("categoryTitle");
		String categoryId = request.getParameter("categoryId");
              
		if(categoryTitle.equals("") || categoryTitle == null){
			
		   session.setAttribute("updateErrorMsg", "Require field is empty..!");
		   response.sendRedirect("admin/Category/edit.jsp?id="+categoryId);
       	   return;
		}else{
			
			    LinkedHashMap hashData = new LinkedHashMap();
		    	hashData.put("categoryTitle", categoryTitle);
		    	hashData.put("id", categoryId);
		    	
		    	categoryCls categoryObj = new categoryCls();
		    	categoryObj.prepareData(hashData);
		        categoryObj.update();
		   session.setAttribute("updateSuccessMsg", "Successfully update category item.");
		   response.sendRedirect("admin/Category/index.jsp");
		}
     
     
	}

}
