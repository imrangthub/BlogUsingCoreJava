<%@page import="java.nio.channels.SeekableByteChannel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*"%>
<%

String email = request.getParameter("email");
String password = request.getParameter("password");

if(email.equals("") || email == null || password.equals("") || password == null){
	 response.sendRedirect("login.jsp");
}else{
	 Class.forName("com.mysql.jdbc.Driver");
	 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/core_java","root","admin");
	 Statement stmt = conn.createStatement();
	 
	    ResultSet rs = stmt.executeQuery("SELECT * FROM `core_java`.`jsp_crud` WHERE `jsp_crud`.`user_email`= '"+email+"'");
	   if(rs.next()){
		  String user_Name =  rs.getString("user_name");
		  String user_password = rs.getString("password");
		   if(user_password.equals(password)){
			   session.setAttribute("userName", user_Name); 
			   response.sendRedirect("adminPanel.jsp");
			   return;
		   }else{
			   response.sendRedirect("login.jsp");
			   return;
		   }
		   
	   }
	   response.sendRedirect("login.jsp");
	    
}

%>