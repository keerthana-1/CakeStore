package Presentation;



import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;
import javax.servlet.http.Part;

import Domain.CakeObject;
import Service.AddCakeService;



/**
 * Servlet implementation class CakeServlet
 */
@WebServlet("/CakeServlet")
@MultipartConfig
public class CakeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CakeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String name=request.getParameter("Name");
		int price=Integer.parseInt(request.getParameter("Price"));
		int flavor=Integer.parseInt(request.getParameter("Flavor"));
		int occasion=Integer.parseInt(request.getParameter("Occasion"));
		String img_path = null;
		System.out.println(name+price+flavor+occasion);
		
		response.setContentType("text/html;charset=UTF-8");

	    // Create path components to save the file
	    final String path = "/Users/lakshmikeerthanaaravapalli/eclipse-workspace-jee/CakeStore/WebContent/Images";
	    final Part filePart = request.getPart("Cakeimg");
	    final String fileName = getFileName(filePart);

	    OutputStream out = null;
	    InputStream filecontent = null;
	    final PrintWriter writer = response.getWriter();
	    try {
	        out = new FileOutputStream(new File(path + File.separator
	                + fileName));
	        
	        img_path = "/Images" + File.separator + fileName;
	        filecontent = filePart.getInputStream();

	        int read = 0;
	        final byte[] bytes = new byte[1024];

	        while ((read = filecontent.read(bytes)) != -1) {
	            out.write(bytes, 0, read);
	        }
	        writer.println("New file " + fileName + " created at " + path);
	        
	      
	    } catch (FileNotFoundException fne) {
	        writer.println("You either did not specify a file to upload or are "
	                + "trying to upload a file to a protected or nonexistent "
	                + "location.");
	       
	    } finally {
	        if (out != null) {
	            out.close();
	        }
	        if (filecontent != null) {
	            filecontent.close();
	        }
	        if (writer != null) {
	            writer.close();
	        }
	    }
	    
	    CakeObject c= new CakeObject();
        c.setName(name);
        c.setImgPath(img_path);
        c.setFlavorId(flavor);
        c.setOccasionId(occasion);
        c.setPrice(price);
        
        AddCakeService s=new AddCakeService();
        s.storeCakeDetails(c);
        
        response.sendRedirect("AddCake.jsp");
	
	}

	private String getFileName(final Part part) {
	    final String partHeader = part.getHeader("content-disposition");
	    for (String content : part.getHeader("content-disposition").split(";")) {
	        if (content.trim().startsWith("filename")) {
	            return content.substring(
	                    content.indexOf('=') + 1).trim().replace("\"", "");
	        }
	    }
	    return null;
	}

 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
