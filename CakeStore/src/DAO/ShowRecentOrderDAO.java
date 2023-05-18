package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ShowRecentOrderDAO {
	
	
	
	private Connection connection;
	DbDAO dbDAO;  // for common DB methods
		    
	public ShowRecentOrderDAO() throws SQLException {
			dbDAO = new DbDAO();
			connection = dbDAO.getConnection();
				
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

}
