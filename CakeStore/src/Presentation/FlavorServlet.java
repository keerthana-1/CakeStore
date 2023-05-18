package Presentation;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Domain.FlavorObject;
import Service.FiltersService;

/**
 * Servlet implementation class FlavorServlet
 */
@WebServlet("/FlavorServlet")
public class FlavorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private FiltersService fs;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FlavorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String name=request.getParameter("flavor");
		String id=request.getParameter("id");
		
		
		FlavorObject fo=new FlavorObject();
		fo.setFlavor(name);
		try {
			fs=new FiltersService();
		if(name!=null) {
				
				fs.insertFlavor(fo);
				response.sendRedirect("AddFlavor.jsp");
		}
	
		else {
			fs.DeleteFlavor(Integer.parseInt(id));
			response.sendRedirect("AddFlavor.jsp");
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
