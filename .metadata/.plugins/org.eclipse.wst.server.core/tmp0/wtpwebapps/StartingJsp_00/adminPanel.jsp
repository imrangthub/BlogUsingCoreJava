<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    if((session.getAttribute("userName") == null || (session.getAttribute("userName")=="") )){
    	 response.sendRedirect("login.jsp");
    }else{ %>
    	
   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dashboard</title>
</head>
<body>

Welcome to <%= session.getAttribute("userName") %><br/>

<a href="logout.jsp">Logout ? </a>



</body>
</html>

 <%} %>
 
 <!-- Stop browser caching -->
 <%
 
 response.setHeader("Pragma", "No-cache");
 response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
 response.setDateHeader("Expires", -1);
 %>