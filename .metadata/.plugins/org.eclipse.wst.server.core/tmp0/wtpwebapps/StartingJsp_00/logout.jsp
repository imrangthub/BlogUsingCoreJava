<%
session.setAttribute("userName", null);
session.invalidate();
response.sendRedirect("login.jsp");

%>