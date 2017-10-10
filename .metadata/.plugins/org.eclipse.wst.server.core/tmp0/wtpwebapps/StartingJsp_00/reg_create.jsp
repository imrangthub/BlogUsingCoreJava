<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 
 
 <%
 
 String userName = request.getParameter("userName");
 String email = request.getParameter("email");
 String password = request.getParameter("password");

 
 if(userName.equals("") || userName == null || email.equals("") || email == null || password.equals("") || password == null){
	 response.sendRedirect("registration.jsp");
 }else{
	 Class.forName("com.mysql.jdbc.Driver");
	 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/core_java","root","admin");
	 Statement stmt = conn.createStatement();
	 
	    stmt.executeUpdate("INSERT INTO `core_java`.`jsp_crud` (`user_name`, `user_email`,`password`, `created_at`) values('"+userName+"','"+email+"','"+password+"', CURDATE())");
	   response.sendRedirect("regSuccess.jsp");
 }
  
 
 
 
 
 
 %>
