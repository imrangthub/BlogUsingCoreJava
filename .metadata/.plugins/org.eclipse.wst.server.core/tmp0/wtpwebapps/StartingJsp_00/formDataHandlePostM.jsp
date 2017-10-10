<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User form</title>
</head>
<body>
<h1 align="center">User form</h1>
<hr/>

<form action="handleFormData" method="POST">
<fieldset>
<legend>User Info:</legend>
<table>
<tr>
<th>User name:</th>
<td><input type="text" name="userName" /></td>
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