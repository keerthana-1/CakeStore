package Service;

import java.sql.SQLException;

import DAO.DbDAO;
import DAO.LoginDAO;
import Domain.UserObject;

public class LoginService {
	
	private LoginDAO loginDAO; 
	
	public LoginService() throws SQLException {
		
		loginDAO=new LoginDAO();
		
	}
	
	
	public String ValidateUser(String email,String password) throws SQLException {
		
		
		UserObject u=loginDAO.getLoginDetails(email);
		if(u!=null)
		{
			System.out.println(u.getPassword());
		if(email.equals("keerthi@gmail.com") && u.getPassword().equals(password)) {
			
				return "admin";
			
		}
		else if(u.getEmail().equals(email) && u.getPassword().equals(password)){
			
			return "user";
		}
		
		}
		return "none";
		
	}
	
	
	public UserObject getUserDetails(String email) throws SQLException {
		
		UserObject u1=loginDAO.getLoginDetails(email);
		return u1;
		
	}
	

}
