package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.Models.CommentsModel;

public class commentsCls {
	
	private String id = "";
	private String post_id="";
	private String email="";
	private String comment="";
	
	private Connection conn=null;
	private Statement stmt = null;
	
	public commentsCls(){
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
	
	public void prepateData(LinkedHashMap dataMap){
		if(dataMap.containsKey("id")){
			this.id = (String)dataMap.get("id");
		}
		if(dataMap.containsKey("post_id")){
			this.post_id = (String)dataMap.get("post_id");
		}
		if(dataMap.containsKey("email")){
			this.email = (String)dataMap.get("email");
		}
		if(dataMap.containsKey("comment")){
		    this.comment = (String)dataMap.get("comment");
		}
	}
	
	public void store(){
		try {
			this.stmt = this.conn.createStatement();
			String storeQuery = "INSERT INTO comments (post_id, email, comment) VALUES('"+this.post_id+"', '"+this.email+"', '"+this.comment+"')";
			this.stmt.executeUpdate(storeQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Insert comments failed......");
			e.printStackTrace();
		}
	}
	
	public List<CommentsModel> index( String post_id){
		this.post_id = post_id;
		List<CommentsModel> commentsModelList = new ArrayList<CommentsModel>();
		
		String getAllCommentsQuery = "SELECT * FROM `comments` WHERE `comments`.`post_id`= '"+this.post_id+"'";
		
		try {
			this.stmt = this.conn.createStatement();
			ResultSet tempResult = stmt.executeQuery(getAllCommentsQuery);
			
			while(tempResult.next()){
				CommentsModel commentsModObj = new CommentsModel();
				commentsModObj.setId(tempResult.getString("id"));
				commentsModObj.setPost_id(tempResult.getString("post_id"));
				commentsModObj.setEmail(tempResult.getString("email"));
				commentsModObj.setComment(tempResult.getString("comment"));
				commentsModObj.setCreate_at(tempResult.getTimestamp("created_at"));
				commentsModelList.add(commentsModObj);
			}
		} catch (SQLException e) {
			System.out.println("Query error");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(this.post_id);
		System.out.println(commentsModelList);
		return commentsModelList;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
