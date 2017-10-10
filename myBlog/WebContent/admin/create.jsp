<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.dao.categoryCls" %>
    <%@page import="com.Models.CategoryModel"%>
    <%@page import="java.util.ArrayList"%>
    <%@page import="com.Models.PostsModel" %>
    <%@page import="java.util.List"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Project | Home</title>   
    <!-- JQuery -->
    <script src="../js/jquery.min.js"></script>
     <script src="../js/formValidation.js"></script> 
     
     
     <script src="../js/jquery.js"></script>
     <script src="../js/jquery-ui.min.js"></script> 
     <link rel="stylesheet" href="../css/jquery-ui.min.css">
     
     <!-- Bootstrap -->
     <link href="../css/bootstrap.min.css" rel="stylesheet">
     <!-- my Style -->
     <link href="../css/style.css" rel="stylesheet">
     
         
     <script>     
  $( function() {
    $( document ).tooltip();
  } );
  </script>   
</head>
<body>

<!-- Start body Container -->
<div class="container">

<div class="row well">
<div class="col-md-5">
<h1>Create new post</h1>
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





<div class="row well">  <!-- Start row -->
 

 <div class="col-md-8 col-md-offset-1">
  <div>
    <form action="../createPost" method="POST" enctype="multipart/form-data" class="form-horizontal" id="postForms">
   
    
    <div class="form-group">  
     <label class="control-label">Title:</label>
     <input type="text" id="postTitles" name="title" class="form-control" title="Here will your post title."> 
     <span class="msg" id="postTitleMsg"></span>       
    </div>   
    
    
    <div class="form-group">  
     <label class="control-label">Category:</label>
 <%
 categoryCls categoryObj = new categoryCls();
 List<CategoryModel> categoryList = new ArrayList<CategoryModel>();
 
 categoryList = categoryObj.index();
 for(CategoryModel singleCategory : categoryList){
 %>
     <input type="checkbox" class="form-control" name="category" id="postCategorys" value="<% out.print(singleCategory.getId()); %>">
     <% out.print(singleCategory.getCategory_title()); %>
<% 
 }
%>    
    </div>
    <span class="msg" id="postCategoryMsg">this is post msg</span>
    
     <div class="form-group">  
     <label class="control-label">Body:</label>
     <textarea id="postbody" name="body"  rows="10" class="form-control" title="This is post body, write down details about this artical."> Type your message here.....</textarea> 
     <span class="msg" id="postBodyMsg"></span>
    </div>
    
    <div class="form-group">  
    <label class="control-label">Image:</label>
    <input type="file" id="postImage" name="image" class=" ">
         
    
    
    <input type="submit" value="Save now" class="btn btn-success btn-lg btn-block">
    </div>
    
   </form>
 
 </div> 
 </div>
  
  
</div> <!-- End Blog body row -->

</div> <!-- End Container -->



 <script src="../js/jquery.min.js"></script>
 <script src="../js/bootstrap.min.js"></script>
</body>
</html>