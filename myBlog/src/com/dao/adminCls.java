package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.Models.adminModel;




public class adminCls {
	
	private String adminId="";
	private String email = "";
	private String password = "";
	
	
	private Connection conn = null;
	private Statement stmt = null;
	
public adminCls(){
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
	}                                       // create Database Connection using Constructor 
	
	
	public String AdminLogin(String email, String pass){
	
		
		String getAdminInfoQuery = "SELECT * FROM blog.administrator";
		
		try {
			this.stmt = this.conn.createStatement();
			ResultSet tempResult = stmt.executeQuery(getAdminInfoQuery);
			
			while(tempResult.next()){
				this.adminId = tempResult.getString("id");
				this.email = tempResult.getString("email");
				this.password = tempResult.getString("password");
				
			}
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			if(this.email.equals(email) && this.password.equals(pass)){
				return this.adminId;	
			}else{
				return null;
		    }	

	}
	
	public List<adminModel>getAdminInfo(String adminID){
	
		List<adminModel> adminModelList = new ArrayList<adminModel>();
		String getAdminInfoQuery =  "SELECT * FROM `administrator` WHERE `administrator`.`id`= '"+adminID+"'";
		
		try {
			this.stmt = this.conn.createStatement();
			ResultSet tempResult = stmt.executeQuery(getAdminInfoQuery);
			
			while(tempResult.next()){
				adminModel adminModelObj = new adminModel();
				adminModelObj.setAdminId(tempResult.getString("id"));
				adminModelObj.setAdminName(tempResult.getString("name"));
				adminModelObj.setAdminEmail(tempResult.getString("email"));
				adminModelObj.setAdminPass(tempResult.getString("password"));
				adminModelObj.setCreated_at(tempResult.getTimestamp("created_at"));
				adminModelObj.setModify_at(tempResult.getTimestamp("modify_at"));
				
				adminModelList.add(adminModelObj);
			}
			
		} catch (SQLException e) {
			System.out.println("Data base Query failed.");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return adminModelList;
			
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
