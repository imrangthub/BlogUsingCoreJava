package com.allServlate;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Models.PostsModel;
import com.dao.postsCls;


/**
 * Servlet implementation class deletePost
 */
@WebServlet("/deletePost")
public class deletePost extends HttpServlet {
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get delete");
		String deletedPostImage = null;
		int id =Integer.parseInt(request.getParameter("id"));
		postsCls postClsObj = new postsCls();

		List<PostsModel> dataforSingleShow = postClsObj.singleShow(id);

		 for(PostsModel singlePost  : dataforSingleShow){
			deletedPostImage = singlePost.getPostImage();			
		 }
		postClsObj.deletePost(id, deletedPostImage);
		response.sendRedirect("admin/dashboard.jsp");
	}

}
