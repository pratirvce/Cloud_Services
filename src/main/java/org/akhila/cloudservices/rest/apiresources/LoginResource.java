package org.akhila.cloudservices.rest.apiresources;

import org.akhila.cloudservices.rest.services.UserDAOImpl;
import org.akhila.cloudservices.rest.model.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginResource extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginResource() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String error;
		String email = request.getParameter("email");
		String password= request.getParameter("password");
		HttpSession session = request.getSession();
		UserDAOImpl userDAOImpl = new UserDAOImpl();
	   
		User user = userDAOImpl.getUserByEmail(email,password);
		
		
		if(user.getFullname() == null){
			error = "Invalid username or password";
			System.out.println("Could not log you in please check your email & password");
			session.setAttribute("error", error);
			response.sendRedirect("index.jsp");
		}else{
			session.setAttribute("user",user);
			System.out.println(session.getAttribute("user"));
			error = "none";
			response.sendRedirect("welcome.jsp");
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if("logout".equalsIgnoreCase(request.getParameter("query"))){
			
			   HttpSession session = request.getSession();
			   session.removeAttribute("user");
			   session.invalidate();
			   response.sendRedirect("index.jsp");
			}
	}

}
