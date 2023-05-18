package Presentation;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Domain.FlavorObject;
import Domain.OccasionObject;
import Service.FiltersService;

/**
 * Servlet implementation class OccasionServlet
 */
@WebServlet("/OccasionServlet")
public class OccasionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private FiltersService fs;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OccasionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String name=request.getParameter("occasion");
		String id=request.getParameter("id");
		
		
		OccasionObject o=new OccasionObject();
		o.setOccasion(name);;
		try {
			fs=new FiltersService();
		if(name!=null) {
				
				fs.insertOccasion(o);
				response.sendRedirect("AddOccasion.jsp");
		}
	
		else {
			fs.DeleteOccasion(Integer.parseInt(id));
			response.sendRedirect("AddOccasion.jsp");
		  }
		
		
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
