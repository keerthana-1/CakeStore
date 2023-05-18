package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Domain.CartObject;
import Domain.OrderDetailsObject;
import Domain.OrderObject;
import Domain.UserObject;

public class AdminDAO {

	private Connection connection;
	DbDAO dbDAO;  // for common DB methods
		    
	public AdminDAO() throws SQLException {
			dbDAO = new DbDAO();
			connection = dbDAO.getConnection();
				
	}
			
	public List<UserObject> getUserDetails() throws SQLException{
		
		List<UserObject> users = new ArrayList<UserObject>();
		UserObject user=null;

		Statement stmt = connection.createStatement();
		try {
			
			ResultSet rs = stmt.executeQuery("select * from Users");
			
			while (rs.next()) {
				
				
			   user = new UserObject();
			   user.setName(rs.getString("Name"));
			   user.setEmail(rs.getString("Email"));
			   user.setAddress(rs.getString("Address"));
			   user.setPhone(rs.getString("Phone"));
			   user.setPassword(rs.getString("Password"));
			   
			   users.add(user);
			   
			
			} 
		}
		finally {
			stmt.close();
		}
		
		return users;	
		
	}
	
public List<OrderDetailsObject> getOrderDetails() throws SQLException{
		
		
		List<OrderDetailsObject> orders = new ArrayList<OrderDetailsObject>();
		
		OrderDetailsObject od=null;

		Statement stmt = connection.createStatement();
		try {
			
			String query="select o.order_id,o.user_id,c.Name,ci.Quantity,ci.Measure,ci.Message,c.Price,o.Shipping_address,o.Phone,o.Delivery_date from Order_Details o join cart_items ci on o.cart_id=ci.cart_id join cake c on ci.cake_id=c.Id order by o.order_id";
					
			
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				
				
			   od = new OrderDetailsObject();
			   od.setOrderId(rs.getInt("order_id"));
			   od.setName(rs.getString("Name"));
			   od.setQty(rs.getInt("Quantity"));
			   od.setSize(rs.getString("Measure"));
			   od.setMsg(rs.getString("Message"));
			   od.setPrice(rs.getInt("Price"));
			   
			   od.setEmail(rs.getString("user_id"));
			   od.setAddress(rs.getString("Shipping_address"));
			   od.setPhone(rs.getString("Phone"));
			   od.setDate(rs.getString("Delivery_date"));
			   
			   orders.add(od);
			
			} 
			
		}
		finally {
			stmt.close();
		}
		
		return orders;	
		
	}
}
