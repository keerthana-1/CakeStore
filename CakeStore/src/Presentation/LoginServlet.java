package Presentation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DbDAO;
import Domain.UserObject;
import Service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        
        // TODO Auto-generated constructor stub
    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			
		String email=request.getParameter("Email");
		String password=request.getParameter("Password");
		
		 
		
			try {
				
				LoginService s=new LoginService();
				String role=s.ValidateUser(email,password);
				
				UserObject u=s.getUserDetails(email);
				request.getSession().setAttribute("username", email);
				request.getSession().setAttribute("name", u.getName());
				request.getSession().setAttribute("address", u.getAddress());
				request.getSession().setAttribute("phone", u.getPhone());
				
				if(role=="admin") {
					
					response.sendRedirect("Admin.html");
				}
				else if(role=="user") {
					response.sendRedirect("Home.jsp");
				}
				else {
					response.setContentType("text/html"); 
					PrintWriter out = response.getWriter(); 
					out.println("<script language=\"javascript\">");
					out.println("alert(not loggedin)");
					out.println("</script>");
					response.sendRedirect("Login.html");
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
