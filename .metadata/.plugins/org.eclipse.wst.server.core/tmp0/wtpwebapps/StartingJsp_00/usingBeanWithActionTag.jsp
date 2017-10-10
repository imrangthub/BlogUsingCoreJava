<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>usingJavaBeanWithJavaActionTag</title>
</head>
<body>
<h4 align="center"> Using java Bean with java Action Tag " jsp:getProperty "</h4>
<hr>

<!-- Creating Object -->
 <jsp:useBean id="messageObj" class="usebean.MessageBean" scope="request"></jsp:useBean> 
 
<!-- Get Property woy One -->
 <jsp:getProperty property="message" name="messageObj"></jsp:getProperty>
 <!-- Get Property woy two --> <br/>Another Way<br/>
 <%= messageObj.getMessage() %>
 <br>
 
 After Set Property
 <br/>
 
 <!-- Set Property -->
  <jsp:setProperty property="message" name="messageObj" value="This is new Message"></jsp:setProperty>
   <jsp:getProperty property="message" name="messageObj"/>
   <br>
   <!-- Way tow -->
   
   <% messageObj.setMessage("this is new Msg Using Script tag"); %>
    <%= messageObj.getMessage() %>
 

</body>
</html>