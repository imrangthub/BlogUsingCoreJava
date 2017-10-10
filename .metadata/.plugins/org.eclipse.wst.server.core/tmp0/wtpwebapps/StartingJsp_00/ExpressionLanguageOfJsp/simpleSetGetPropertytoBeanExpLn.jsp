<jsp:useBean id="empObj" class="ExpressionLanBean.simpleSetGetPropertytoBean" scope="request"></jsp:useBean>
<jsp:setProperty property="*" name="empObj"></jsp:setProperty>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>set&get Bean</title>
</head>
<body>
<h4 align="center">Simple set and get Property using java Bean</h4>
<hr/>

<ul>
<li><b>Employee Name: </b>${ empObj.name }  </li>
<li><b>Employee Age: </b> ${ empObj.age }  </li>
</ul>

<form action="" method="post">
Employee Name: <input type="text" name="name"/><br/>
Employee Age: <input type="text" name="age" /><br/>
<input type="submit" />

</form>
</body>
</html>