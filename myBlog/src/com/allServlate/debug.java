package com.allServlate;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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
 * Servlet implementation class debug
 */
@MultipartConfig

@WebServlet("/debug")
public class debug extends HttpServlet {
	
	String postTitle, postBody, postImage;
	FileItem imageItem; boolean fileExtCheck;
	List<String>  postCategory = new ArrayList<String>();
	String allCategory="";
	String catcat="", finalCategory="";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if(isMultipart){
			
			FileItemFactory factory = new DiskFileItemFactory();
	        ServletFileUpload upload = new ServletFileUpload(factory);
	        
	        List formUploadeItems = null;
	         
	         try {
	        	 formUploadeItems = upload.parseRequest(request);	        	 
             System.out.println("Uploade items------------: " + formUploadeItems);
	             
	            } catch (FileUploadException e) {
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

	        		    
	        		    	this.catcat += fieldValue+",";
	       
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
	        
	           if(((this.postTitle.equals("") || null == this.postTitle)) || (null == this.postBody) || (this.postBody.equals(""))){
//	        	   System.out.println("Not ok");
	        	   session.setAttribute("storeErrorMsg", "Require field is empty..!");
	        	   response.sendRedirect("admin/create.jsp");
	        	   return;
	           }else{
//	        	  System.out.println(this.postTitle);
//	 	          System.out.println(this.postBody);
//	 	          System.out.println(this.postImage);
//	 	          System.out.println(this.imageItem);
	        	   if(this.postImage.equals("") || this.postImage == null){
	        		
	        	   }else{
	        		   String [] fileExt = {".jpg", ".png", ".jpeg"};
	        		   int IndexOf = this.postImage.indexOf(".");
	        		   String currentImgExt = this.postImage.substring(IndexOf);
//	        		   System.out.println(currentImgExt);
	        		   this.fileExtCheck = Arrays.asList(fileExt).contains(currentImgExt);
	        		   if(this.fileExtCheck == false){
	        			 
	    	        	   System.out.println("storeErrorMsg Invalid file formate..!");
	    	        	  return;
	        			   
	        		   }
	        	   }
	   
       		    	LinkedHashMap hashData = new LinkedHashMap();
       		    	hashData.put("postTitle", this.postTitle);
       		    	hashData.put("postBody", this.postBody);
       		    	hashData.put("postImage", this.postImage);
       		    	hashData.put("fileItem", this.imageItem);
       		  
	           }    
			
	          
	        
	          
	           System.out.println("No"+this.catcat);
	           this.catcat="";
	        
		}else{
			System.out.println("Not a file type");
		} // end isMultipart if
		
//		 String[] hobbyValues = request.getParameterValues("category");
		
	
		
		
		
		
	}

}