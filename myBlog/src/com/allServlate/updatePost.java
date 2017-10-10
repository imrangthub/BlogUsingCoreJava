package com.allServlate;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.dao.postsCls;

/**
 * Servlet implementation class updatePost
 */
@WebServlet("/updatePost")
public class updatePost extends HttpServlet {
	
	String postTitle, postBody, postImage, oldPostImage,currentPostId;
	FileItem imageItem; boolean fileExtCheck;
	String categorys="";
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Update Post");
		
HttpSession session = request.getSession(true);
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		
		if(isMultipart){
			
			FileItemFactory factory = new DiskFileItemFactory();
	        ServletFileUpload upload = new ServletFileUpload(factory);
	        
	        List formUploadeItems = null;
	        
	        try {
				formUploadeItems = upload.parseRequest(request);
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	        Iterator itr = formUploadeItems.iterator();
	          while(itr.hasNext()){
	        	  FileItem singleItem = (FileItem) itr.next();
//	        	  System.out.println(singleItem);
	        	   if(singleItem.isFormField()){
	        		   String fieldName = singleItem.getFieldName();
	        		   String fieldValue = singleItem.getString();
	        		    if(fieldName.equals("title")){
	        		    	this.postTitle = fieldValue;
	        		    }
	        		    if(fieldName.equals("body")){
	        		    	this.postBody = fieldValue;
	        		    }
	        		    if(fieldName.equals("category")){		        		    
	        		    	this.categorys += fieldValue+",";
	        		    }
	        		    if(fieldName.equals("currentImgName")){
	        		    	this.oldPostImage = fieldValue;
	        		    }
	        		    if(fieldName.equals("currentPostId")){
	        		    	this.currentPostId = fieldValue;
	        		    }
	        	   }else{
	        		   this.imageItem  = singleItem;
	        		   String fieldName = singleItem.getFieldName();
	        		   String fileName = singleItem.getName();	        		   
	        		    if(fieldName.equals("image")){
	        		    	this.postImage = fileName;
	        		    }
	        		   
	        	   }
	          } // End While
	          
	          if(((this.postTitle.equals("") || null == this.postTitle)) || (null == this.postBody) || (this.postBody.equals("")) || (null == this.categorys) || (this.categorys.equals(""))){
//	        	   System.out.println("Not ok");
	        	   session.setAttribute("storeErrorMsg", "Require field is empty..!");
	        	   response.sendRedirect("admin/create.jsp");
	        	   return;
	           }else{
	        	   
	        	   if(this.postImage.equals("") || this.postImage == null){
	        		
	        	   }else{
	        		   String [] fileExt = {".jpg", ".png", ".jpeg"};
	        		   int IndexOf = this.postImage.indexOf(".");
	        		   String currentImgExt = this.postImage.substring(IndexOf);
//	        		   System.out.println(currentImgExt);
	        		   this.fileExtCheck = Arrays.asList(fileExt).contains(currentImgExt);
	        		   if(this.fileExtCheck == false){
	        			   session.setAttribute("storeErrorMsg", "Invalid file formate..!");
	    	        	   response.sendRedirect("admin/create.jsp");
	    	        	  return;
	        			   
	        		   }
	        	   }
	   
      		    	LinkedHashMap hashData = new LinkedHashMap();
      		    	hashData.put("id", this.currentPostId);
      		    	hashData.put("postTitle", this.postTitle);
      		    	hashData.put("postBody", this.postBody);
      		    	hashData.put("fileItem", this.imageItem);
      		    	hashData.put("currentPcostImage", this.oldPostImage);
      		    	hashData.put("postImage", this.postImage);
      		    	hashData.put("categorys", this.categorys);
      		    
 //    		    	System.out.println(hashData);
      		    	postsCls postClsObj = new postsCls();
       		    	postClsObj.prepareData(hashData);
       		    	postClsObj.update();
       		    	this.categorys="";
       		
       		       session.setAttribute("storeSuccessMsg", "Seccessfully Update your post..!");
	        	   response.sendRedirect("admin/create.jsp");
      		    
	        	  
	           }
	
			
		} // First if file..

	}
}
