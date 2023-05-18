package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import Domain.FlavorObject;
import Domain.OccasionObject;
import Domain.SizeObject;

public class FiltersDAO {
	
	private Connection connection;
	DbDAO dbDAO;  // for common DB methods
		    
	public FiltersDAO() throws SQLException {
			dbDAO = new DbDAO();
			connection = dbDAO.getConnection();
				
	}
	
public void DeleteFlavor(int fid) throws SQLException{
		
		

		Statement stmt = connection.createStatement();
		try {
			
			String query="Delete from cake_flavor where Id="+fid;
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

public void InsertFlavor(FlavorObject fo) throws SQLException{
	
	

	Statement stmt = connection.createStatement();
	try {
		
		String query="insert into cake_flavor(Name) values('"+fo.getFlavor()+"')";
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

public void InsertOccasion(OccasionObject o) throws SQLException{
	
	

	Statement stmt = connection.createStatement();
	try {
		
		String query="insert into occasion(Occasion) values('"+o.getOccasion()+"')";
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

public void DeleteOccasion(int oid) throws SQLException{
	
	

	Statement stmt = connection.createStatement();
	try {
		
		String query="Delete from occasion where Id="+oid;
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

public void InsertSize(SizeObject s) throws SQLException{
	
	

	Statement stmt = connection.createStatement();
	try {
		
		String query="insert into cake_size(Measure) values('"+s.getMeasure()+"')";
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

public void DeleteSize(int sid) throws SQLException{
	
	

	Statement stmt = connection.createStatement();
	try {
		
		String query="Delete from cake_size where Id="+sid;
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
