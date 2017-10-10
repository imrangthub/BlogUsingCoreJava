<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration</title>
</head>
<body>
<h4 align="center">Registration form</h4>
<hr>

<form action="reg_create.jsp" method="POST">
<fieldset>
<legend>add new User</legend>
<table>
<tr>
<th>User name:</th>
<td><input type="text" name="userName" /></td>
</tr>
<tr>
<th>Email:</th>
<td><input type="text" name="email" /></td>
</tr>
<tr>
<th>Password:</th>
<td><input type="password" name="password"/></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="SUBMIT"/></td>
</tr>

</table>

</fieldset>

</form>

</body>
</html>