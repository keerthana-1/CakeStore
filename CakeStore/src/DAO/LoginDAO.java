package DAO;

import java.sql.*;

import Domain.UserObject;


public class LoginDAO {
	
	private Connection connection;
	DbDAO dbDAO;  // for common DB methods
		    
	public LoginDAO() throws SQLException {
			dbDAO = new DbDAO();
			connection = dbDAO.getConnection();
				
	}
			
	public UserObject getLoginDetails(String email) throws SQLException{
		
		UserObject user = null;

		Statement stmt = connection.createStatement();
		try {
			
			ResultSet rs = stmt.executeQuery("select * from Users where Email='"+email+"'");
			
			if (rs.next()) {
				
				
			   user = new UserObject();
			   user.setName(rs.getString("Name"));
			   user.setEmail(rs.getString("Email"));
			   user.setAddress(rs.getString("Address"));
			   user.setPhone(rs.getString("Phone"));
			   user.setPassword(rs.getString("Password"));

			
			} 
		}
		finally {
			stmt.close();
		}
		
		return user;	
		
	}

}
