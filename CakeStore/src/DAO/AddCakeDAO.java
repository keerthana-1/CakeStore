package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Domain.*;

public class AddCakeDAO {
	
	private Connection connection;
	DbDAO dbDAO;  // for common DB methods
		    
	public AddCakeDAO() throws SQLException {
			dbDAO = new DbDAO();
			connection = dbDAO.getConnection();
				
	}
	
public void InsertCakeDetails(CakeObject cake) throws SQLException{
		
		

		Statement stmt = connection.createStatement();
		try {
			
			String query="Insert into cake(Name,Image_path,Flavor_id,Price,Occasion_id) values('"+cake.getName()+"','"+cake.getImgPath()+"','"+cake.getFlavorId()+"','"+cake.getPrice()+"','"+cake.getOccasionId()+"')";
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

			
public List<FlavorObject> GetFlavor() throws SQLException{
		
		
	FlavorObject f = null;
	List<FlavorObject> flavors=new ArrayList<FlavorObject>();

	Statement stmt = connection.createStatement();
	try {
		
		ResultSet rs = stmt.executeQuery("select * from cake_flavor");
		
		while(rs.next()) {
			
			int id=rs.getInt("ID");
			String name=rs.getString("Name");
			f = new FlavorObject();
			f.setId(id);
			f.setFlavor(name);
			
			flavors.add(f);
		
		} 
	}
	finally {
			stmt.close();
		}
		
	return flavors;
	
	}


public List<OccasionObject> GetOccasion() throws SQLException{
	
	
	OccasionObject f = null;
	List<OccasionObject> occasions=new ArrayList<OccasionObject>();

	Statement stmt = connection.createStatement();
	try {
		
		ResultSet rs = stmt.executeQuery("select * from occasion");
		
		while(rs.next()) {
			
			int id=rs.getInt("ID");
			String name=rs.getString("Occasion");
			f = new OccasionObject();
			f.setId(id);
			f.setOccasion(name);
			
			occasions.add(f);
		
		} 
	}
	finally {
			stmt.close();
		}
		
	return occasions;
	
	}


public List<SizeObject> GetSize() throws SQLException{
	
	
	SizeObject s = null;
	List<SizeObject> sizes=new ArrayList<SizeObject>();

	Statement stmt = connection.createStatement();
	try {
		
		ResultSet rs = stmt.executeQuery("select * from cake_size");
		
		while(rs.next()) {
			
			int id=rs.getInt("Id");
			String name=rs.getString("Measure");
			s = new SizeObject();
			s.setId(id);
			s.setMeasure(name);
			
			sizes.add(s);
		
		} 
	}
	finally {
			stmt.close();
		}
		
	return sizes;
	
	}


public List<CakeObject> RetrieveCakeDetails() throws SQLException{
	
	
	CakeObject f = null;
	List<CakeObject> cakes=new ArrayList<CakeObject>();

	Statement stmt = connection.createStatement();
	try {
		
		ResultSet rs = stmt.executeQuery("select * from cake");
		
		while(rs.next()) {
			
			int id=rs.getInt("Id");
			String name=rs.getString("Name");
			String img=rs.getString("Image_path");
			int flavor=rs.getInt("Flavor_id");
			int price=rs.getInt("Price");
			int o_id=rs.getInt("Occasion_id");
			
			f=new CakeObject();
			f.setId(id);
			f.setName(name);
			f.setFlavorId(flavor);
			f.setOccasionId(o_id);
			f.setPrice(price);
			f.setImgPath(img);
			
			cakes.add(f);
		
		} 
	}
	finally {
			stmt.close();
		}
		
	return cakes;
	
	}


public List<CakeObject> retrieveCakesByFlavor(int fid) throws SQLException{
	
	
	CakeObject f = null;
	List<CakeObject> cakes=new ArrayList<CakeObject>();

	Statement stmt = connection.createStatement();
	try {
		
		ResultSet rs = stmt.executeQuery("select * from cake where Flavor_id='"+fid+"'");
		
		while(rs.next()) {
			
			int id=rs.getInt("Id");
			String name=rs.getString("Name");
			String img=rs.getString("Image_path");
			int flavor=rs.getInt("Flavor_id");
			int price=rs.getInt("Price");
			int o_id=rs.getInt("Occasion_id");
			
			f=new CakeObject();
			f.setId(id);
			f.setName(name);
			f.setFlavorId(flavor);
			f.setOccasionId(o_id);
			f.setPrice(price);
			f.setImgPath(img);
			
			cakes.add(f);
		
		} 
	}
	finally {
			stmt.close();
		}
		
	return cakes;
	
	}

public List<CakeObject> retrieveCakesByOccasion(int oid) throws SQLException{
	
	
	CakeObject f = null;
	List<CakeObject> cakes=new ArrayList<CakeObject>();

	Statement stmt = connection.createStatement();
	try {
		
		ResultSet rs = stmt.executeQuery("select * from cake where Occasion_id='"+oid+"'");
		
		while(rs.next()) {
			
			int id=rs.getInt("Id");
			String name=rs.getString("Name");
			String img=rs.getString("Image_path");
			int flavor=rs.getInt("Flavor_id");
			int price=rs.getInt("Price");
			int o_id=rs.getInt("Occasion_id");
			
			f=new CakeObject();
			f.setId(id);
			f.setName(name);
			f.setFlavorId(flavor);
			f.setOccasionId(o_id);
			f.setPrice(price);
			f.setImgPath(img);
			
			cakes.add(f);
		
		} 
	}
	finally {
			stmt.close();
		}
		
	return cakes;
	
	}


}

