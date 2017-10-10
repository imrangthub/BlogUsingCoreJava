package com.dao;

import java.io.File;
import java.io.NotActiveException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

import com.Models.PostsModel;

import org.apache.commons.fileupload.FileItem;



public class postsCls {
	private String id=null;
	private String postTitle = null;
	private String postBody = null;
	private String categorys=null;
	private String postImage = null;
	private String oldImage = null;
	private String imageUniqueName = null;
	private FileItem fileItem = null;
	
	private Connection conn = null;
	private Statement stmt = null;
	
	
	
	public postsCls(){
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://localhost:3306/blog";
		final String USER = "root";
		final String PASSWORD = "admin";
		
		try {
			Class.forName(JDBC_DRIVER);
			this.conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void prepareData(LinkedHashMap dataMap){
		if(dataMap.containsKey("id")){
			this.id = (String)dataMap.get("id");			
		}
		if(dataMap.containsKey("postTitle")){
			this.postTitle = (String)dataMap.get("postTitle");
		}
		if(dataMap.containsKey("postBody")){
			this.postBody = (String)dataMap.get("postBody");
		}
		if(dataMap.containsKey("categorys")){
			this.categorys = (String)dataMap.get("categorys");
		}
		if(dataMap.containsKey("fileItem")){
			this.fileItem = (FileItem)dataMap.get("fileItem");
		}
		if(dataMap.containsKey("currentPcostImage")){
			this.oldImage = (String)dataMap.get("currentPcostImage");
		}
		if(dataMap.containsKey("postImage")){
			this.postImage = (String)dataMap.get("postImage");								
		}
		if(this.postImage.equals("") || this.postImage == null){
		}else{
			 Random generator = new Random();
	         int r = Math.abs(generator.nextInt());
	         this.imageUniqueName = r+"_"+(String)this.postImage;
		}

	}
	
	public void store(){
		if(this.imageUniqueName == null){
			
			System.out.println(this.postTitle+" "+this.postBody);
			try {
				this.stmt=this.conn.createStatement();
				String storeQuery = "INSERT INTO blog_post (post_title, post_body, post_image, post_category) values('"+this.postTitle+"','"+this.postBody+"','"+this.imageUniqueName+"','"+this.categorys+"')";
			    this.stmt.executeUpdate(storeQuery);
						    
			} catch (SQLException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				System.out.println("Insertion failed..!!!!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}else{
					
			System.out.println(this.postTitle+" "+this.postBody+" "+this.imageUniqueName);
			try {
				this.stmt=this.conn.createStatement();
				String storeQuery = "INSERT INTO blog_post (post_title, post_body, post_image, post_category) values('"+this.postTitle+"','"+this.postBody+"','"+this.imageUniqueName+"','"+this.categorys+"')";
			   this.stmt.executeUpdate(storeQuery);
			    
			    File savedFile = new File("D:/JAVA/BlogUsingCoreJava/myBlog/WebContent/imgFolder/"+this.imageUniqueName);            
	            this.fileItem.write(savedFile);
			    
			} catch (SQLException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				System.out.println("Insertion failed..!!!!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}
	
	public List<PostsModel> index(){
		List<PostsModel> postModelList = new ArrayList<PostsModel>();
		
		String getAllDataQuery = "SELECT * FROM `blog_post` ORDER BY ID"; //  LIMIT " + 1 + ","+ 2
		try {
			this.stmt = this.conn.createStatement();
			ResultSet tempResult = stmt.executeQuery(getAllDataQuery);
			while(tempResult.next()){
				PostsModel postModelObj = new PostsModel();
				postModelObj.setId(tempResult.getString("id"));
				postModelObj.setPostTitle(tempResult.getString("post_title"));
				postModelObj.setPostBody(tempResult.getString("post_body"));
				postModelObj.setCategory(tempResult.getString("post_category"));
				postModelObj.setPostImage(tempResult.getString("post_image"));
				
				postModelList.add(postModelObj);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return postModelList;		
	}
	
	public List<PostsModel> singleShow(int id){
		List<PostsModel> PostModelList = new ArrayList<PostsModel>();
		
		String getSingleDataQuery = "SELECT * FROM `blog_post` WHERE `blog_post`.`id`= '"+id+"'";
		
		try {
			this.stmt = this.conn.createStatement();
			ResultSet tempResult = stmt.executeQuery(getSingleDataQuery);
			while(tempResult.next()){
				PostsModel postModelObj = new PostsModel();
				postModelObj.setId(tempResult.getString("id"));
				postModelObj.setPostTitle(tempResult.getString("post_title"));
				postModelObj.setPostBody(tempResult.getString("post_body"));
				postModelObj.setCategory(tempResult.getString("post_category"));
				postModelObj.setPostImage(tempResult.getString("post_image"));
				postModelObj.setCreate_at(tempResult.getTimestamp("created_at"));
				postModelObj.setModify_at(tempResult.getTimestamp("modify_at"));
				
				PostModelList.add(postModelObj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return PostModelList;
		
	}
	
	public void update(){
		if(this.imageUniqueName == null){
			
			System.out.println(this.postTitle+" "+this.postBody+" "+this.id);
			try {
				
				stmt=this.conn.createStatement();
				String updateQuery = "UPDATE `blog`.`blog_post` SET `post_title`= '"+this.postTitle+"' , `post_body`= '"+this.postBody+"', `post_category`= '"+this.categorys+"' WHERE `id` = '"+this.id+"'";
				this.stmt.executeUpdate(updateQuery);
			    		    
			} catch (SQLException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				System.out.println("Insertion failed..!!!!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}else{

	//		System.out.println(this.postTitle+" "+this.postBody+" "+this.imageUniqueName+" "+this.id);
			try {
				
				 File ImgFile = new File("D:/JAVA/BlogUsingCoreJava/myBlog/WebContent/imgFolder/"+this.oldImage);
				 ImgFile.delete();
				
				stmt=this.conn.createStatement();
				String updateQuery = "UPDATE `blog`.`blog_post` SET `post_title`= '"+this.postTitle+"' , `post_body`= '"+this.postBody+"', `post_image`= '"+this.imageUniqueName+"', `post_category`= '"+this.categorys+"' WHERE `id` = '"+this.id+"'";
				this.stmt.executeUpdate(updateQuery);
			    
			    File savedFile = new File("D:/JAVA/BlogUsingCoreJava/myBlog/WebContent/imgFolder/"+this.imageUniqueName);            
	            this.fileItem.write(savedFile);
			    
			} catch (SQLException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				System.out.println("Insertion failed..!!!!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}
	
	public void deletePost(int deletePostId, String deletePostImageName){
		
		if(deletePostImageName.equals("null")){
//			System.out.println("Empty Image");
//			System.out.println(deletePostId);
			
     		String deletePostQuery ="DELETE FROM `blog`.`blog_post` WHERE `id`='"+deletePostId+"'";
     		try {
				this.stmt = this.conn.createStatement();
				stmt.executeUpdate(deletePostQuery);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else{
//			System.out.println(deletePostImageName);
//			System.out.println(deletePostId);
			
			 File ImgFile = new File("D:/JAVA/BlogUsingCoreJava/myBlog/WebContent/imgFolder/"+deletePostImageName);
			 ImgFile.delete();
			 
			String deletePostQuery = "DELETE FROM `blog`.`blog_post` WHERE `id`='"+deletePostId+"'";
     		try {
				this.stmt = this.conn.createStatement();
				stmt.executeUpdate(deletePostQuery);
			} catch (SQLException e) {
				System.out.println("Query Error");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
		
	}
	

	
	
	
	
	
	
	
	

}
