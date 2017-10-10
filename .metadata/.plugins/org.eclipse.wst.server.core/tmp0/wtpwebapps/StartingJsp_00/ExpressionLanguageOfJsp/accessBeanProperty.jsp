<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>accessBean Property</title>
</head>
<body>
<h2>access Bean Property</h2>
<hr/>

<ul>
 <li>
 <b>Employee Name : </b> ${Emp.name.empName }
 </li>

 <li>
 <b>Company Name : </b> ${Emp.company.companyName }
 </li>
 
  <li>
 <b>Company Type : </b> ${Emp.company.companyType }
 </li>

</ul>



</body>
</html>