/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.55
 * Generated at: 2016-12-23 13:27:08 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.dao.adminCls;
import com.dao.postsCls;
import com.Models.adminModel;
import com.Models.PostsModel;
import java.util.ArrayList;
import com.dao.categoryCls;
import com.Models.CategoryModel;
import java.util.List;

public final class dashboard_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("\r\n");
      out.write("<title>Project | Home</title>\r\n");
      out.write("<style>\r\n");
      out.write(".upDownButton {\r\n");
      out.write("            background: url(\"../imgFolder/up.png\") no-repeat scroll 0 0; bottom: 10px; right: 10px;\r\n");
      out.write("            position: fixed; width: 50px; height: 50px;\r\n");
      out.write("            cursor: pointer; display: none;\r\n");
      out.write("        }\r\n");
      out.write("</style>\r\n");
      out.write("<!-- Bootstrap -->\r\n");
      out.write("    <link href=\"../css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"../css/style.css\" rel=\"stylesheet\">\r\n");
      out.write("    \r\n");
      out.write("    <!-- JQuery -->\r\n");
      out.write("    <script src=\"../js/jquery.min.js\"></script>\r\n");
      out.write("    <script src=\"../js/myScript.js\"></script>\r\n");
      out.write("     \r\n");
      out.write("     \r\n");
      out.write("     <script src=\"../js/jquery.js\"></script>\r\n");
      out.write("     <script src=\"../js/jquery-ui.min.js\"></script> \r\n");
      out.write("     <link rel=\"stylesheet\" href=\"../css/jquery-ui.min.css\">\r\n");
      out.write("    \r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"main_container\">\r\n");

String loginId = (String) session.getAttribute("loginID");
if(!session.isNew() && session.getAttribute("loginID") != null){
	adminCls adminClsObj = new adminCls();
	List<adminModel> selectedAdmin = adminClsObj.getAdminInfo(loginId);
	for(adminModel userInfo : selectedAdmin ){

      out.write(" \r\n");
      out.write("<!-- Admin login Navbar -->\r\n");
      out.write("  \r\n");
      out.write("<!-- End Admin login Navbar -->\r\n");
      out.write("<nav class=\"navbar navbar-inverse navbar-default navbar-fixed-top\">\r\n");
      out.write("  <div class=\"navbar-header\">\r\n");
      out.write("            <a class=\"navbar-brand\" href=\"about.jsp\">Welcome : </a>\r\n");
      out.write("            <a class=\"navbar-brand\" href=\"contact.jsp\">");
 out.print(userInfo.getAdminName()); 
      out.write("</a>              \r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("     <div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\r\n");
      out.write("      <ul class=\"nav navbar-nav\">\r\n");
      out.write("        <li><a href=\"dashboard.jsp\">Dashboard</a></li>      \r\n");
      out.write("      </ul>\r\n");
      out.write("      \r\n");
      out.write("      <ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("        <li><a href=\"../adminLogout?action=logout\">LOGOUT</a></li>\r\n");
      out.write("      </ul>\r\n");
      out.write("    </div>\r\n");
      out.write("</nav>\r\n");
      out.write("\r\n");
      out.write("<nav class=\"adminNav\"></nav>\r\n");
      out.write("\r\n");
      out.write("\r\n");
	
// session.setAttribute("loginID", null);
	}
}

      out.write("\r\n");
      out.write("\r\n");
      out.write(" <div class=\"container\"> <!-- Start container -->\r\n");
      out.write("  <header class=\"header_area\">\r\n");
      out.write("   <div class=\"row\">\r\n");
      out.write("    <div class=\"col-md-12\">\r\n");
      out.write("     <div class=\"logo\">\r\n");
      out.write("      <h2>Welcome to Blog</h2>\r\n");
      out.write("      <p>This is a general blog web, anyway thank's for visiting our blog.</p>\r\n");
      out.write("     </div>\r\n");
      out.write("    </div>\r\n");
      out.write("   </div>\r\n");
      out.write("  </header> \r\n");
      out.write("  <!-- Start Navigation bar -->\r\n");
      out.write("   <nav class=\"navigation\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-xs-12 col-md-11 col-md-offset-1\">\r\n");
      out.write("                    <nav class=\"navbar navbar-default2\">\r\n");
      out.write("                        <div class=\"container-fluid\">\r\n");
      out.write("                            <!-- Brand and toggle get grouped for better mobile display -->\r\n");
      out.write("                            <div class=\"navbar-header\">\r\n");
      out.write("                                <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\" aria-expanded=\"false\">\r\n");
      out.write("                                    <span class=\"sr-only\">Toggle navigation</span>\r\n");
      out.write("                                    <span class=\"icon-bar\"></span>\r\n");
      out.write("                                    <span class=\"icon-bar\"></span>\r\n");
      out.write("                                    <span class=\"icon-bar\"></span>\r\n");
      out.write("                                </button>\r\n");
      out.write("                            </div>\r\n");
      out.write("\r\n");
      out.write("                            <!-- Collect the nav links, forms, and other content for toggling -->\r\n");
      out.write("                            <div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\r\n");
      out.write("                                <ul class=\"nav navbar-nav\">\r\n");
      out.write("                                    <li><a href=\"../index.jsp\">Home</a></li>\r\n");
      out.write("                                    <li><a href=\"Category/index.jsp\">Manage Category</a></li>\r\n");
      out.write("                                    <li><a href=\"create.jsp\">Create new post</a></li>\r\n");
      out.write("                                </ul>\r\n");
      out.write("                            </div><!-- /.navbar-collapse -->\r\n");
      out.write("                        </div><!-- /.container-fluid -->\r\n");
      out.write("                    </nav>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </nav>\r\n");
      out.write(" <!-- End Navigation bar -->\r\n");
      out.write(" <!-- body contain section -->\r\n");
      out.write("  <section class=\"content_area\">\r\n");
      out.write("            \r\n");
      out.write("  ");

postsCls postClsObj = new postsCls();
List<PostsModel> allPostList = new ArrayList<PostsModel>();
		   allPostList = postClsObj.index();
		   
	for(PostsModel singlePost  : allPostList){
		

      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"row well\"> <!-- Start Blog body post row -->\r\n");
      out.write("\r\n");
      out.write(" <div class=\"col-md-8\">\r\n");
      out.write("    <div class=\"post\">\r\n");
      out.write("   <strong>");
 out.print(singlePost.getPostTitle()); 
      out.write("</strong>\r\n");
      out.write("   <hr>\r\n");
      out.write("   <p>");

   if(singlePost.getPostBody().length() >= 200){
	   out.print(singlePost.getPostBody().substring(0,200)+" ......");
      }else{
    	  out.print(singlePost.getPostBody());  
      }  
   
      out.write("</p> \r\n");
      out.write("  </div>\r\n");
      out.write(" </div>\r\n");
      out.write(" \r\n");
      out.write("  <div class=\"col-md-2\">\r\n");
      out.write("    <div class=\"post\">\r\n");
      out.write("   <strong>Post Image</strong>\r\n");
      out.write("   <hr>\r\n");
      out.write("  <div style=\"width:100px; height:80px\">\r\n");
      out.write("  ");

  String img = singlePost.getPostImage().toString();
if(img.equals("null")){ 
      out.write("\r\n");
      out.write("\tNo Image\r\n");
}else{
      out.write("\r\n");
      out.write("    <img src=\"../imgFolder/");
 out.print(singlePost.getPostImage()); 
      out.write("\" width=\"100px\" height=\"80px\"/> \t\r\n");
}
      out.write("\r\n");
      out.write("  </div>  \r\n");
      out.write("  </div>\r\n");
      out.write(" </div>\r\n");
      out.write(" <div class=\"col-md-2\">\r\n");
      out.write(" <strong>Category</strong>\r\n");
      out.write(" <hr>\r\n");
      out.write(" ");

 String allCatagory = singlePost.getCategory();
 String[] allCategoryArr = allCatagory.split(",");
 
 for(int i=0; i<allCategoryArr.length; i++){
	 int CategoryId = Integer.parseInt(allCategoryArr[i]);
	 	 categoryCls categoryClsObj = new categoryCls();
	     List<CategoryModel> dataforShow = categoryClsObj.singleShow(CategoryId);
	     for(CategoryModel singleCategory : dataforShow){ 
      out.write("\r\n");
      out.write("\t\t    \r\n");
      out.write("\t\t    <p class=\"btn btn-default\">");
 out.print(singleCategory.getCategory_title()); 
      out.write("</p>\r\n");
      out.write("\t\t    \r\n");
      out.write("\t     ");
 }
	
    }
 
      out.write(" \r\n");
      out.write("</div>\r\n");
      out.write(" \r\n");
      out.write("<div class=\"col-md-12\">\r\n");
      out.write(" \r\n");
      out.write("    <a href=\"../postSingleShow?id=");
 out.print(singlePost.getId()); 
      out.write("\"  class=\"btn btn-success\">PREVIEW POST</a>\r\n");
      out.write("    <a href=\"../editPost?id=");
 out.print(singlePost.getId()); 
      out.write("\" class=\"btn btn-primary\">EDIT POST</a>\r\n");
      out.write("    <a href=\"../deletePost?id=");
 out.print(singlePost.getId()); 
      out.write("\" class=\"btn btn-danger\">DELETE POST</a>\r\n");
      out.write(" \r\n");
      out.write(" </div>\r\n");
      out.write("</div> <!-- End Blog body row -->\r\n");
      out.write("\r\n");
 } 
      out.write("\r\n");
      out.write("           \r\n");
      out.write("         <div class=\"upDownButton\"></div>   \r\n");
      out.write("        </section>\r\n");
      out.write("       <!-- End body contain section -->\r\n");
      out.write("       \r\n");
      out.write("        <footer class=\"footer_area\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-xs-12\">\r\n");
      out.write("                    <div class=\"copyright\">\r\n");
      out.write("                        <p>&copy; Copyright imranmadbar@gmail.com</p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </footer>\r\n");
      out.write(" \r\n");
      out.write(" </div>     <!-- End container -->\r\n");
      out.write("</div>\r\n");
      out.write(" <script src=\"../js/bootstrap.min.js\"></script>\r\n");
      out.write(" <script src=\"../js/jquery.min.js\"></script>\r\n");
      out.write(" \r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
