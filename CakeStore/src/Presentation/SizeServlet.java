package Presentation;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Domain.FlavorObject;
import Domain.SizeObject;
import Service.FiltersService;

/**
 * Servlet implementation class SizeServlet
 */
@WebServlet("/SizeServlet")
public class SizeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private FiltersService fs;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SizeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String name=request.getParameter("size");
		String id=request.getParameter("id");
		
		
		SizeObject fo=new SizeObject();
		fo.setMeasure(name);
		try {
			fs=new FiltersService();
		if(name!=null) {
				
				fs.insertSize(fo);
				response.sendRedirect("AddSize.jsp");
		}
	
		else {
			fs.DeleteSize(Integer.parseInt(id));
			response.sendRedirect("AddSize.jsp");
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
