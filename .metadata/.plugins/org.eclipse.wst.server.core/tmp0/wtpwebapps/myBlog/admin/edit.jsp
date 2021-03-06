<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="com.dao.postsCls"%>
<%@page import="com.dao.adminCls" %>
<%@page import="com.dao.categoryCls" %>
<%@page import="com.Models.CategoryModel" %>
<%@page import="com.Models.adminModel" %>
<%@page import="com.Models.PostsModel"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Post | Edit</title>
<style>
.upDownButton {
            background: url("../imgFolder/up.png") no-repeat scroll 0 0; bottom: 10px; right: 10px;
            position: fixed; width: 50px; height: 50px;
            cursor: pointer; display: none;
        }
</style>
<!-- Bootstrap -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    
     <!-- JQuery -->
    <script src="../js/jquery.min.js"></script>
     <script src="../js/formValidation.js"></script> 
    <script src="../js/myScript.js"></script>
     
     
     <script src="../js/jquery.js"></script>
     <script src="../js/jquery-ui.min.js"></script> 
     <link rel="stylesheet" href="../css/jquery-ui.min.css">
     
          <!-- my Style -->
     <link href="../css/style.css" rel="stylesheet">
</head>
<body>

<!-- Start body Container -->
<div class="container">

<div class="row well">
<div class="col-md-5">
<h1>Current post:</h1>
</div>
<div class="col-md-5">
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
	
%>
</h4>
</div>
<div class="col-md-2">
<P><a class="btn btn-primary btn-lg" href="dashboard.jsp" role="button">Back to Dashboard</a></P>
</div>
</div>
<hr>
<%
int postId = Integer.parseInt(request.getParameter("id"));
postsCls postClsObj = new postsCls();

List<PostsModel> dataforSingleShow = postClsObj.singleShow(postId);
  for(PostsModel editPost : dataforSingleShow){
	  
%>

<div class="row well">  <!-- Start row -->
 <div class="col-md-8 col-md-offset-2">
  <div>
    <form action="../updatePost" method="POST" enctype="multipart/form-data" id="postForms">
    <div class="form-group">  
     <label class="control-label">Title:</label>
     <input type="text" id="postTitles" name="title" class="form-control" value="<% out.print(editPost.getPostTitle()); %>">    
   <span class="msg" id="postTitleMsg"></span>
    </div>
 
     <div class="form-group">  
     <label class="control-label">Category:</label>
 <%
 String allCatagory = editPost.getCategory();
 String[] allCategoryArr = allCatagory.split(",");
 categoryCls categoryObj = new categoryCls();
 List<CategoryModel> categoryList = new ArrayList<CategoryModel>();
 
 categoryList = categoryObj.index();
 for(CategoryModel singleCategory : categoryList){
 %>
     <input type="checkbox" class="form-control" name="category" value="<% out.print(singleCategory.getId()); %>" <%= Arrays.asList(allCategoryArr).contains(singleCategory.getId())? "checked='checked'" : "" %>>
     <% out.print(singleCategory.getCategory_title()); %>
<% 
 }
%>
    </div>
    
    
     <div class="form-group">  
     <label class="control-label">Body:</label>
     <textarea id="postbody" name="body"  rows="10" class="form-control"><%out.print(editPost.getPostBody()); %></textarea> 
    <span class="msg" id="postBodyMsg"></span>
    </div>
    
   <div class="form-group">  
   <label class="control-label">Current Image:</label>
   <div>
     <%
  String img = editPost.getPostImage().toString();
  
 if(img.equals("null")){ %>
	No Image
<%}else{%>
    <img src="../imgFolder/<% out.print(editPost.getPostImage()); %>"  width="100px" height="100px"/> 	
<%}%>
   </div>
 
    </div>
    
    <div class="form-group">  
    <label class="control-label">New Image:</label>
     <input type="file" id="image" name="image" class=" ">    
    </div>
    <input type="hidden" name="currentPostId" value="<% out.print(editPost.getId()); %>"></input>
    <input type="hidden" name="currentImgName" value="<% out.print(editPost.getPostImage()); %>"></input>
    
    <input type="submit" value="Update now" class="btn btn-success btn-lg btn-block">
    
   </form>
 <%} %>
 </div> 
 </div>
  
  
</div> <!-- End Blog body row -->
 <div class="upDownButton"></div> 
</div> <!-- End Container -->



 <script src="../js/jquery.min.js"></script>
 <script src="../js/bootstrap.min.js"></script>
</body>
</html>