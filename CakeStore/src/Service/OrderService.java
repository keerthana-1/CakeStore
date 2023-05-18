package Service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import DAO.OrderDAO;
import Domain.CartObject;
import Domain.OrderDetailsObject;
import Domain.OrderObject;

public class OrderService {
	
private OrderDAO orderDAO; 
	
	public OrderService() throws SQLException {
		
		orderDAO=new OrderDAO();
		
	}

	public void InsertCartDetails(String userid, int price) throws SQLException {
		
		orderDAO.InsertCartDetails(userid, price);
	}
	
	
	public void InsertCartItems(CartObject c, int cart_id) throws SQLException{
		
		orderDAO.InsertCartItems(c, cart_id);
		
	}
	
	public void InsertOrderDetails(OrderObject o, int cart_id) throws SQLException, ParseException{
		
		orderDAO.InsertOrderDetails(o, cart_id);
	}
	
	public int getCartId(String email) throws SQLException {
		
		int cart_id=orderDAO.getCartId(email);
		return cart_id;
	}
	
	public List<OrderDetailsObject> GetUserOrderDetails(String user_id) throws SQLException, ParseException{
		
		List<OrderDetailsObject> o=orderDAO.getUserOrderDetails(user_id);
		return o;
	}
	
}
