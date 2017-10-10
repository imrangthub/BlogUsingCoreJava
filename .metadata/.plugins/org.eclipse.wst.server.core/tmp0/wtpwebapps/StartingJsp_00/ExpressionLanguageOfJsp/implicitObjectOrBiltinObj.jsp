<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ImplicitObj</title>
</head>
<body>

<h4>Implicit Object Of Expression Language.</h4>

 <ul>
 <li><b>Test Request Parameter as [test]: </b> ${param.test }</li>
 <li><b>User-Agent Header: </b> ${ header["User-Agent"] }</li>
  <li><b>Server name: </b> ${ pageContext.servletContext.serverInfo }</li>
  
  <!-- This is Checking Scope variable -->
  <li><b>for same name, Now check what is able: </b> ${ same } </li>
  
  <li><b>For Session Attributes: </b> ${ att2 } </li>
  <li><b>for ServalteContext Attributes: </b> ${ att3 } </li>
  
  <li><b>for request Attributes: </b> ${ att1 } </li> <!-- scope failed for access this variable -->
  
  
 </ul>

</body>
</html>