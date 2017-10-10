<%@page import="com.dao.commentsCls"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.dao.adminCls"%>
<%@page import="com.Models.adminModel"%>
<%@page import="com.dao.adminCls"%>
<%@page import="com.dao.postsCls" %>
<%@page import="com.Models.adminModel"%>
<%@page import="com.Models.PostsModel" %>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.categoryCls" %>
<%@page import="com.Models.CategoryModel" %>
<%@page import="com.Models.CommentsModel" %>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Project | Home</title>
<style>
.upDownButton {
            background: url("imgFolder/up.png") no-repeat scroll 0 0; bottom: 10px; right: 10px;
            position: fixed; width: 50px; height: 50px;
            cursor: pointer; display: none;
        }
</style>
<!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
        
    <!-- JQuery -->
    <script src="js/jquery.min.js"></script>
    <script src="js/myScript.js"></script>
     
     
     <script src="js/jquery.js"></script>
     <script src="js/jquery-ui.min.js"></script> 
     <link rel="stylesheet" href="css/jquery-ui.min.css">
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
        <li><a href="admin/dashboard.jsp">Dashboard</a></li>      
      </ul>
      
      <ul class="nav navbar-nav navbar-right">
        <li><a href="adminLogout?action=logout">LOG OUT</a></li>
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
                                    <li><a href="index.jsp">Home</a></li>
                                    <li><a href="about.jsp">About us</a></li>
                                    <li><a href="contact.jsp">Contact</a></li>
                            
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
int postId = Integer.parseInt(request.getParameter("id"));
postsCls postClsObj = new postsCls();

List<PostsModel> dataforSingleShow = postClsObj.singleShow(postId);

 for(PostsModel singlePost  : dataforSingleShow){	
%>
           
       <!-- End Left side bar -->
            <div class="col-md-12">
                    <div class="single_content_post">
                     <div class="post_view">
                       <div class="row">
                        <div class="col-md-12">
                      <h2><% out.print(singlePost.getPostTitle()); %></h2>
                     </div>                       
 <div class="col-md-4">
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
                       </div>
                         <div class="row">
                         
                         <div class="col-md-12">
                         <div class="single_post_image">
                          <%
                          String img = singlePost.getPostImage().toString();
  
                           if(!img.equals("null")){ %>                       
                            <img src="imgFolder/<% out.print(singlePost.getPostImage()); %>"   width="650px" height="450px"/> 	
                           <%}%>                        
                         </div>                        
                         </div>
                         
                         
                         <div class="col-md-12">
                         
                          <div class="single_post_body">
                           <% out.print(singlePost.getPostBody()); %> 
                         </div>
                         
                         </div>
                         </div>
                         
                                                                      
                         
                         
                         
                         
                         
                         
                         
                     </div>
                    </div>
                                                                                              
                </div>                       
            </div>
             
            
          <div class="row"><!-- Comment box -->
           <div class="col-md-10 col-md-offset-1">
           <hr>
           <div class="row">
           <div class="col-md-6">
           
           <%
           String postID = request.getParameter("id");
           commentsCls commentClsObj = new commentsCls();
           List<CommentsModel> allComments = new ArrayList<CommentsModel>();
           allComments = commentClsObj.index(postID);
           %>
           <div class="comment_view">
           <h4>Total commen:<% out.print(allComments.toArray().length); %></h4>
           </div>
           <%          
           for(CommentsModel singleComment : allComments){
           %>
           <div class="comment_body">
           <h6><% out.print(singleComment.getEmail()); %></h6>
           <p><% out.print(singleComment.getComment()); %></p>
           </div>
           <% } %>
           
           </div>
           <div class="col-md-4 col-md-offset-1">
           
  <dl class="dl-horizontal">
  <dt>Public :</dt>
  <dd><%out.print(singlePost.getCreate_at()); %></dd>
  </dl>
 <dl class="dl-horizontal">
  <dt>Category:</dt>
  <dd>
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
  </dd>
  </dl> 
 
 <dl class="dl-horizontal">
  <dt>Last update :</dt>
  <dd>
  <%
  if(singlePost.getModify_at() == null){
	  out.print("Not yeat.");
  }else{
	  out.print(singlePost.getModify_at()); 
  }
   %>
  </dd>
</dl>
           </div>
           </div>
           
           <div class="comment_box">
           <h4>Your comment:</h4>
           <div class="row">
           <div class="col-md-6">
   <form action="createComments" method="POST">
    <div class="form-group">  
     <label class="control-label">Email:</label>
     <input type="text" id="title" name="email" class="form-control">    
    </div>
    
     <div class="form-group">  
     <label class="control-label">Comment:</label>
     <textarea id="body" name="comment"  rows="5" class="form-control"> Type your message here.....</textarea> 
    </div>
    <input type="hidden" name="post_id" value="<% out.print(singlePost.getId()); %>"/>
    <input type="submit" value="Submit" class="btn btn-success btn-lg btn-block">
    
   </form>
           </div>          
           </div>
           
           </div>
           </div>        
           
           </div><!-- end body row  -->
   <% } %> 
       <div class="upDownButton"></div>        
        </section>
       <!-- End body contain section -->
       
       <div class="row">
        <div class="col-md-10 col-md-offset-1">
         <footer class="footer_area">
            <div class="row">
                <div class="col-md-12">
                    <div class="copyright">
                        <p>&copy; Copyright Md Imran hossain.</p>
                    </div>
                </div>
            </div>
        </footer>
        </div>
       </div>
 
 </div>     <!-- End main container -->

 <script src="js/bootstrap.min.js"></script>
 <script src="js/jquery.min.js"></script>
 
</body>
</html>