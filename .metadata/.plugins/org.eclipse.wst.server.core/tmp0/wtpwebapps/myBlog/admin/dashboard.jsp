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

<title>Project | Home</title>
<style>
.upDownButton {
            background: url("../imgFolder/up.png") no-repeat scroll 0 0; bottom: 10px; right: 10px;
            position: fixed; width: 50px; height: 50px;
            cursor: pointer; display: none;
        }
</style>
<!-- Bootstrap -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/style.css" rel="stylesheet">
    
    <!-- JQuery -->
    <script src="../js/jquery.min.js"></script>
    <script src="../js/myScript.js"></script>
     
     
     <script src="../js/jquery.js"></script>
     <script src="../js/jquery-ui.min.js"></script> 
     <link rel="stylesheet" href="../css/jquery-ui.min.css">
    
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
        <li><a href="dashboard.jsp">Dashboard</a></li>      
      </ul>
      
      <ul class="nav navbar-nav navbar-right">
        <li><a href="../adminLogout?action=logout">LOGOUT</a></li>
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
                                    <li><a href="../index.jsp">Home</a></li>
                                    <li><a href="Category/index.jsp">Manage Category</a></li>
                                    <li><a href="create.jsp">Create new post</a></li>
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
            
  <%
postsCls postClsObj = new postsCls();
List<PostsModel> allPostList = new ArrayList<PostsModel>();
		   allPostList = postClsObj.index();
		   
	for(PostsModel singlePost  : allPostList){
		
%>

<div class="row well"> <!-- Start Blog body post row -->

 <div class="col-md-8">
    <div class="post">
   <strong><% out.print(singlePost.getPostTitle()); %></strong>
   <hr>
   <p><%
   if(singlePost.getPostBody().length() >= 200){
	   out.print(singlePost.getPostBody().substring(0,200)+" ......");
      }else{
    	  out.print(singlePost.getPostBody());  
      }  
   %></p> 
  </div>
 </div>
 
  <div class="col-md-2">
    <div class="post">
   <strong>Post Image</strong>
   <hr>
  <div style="width:100px; height:80px">
  <%
  String img = singlePost.getPostImage().toString();
if(img.equals("null")){ %>
	No Image
<%}else{%>
    <img src="../imgFolder/<% out.print(singlePost.getPostImage()); %>" width="100px" height="80px"/> 	
<%}%>
  </div>  
  </div>
 </div>
 <div class="col-md-2">
 <strong>Category</strong>
 <hr>
 <%
 String allCatagory = singlePost.getCategory();
 String[] allCategoryArr = allCatagory.split(",");
 
 for(int i=0; i<allCategoryArr.length; i++){
	 int CategoryId = Integer.parseInt(allCategoryArr[i]);
	 	 categoryCls categoryClsObj = new categoryCls();
	     List<CategoryModel> dataforShow = categoryClsObj.singleShow(CategoryId);
	     for(CategoryModel singleCategory : dataforShow){ %>
		    
		    <p class="btn btn-default"><% out.print(singleCategory.getCategory_title()); %></p>
		    
	     <% }
	
    }
 %> 
</div>
 
<div class="col-md-12">
 
    <a href="../postSingleShow?id=<% out.print(singlePost.getId()); %>"  class="btn btn-success">PREVIEW POST</a>
    <a href="../editPost?id=<% out.print(singlePost.getId()); %>" class="btn btn-primary">EDIT POST</a>
    <a href="../deletePost?id=<% out.print(singlePost.getId()); %>" class="btn btn-danger">DELETE POST</a>
 
 </div>
</div> <!-- End Blog body row -->

<% } %>
           
         <div class="upDownButton"></div>   
        </section>
       <!-- End body contain section -->
       
        <footer class="footer_area">
            <div class="row">
                <div class="col-xs-12">
                    <div class="copyright">
                        <p>&copy; Copyright imranmadbar@gmail.com</p>
                    </div>
                </div>
            </div>
        </footer>
 
 </div>     <!-- End container -->
</div>
 <script src="../js/bootstrap.min.js"></script>
 <script src="../js/jquery.min.js"></script>
 
</body>
</html>