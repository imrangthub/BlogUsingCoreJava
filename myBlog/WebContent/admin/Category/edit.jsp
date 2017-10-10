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

<title>Edit | Category</title>
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
String msgErrors = (String) session.getAttribute("updateErrorMsg");


if(!session.isNew() && msgErrors != null){
	 out.print(msgErrors);
    session.setAttribute("updateErrorMsg"," "); 
}

	
%>
</h4>
</div>

<%
int postId = Integer.parseInt(request.getParameter("id"));
 if(postId != 0){
	 categoryCls categoryClsObj = new categoryCls();
List<CategoryModel> dataforEdit = categoryClsObj.singleShow(postId);
  for(CategoryModel editPost : dataforEdit){
%>
 <div class="row"> <!-- Start Blog body post row -->
 <div class="col-md-12">
 <hr>
    <div class="col-md-4 col-md-offset-4">
    <form action="../../updateCategory" method="POST">
    <div class="form-group">  
     <label class="control-label">Category name:</label>
     <input type="text" id="title" name="categoryTitle" value="<% out.print(editPost.getCategory_title()); %>" class="form-control">    
    </div> 
    <input type="hidden" name="categoryId" value="<% out.print(editPost.getId());  %>"/>
    <input type="submit" value="Update Category" class="btn btn-success btn-lg btn-block">
    
   </form>
 
 </div> 
 </div>
 </div>
 </div> <!-- End Blog body row --> 
   <%}
  }%>      
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