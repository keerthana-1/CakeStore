package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import Domain.CakeObject;

public class DeletecakeDAO {
	private Connection connection;
	DbDAO dbDAO;  // for common DB methods
		    
	public DeletecakeDAO() throws SQLException {
			dbDAO = new DbDAO();
			connection = dbDAO.getConnection();
				
	}
	
public void DeleteCake(int cid) throws SQLException{
		
		

		Statement stmt = connection.createStatement();
		try {
			
			String query="Delete from cake where Id="+cid;
			int count = stmt.executeUpdate(query);
			if(count==1) {
				System.out.println("deleted succesfully");
				
			}
			else {
				System.out.println("deletion failed");
			}
			
			
			} 
		finally {
			stmt.close();
		}
		
		
	}


}
