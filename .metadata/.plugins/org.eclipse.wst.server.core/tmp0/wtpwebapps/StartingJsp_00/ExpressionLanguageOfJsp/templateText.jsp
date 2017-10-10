<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Template Text</title>
</head>
<body>



<h1  style="background-color:${(empty param.userName)? "red;" : "skyblue;"} ">Hello : ${param['userName'] }</h1>

<h2>${!empty param.userName}</h2>

<form action="templateText.jsp" method="post">

<input type="text" name="userName"/>
<input type="submit"/>

</form>




</body>
</html>