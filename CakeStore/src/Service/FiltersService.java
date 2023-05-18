package Service;

import java.sql.SQLException;

import DAO.FiltersDAO;
import DAO.LoginDAO;
import Domain.FlavorObject;
import Domain.OccasionObject;
import Domain.SizeObject;
import Domain.UserObject;

public class FiltersService {
	
private FiltersDAO filterDAO; 
	
	public FiltersService() throws SQLException {
		
		filterDAO=new FiltersDAO();
		
	}
	public void insertFlavor(FlavorObject fo) throws SQLException {
		
		filterDAO.InsertFlavor(fo);
		
	}
	
	public void DeleteFlavor(int id) throws SQLException {
		
		filterDAO.DeleteFlavor(id);
		
	}

	public void DeleteOccasion(int id) throws SQLException {
		
		filterDAO.DeleteOccasion(id);
		
	}

	public void insertOccasion(OccasionObject o) throws SQLException {
	
		filterDAO.InsertOccasion(o);
	}
	
public void DeleteSize(int id) throws SQLException {
		
		filterDAO.DeleteSize(id);
		
	}

	public void insertSize(SizeObject s) throws SQLException {
	
		filterDAO.InsertSize(s);
	}
	
}
