package ExpressionLanServalte;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class scopeVarCheck
 */
@WebServlet("/scopeVarCheck")
public class scopeVarCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public scopeVarCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
		request.setAttribute("att1", "This is Request Attributs Value."); // access can be only forward page
		session.setAttribute("att2","This is Session Arrribut Value."); // access can be any page
		
		ServletContext application = getServletContext();
		application.setAttribute("att3", "This is ServlatContext application Msg."); // access can be any page
		
		request.setAttribute("same", "This is same name request Attributs"); // access can be only forward page
		session.setAttribute("same", "This is same name Session Arrributs"); // access can be any page
		
		application.setAttribute("same", "This is same name application msg."); // access can be any page
		
		
		
		
		
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("ExpressionLanguageOfJsp/scopeVarCheck1.jsp");
		dispatcher.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
