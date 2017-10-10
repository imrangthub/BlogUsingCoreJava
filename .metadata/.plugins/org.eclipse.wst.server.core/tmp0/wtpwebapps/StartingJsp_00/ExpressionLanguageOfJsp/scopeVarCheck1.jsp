<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Scope Var | 1</title>
</head>
<body>
<h4>Check Scope variable</h4>
<hr/>
<h4>Check Style 01</h4>
<ul>
<li><b>For request Attributes: </b> ${ att1 } </li>
<li><b>For Session Attributes: </b> ${ att2 } </li>
<li><b>for ServalteContext Attributes: </b> ${ att3 } </li>

<li><b>for same name, Now check what is able: </b> ${ same } </li> <!-- Go to implicitObjectOrBiltinObj.jsp for check -->
</ul>
<hr/>

<h4>Check Style 02</h4>
<%

String att2 = (String) session.getAttribute("att2");

%>
<ul>

<li><b>For Session Attributes: </b> <%= att2 %></li>

</ul>


</body>
</html>