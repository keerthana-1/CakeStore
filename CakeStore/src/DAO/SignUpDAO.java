package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import Domain.UserObject;

public class SignUpDAO {
	
	private Connection connection;
	DbDAO dbDAO;  // for common DB methods
		    
	public SignUpDAO() throws SQLException {
			dbDAO = new DbDAO();
			connection = dbDAO.getConnection();
				
	}
			
	public void InsertUserDetails(UserObject user) throws SQLException{
		
		

		Statement stmt = connection.createStatement();
		try {
			
			String query="Insert into Users(Name,Email,Address,Phone,Password) values('"+user.getName()+"','"+user.getEmail()+"','"+user.getAddress()+"','"+user.getPhone()+"','"+user.getPassword()+"')";
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

}
