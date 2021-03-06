package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

import org.apache.commons.fileupload.FileItem;

import com.Models.CategoryModel;
import com.Models.PostsModel;

public class categoryCls {
	
	private String id=null;
	private String categoryTitle = null;

	
	private Connection conn = null;
	private Statement stmt = null;
	
	
	
	public categoryCls(){
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
		if(dataMap.containsKey("categoryTitle")){
			this.categoryTitle = (String)dataMap.get("categoryTitle");
		}
	}
	
	
	
	public void store(){
		
		try {
			this.stmt=this.conn.createStatement();
			String storeQuery = "INSERT INTO category (category_title) values('"+this.categoryTitle+"')";
		    this.stmt.executeUpdate(storeQuery);
					    
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			System.out.println("Insertion failed..!!!!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public List<CategoryModel> index(){
		List<CategoryModel> categoryModelList = new ArrayList<CategoryModel>();
		
		String getAllDataQuery = "SELECT * FROM `category` ORDER BY ID"; //  LIMIT " + 1 + ","+ 2
		try {
			this.stmt = this.conn.createStatement();
			ResultSet tempResult = stmt.executeQuery(getAllDataQuery);
			while(tempResult.next()){
			    CategoryModel categoryModObj = new CategoryModel();
			    
			    categoryModObj.setId(tempResult.getString("id"));
			    categoryModObj.setCategory_title(tempResult.getString("category_title"));
			    categoryModObj.setCreate_at(tempResult.getTimestamp("created_at"));
			    categoryModObj.setModify_at(tempResult.getTimestamp("modify_at"));
			    categoryModelList.add(categoryModObj);
			    
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categoryModelList;		
	}
	
	public List<CategoryModel> singleShow(int id){
		List<CategoryModel> CategoryModelList = new ArrayList<CategoryModel>();
		
		String getSingleDataQuery = "SELECT * FROM `category` WHERE `category`.`id`= '"+id+"'";
		
		try {
			this.stmt = this.conn.createStatement();
			ResultSet tempResult = stmt.executeQuery(getSingleDataQuery);
			while(tempResult.next()){
				CategoryModel categoryModelObj = new CategoryModel();
				categoryModelObj.setId(tempResult.getString("id"));
				categoryModelObj.setCategory_title(tempResult.getString("category_title"));
				categoryModelObj.setCreate_at(tempResult.getTimestamp("created_at"));
				categoryModelObj.setModify_at(tempResult.getTimestamp("modify_at"));
				
				CategoryModelList.add(categoryModelObj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CategoryModelList;
		
	}
	
	
	public void update(){
		
		try {
			this.stmt=this.conn.createStatement();
			String updateQuery = "UPDATE `blog`.`category` SET `category_title`= '"+this.categoryTitle+"'  WHERE `id` = '"+this.id+"'";
		    this.stmt.executeUpdate(updateQuery);
					    
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			System.out.println("Insertion failed..!!!!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
public void deleteCategory(String Id){
	
	String deletePostQuery ="DELETE FROM `blog`.`category` WHERE `id`='"+Id+"'";
		try {
		this.stmt = this.conn.createStatement();
		stmt.executeUpdate(deletePostQuery);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}	
	
	
	
	
	
	
	

}
