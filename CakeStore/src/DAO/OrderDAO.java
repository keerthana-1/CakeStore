package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Domain.CartObject;
import Domain.OrderDetailsObject;
import Domain.OrderObject;
import Domain.UserObject;

public class OrderDAO {
	
	private Connection connection;
	DbDAO dbDAO;  // for common DB methods
		    
	public OrderDAO() throws SQLException {
			dbDAO = new DbDAO();
			connection = dbDAO.getConnection();
				
	}
	
	public void InsertCartDetails(String userid, int price) throws SQLException{

		Statement stmt = connection.createStatement();
		try {
			
			String query="Insert into Cart(user_id,total_price) values('"+userid+"','"+price+"')";
			
			int count = stmt.executeUpdate(query);
			if(count==1) {
				System.out.println("inserted succesfully");
				
			}
			else {
				System.out.println("insertion failed");
			}
			
			
			} 
		finally {
			stmt.close();
		}
		
		
	}
	
	
	public void InsertCartItems(CartObject c, int cart_id) throws SQLException{

		Statement stmt = connection.createStatement();
		try {
			
			String query="Insert into cart_items(cart_id,cake_id,Quantity,Measure,Message) values('"+cart_id+"','"+c.getId()+ "','"+c.getQty()+"','"+c.getSize()+"','"+c.getMsg()+ "')";
			
			int count = stmt.executeUpdate(query);
			if(count==1) {
				System.out.println("inserted succesfully");
				
			}
			else {
				System.out.println("insertion failed");
			}
			
			
			} 
		finally {
			stmt.close();
		}
		
		
	}
	
	
	public void InsertOrderDetails(OrderObject o, int cart_id) throws SQLException, ParseException{

		Statement stmt = connection.createStatement();
		try {
			
			 String sDate1=o.getDate();  
			
			
			String query="Insert into Order_Details(cart_id,user_id,Delivery_date,Phone,Shipping_address) values("+cart_id+",'"+o.getEmail()+ "',DATE '"+sDate1+"','"+o.getPhone()+"','"+o.getAddress()+ "')";
			
			int count = stmt.executeUpdate(query);
			if(count==1) {
				System.out.println("inserted succesfully");
				
			}
			else {
				System.out.println("insertion failed");
			}
			
			
			} 
		finally {
			stmt.close();
		}
		
		
	}
	
	public int getCartId(String email) throws SQLException{
		
		

		Statement stmt = connection.createStatement();
		int cart_id=0;
		
		try {
			
			ResultSet rs = stmt.executeQuery("select cart_id from Cart where user_id='"+email+"' fetch first 1 row only");
			
			if (rs.next()) {
				
				cart_id=rs.getInt("cart_id");
			
			} 
		}
		finally {
			stmt.close();
		}
		
		return cart_id;	
		
	}
	
	public List<OrderDetailsObject> getUserOrderDetails(String user_id) throws SQLException{
		
		
		List<OrderDetailsObject> orders = new ArrayList<OrderDetailsObject>();
		
		OrderDetailsObject od=null;

		Statement stmt = connection.createStatement();
		try {
			
			String query="select o.order_id,o.user_id,c.Name,ci.Quantity,ci.Measure,ci.Message,c.Price,o.Shipping_address,"
					+ "o.Phone,o.Delivery_date from Order_Details o join cart_items ci on o.cart_id=ci.cart_id join cake c on ci.cake_id=c.Id "
					+ "where o.user_id='"+user_id+"' order by o.order_id";
					
			
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
