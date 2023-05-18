package Presentation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Domain.CartObject;
import Domain.OrderObject;
import Service.OrderService;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String cart= request.getParameter("cart");   
		String order=request.getParameter("order");
		System.out.println(order);
		
		Gson gson = new Gson(); 
	
		CartObject[] cakeArray = gson.fromJson(cart, CartObject[].class); 
		
		OrderObject or = gson.fromJson(order, OrderObject.class);  
		
		
		System.out.println(or.getEmail());
		
		int total_price=0;
		
		for(CartObject item : cakeArray) {	
			
			total_price+=item.getQty()*item.getPrice();
			System.out.println(item.getId());
			System.out.println(item.getName());
			System.out.println(item.getPrice());
			System.out.println(item.getQty());
			System.out.println(item.getSize());
			System.out.println(item.getMsg());
		}
		
		
		try {
			OrderService s=new OrderService();
			s.InsertCartDetails(or.getEmail(), total_price);
			int cart_id=s.getCartId(or.getEmail());
			
			for(CartObject item : cakeArray) {	
					
				s.InsertCartItems(item, cart_id);
				
			}
			
			s.InsertOrderDetails(or, cart_id);
			
			response.sendRedirect("ShowUserOrders.jsp");
			
		} catch (SQLException | ParseException e) {
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
