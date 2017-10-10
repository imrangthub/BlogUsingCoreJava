<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.dao.adminCls"%>
<%@page import="com.dao.postsCls" %>
<%@page import="com.Models.adminModel"%>
<%@page import="com.Models.PostsModel" %>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.categoryCls" %>
<%@page import="com.Models.CategoryModel" %>

<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Post | Category</title>
<!-- Bootstrap -->
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <link href="../../css/style.css" rel="stylesheet">
</head>

<body>
<div class="main_container">
<%
String loginId = (String) session.getAttribute("loginID");
if(!session.isNew() && session.getAttribute("loginID") != null){
	adminCls adminClsObj = new adminCls();
	List<adminModel> selectedAdmin = adminClsObj.getAdminInfo(loginId);
	for(adminModel userInfo : selectedAdmin ){
%> 
<!-- Admin login Navbar -->
  
<!-- End Admin login Navbar -->
<nav class="navbar navbar-inverse navbar-default navbar-fixed-top">
  <div class="navbar-header">
            <a class="navbar-brand" href="about.jsp">Welcome : </a>
            <a class="navbar-brand" href="contact.jsp"><% out.print(userInfo.getAdminName()); %></a>              
    </div>
    
     <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="../dashboard.jsp">Dashboard</a></li>      
      </ul>
      
      <ul class="nav navbar-nav navbar-right">
        <li><a href="../../adminLogout?action=logout">LOGOUT</a></li>
      </ul>
    </div>
</nav>

<nav class="adminNav"></nav>


<%	
// session.setAttribute("loginID", null);
	}
}
%>

 <div class="container"> <!-- Start container -->
  <header class="header_area">
   <div class="row">
    <div class="col-md-12">
     <div class="logo">
      <h2>Welcome to Blog</h2>
      <p>This is a general blog web, anyway thank's for visiting our blog.</p>
     </div>
    </div>
   </div>
  </header> 
  <!-- Start Navigation bar -->
   <nav class="navigation">
            <div class="row">
                <div class="col-xs-12 col-md-11 col-md-offset-1">
                    <nav class="navbar navbar-default2">
                        <div class="container-fluid">
                            <!-- Brand and toggle get grouped for better mobile display -->
                            <div class="navbar-header">
                                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                                    <span class="sr-only">Toggle navigation</span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                </button>
                            </div>

                            <!-- Collect the nav links, forms, and other content for toggling -->
                            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                                <ul class="nav navbar-nav">
                                    <li><a href="../../index.jsp">Home</a></li>
                                    <li><a href="index.jsp">Manage category</a></li>
                                    <li><a href="../create.jsp">Create new post</a></li>
                                </ul>
                            </div><!-- /.navbar-collapse -->
                        </div><!-- /.container-fluid -->
                    </nav>
                </div>
            </div>
        </nav>
 <!-- End Navigation bar -->
 <!-- body contain section -->
  <section class="content_area">

<div class="row well">
<div class="col-md-6">
<h4>Add Category</h4>
</div>
<div class="col-md-6">
<h4  style="color:red">
<%
String msgError = (String) session.getAttribute("storeErrorMsg");

 if(!session.isNew() && msgError != null){
	 out.print(msgError);
     session.setAttribute("storeErrorMsg"," "); 
 }

	
%>
</h4>
<h4  style="color:green">
<%
String msgSeccess = (String) session.getAttribute("storeSuccessMsg");

 if(!session.isNew() && msgSeccess != null){
	 out.print(msgSeccess);
     session.setAttribute("storeSuccessMsg"," "); 
 }
 String updateSeccess = (String) session.getAttribute("updateSuccessMsg");

 if(!session.isNew() && updateSeccess != null){
	 out.print(updateSeccess);
     session.setAttribute("updateSuccessMsg"," "); 
 }
 
 String deleteSeccess = (String) session.getAttribute("deleteSuccessMsg");

 if(!session.isNew() && deleteSeccess != null){
	 out.print(deleteSeccess);
     session.setAttribute("deleteSuccessMsg"," "); 
 }

	
%>
</h4>
</div>

 <div class="row"> <!-- Start Blog body post row -->
 <div class="col-md-12">
 <hr>
    <div class="col-md-4 col-md-offset-4">
    <form action="../../createCategory" method="POST">
    <div class="form-group">  
     <label class="control-label">Category name:</label>
     <input type="text" id="title" name="categoryTitle" class="form-control">    
    </div> 
    
    <input type="submit" value="Save Category" class="btn btn-success btn-lg btn-block">
    
   </form>
 
 </div> 
 </div>
 </div>
 </div> <!-- End Blog body row --> 
 
 <div class="row well"> <!-- Start Blog body post row -->
 <div class="col-md-12">
 <h4>Current Category</h4>
 <hr>
  <table class="tableBasic">
 <thead>
 <tr>
 <th>#</th><th>Category Title</th><th>Create </th><th>Last Update</th><th>Manage</th>
 </tr>
 </thead>
  <tbody>
 <%
 categoryCls categoryClsObj = new categoryCls();
 
 List<CategoryModel> categoryList = new ArrayList<CategoryModel>();
 
 categoryList = categoryClsObj.index();
 for(CategoryModel singleCategory : categoryList){
	 
 %>

 <tr>
 <td><%out.print(singleCategory.getId()); %></td>
 <td> <%out.print(singleCategory.getCategory_title()); %></td>
 <td> <%out.print(singleCategory.getCreate_at()); %></td>
 <td><%
 if(singleCategory.getModify_at() == null ){
	out.print("Not yeat."); 
 }else{
	 out.print(singleCategory.getModify_at());
 }
 %></td>
 <td>
 <a href="../../editCategory?id=<% out.print(singleCategory.getId()); %>" class="btn btn-primary">EDIT CATEGORY</a> | 
 <a href="../../deleteCategory?id=<% out.print(singleCategory.getId()); %>" class="btn btn-danger">DELETE CATEGORY</a>
 </td>
 </tr>
 
 <% } %>
 
 </tbody>
 </table>
 </div>  
</div> <!-- End Blog body row -->
  
           
  </section>
       <!-- End body contain section -->
       
        <footer class="footer_area">
            <div class="row">
                <div class="col-xs-12">
                    <div class="copyright">
                        <p>&copy; Copyright Md Imran hossain.</p>
                    </div>
                </div>
            </div>
        </footer>
 
 </div>     <!-- End container -->
</div>
 <script src="../../js/bootstrap.min.js"></script>
 <script src="../../js/jquery.min.js"></script>
 
</body>
</html>