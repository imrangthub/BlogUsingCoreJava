<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>complex | Bean</title>
</head>
<body>
<h1 align="center">Complex Bean</h1>
<hr/>

<ul>
<li>
<b>Employee Name: </b> ${person.name }
</li>
<li>
<b>Employee Age: </b> ${person.age }
</li>

<li>
<b>Employee Address: </b> ${person.address.line1 }
</li>

<li>
<b>Employee City: </b> ${person["address"].town }
</li>

<li>
<b>Employee Country: </b> ${person["address"].country }
</li>

<li>
<b>Employee Phone country code: </b> ${person.address.phoneNumber[0].std }
</li>
<li>
<b>Employee Phone number: </b> ${person.address.phoneNumber[0].number }
</li>

</ul>

</body>
</html>