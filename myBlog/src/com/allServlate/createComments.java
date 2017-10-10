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
import com.dao.commentsCls;

/**
 * Servlet implementation class createComments
 */
@WebServlet("/createComments")
public class createComments extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		String post_id = request.getParameter("post_id");		
		String email = request.getParameter("email");
		String comment = request.getParameter("comment");

		// System.out.println(post_id+"/ "+email+"/ "+comment);
		
		if(post_id.equals("") || email.equals("") || comment.equals("")){
			session.setAttribute("storeErrorMsg", "requirement field is empty..!");
			response.sendRedirect("singlePostView.jsp?id="+post_id);
			return;
		}else{
			 LinkedHashMap hashData = new LinkedHashMap();
		    	hashData.put("post_id", post_id);
		    	hashData.put("email", email);
		    	hashData.put("comment", comment);
		    	
		    	commentsCls commentObj = new commentsCls();
		    	commentObj.prepateData(hashData);
		    	commentObj.store();
			
			session.setAttribute("storeSuccessMsg", "Successfully add your comment...!");
			response.sendRedirect("singlePostView.jsp?id="+post_id);
		}
		
	

	
	}

}
