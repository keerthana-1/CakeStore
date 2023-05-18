package Service;

import java.sql.SQLException;
import java.util.List;

import DAO.AdminDAO;
import Domain.OrderDetailsObject;
import Domain.UserObject;

public class AdminService {
	
private AdminDAO adminDAO; 
	
	public AdminService() throws SQLException {
		
		adminDAO=new AdminDAO();
		
	}
	
	
	public List<UserObject> GetUsers() throws SQLException {
		
		
		List<UserObject> u=adminDAO.getUserDetails();
		return u;
		
	}
	
	public List<OrderDetailsObject> GetOrders() throws SQLException {
		
		
		List<OrderDetailsObject> u=adminDAO.getOrderDetails();
		return u;
		
	}

}
