package Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import DAO.AddCakeDAO;
import Domain.*;
import Domain.FlavorObject;
import Domain.OccasionObject;

public class AddCakeService {
	
	public List<FlavorObject> getFlavors(){
		
		List<FlavorObject> flavors=new ArrayList<>();
		try {
			AddCakeDAO dao = new AddCakeDAO();
 
             flavors = dao.GetFlavor();
 
        } catch (SQLException e) {
            e.printStackTrace();
           
        }
		return flavors;
	}
	
public List<OccasionObject> getOccasions(){
		
		List<OccasionObject> occasion=new ArrayList<>();
		try {
			AddCakeDAO dao = new AddCakeDAO();
			occasion = dao.GetOccasion();
 
        } catch (SQLException e) {
            e.printStackTrace();
           
        }
		return occasion;
	}


public List<SizeObject> getSizes(){
	
	List<SizeObject> size=new ArrayList<>();
	try {
		AddCakeDAO dao = new AddCakeDAO();
		size = dao.GetSize();

    } catch (SQLException e) {
        e.printStackTrace();
       
    }
	return size;
}

public void storeCakeDetails(CakeObject cake){
	
	try {
		
		AddCakeDAO dao = new AddCakeDAO();
		dao.InsertCakeDetails(cake);

    } catch (SQLException e) {
        e.printStackTrace();
       
    }
	
}

public List<CakeObject> getCakeDetails(){
	
	List<CakeObject> cakes=new ArrayList<>();
	
	try {
		
		AddCakeDAO dao = new AddCakeDAO();
		cakes=dao.RetrieveCakeDetails();

    } catch (SQLException e) {
        e.printStackTrace();
       
    }
	
	return cakes;
	
}

public List<CakeObject> getCakeDetailsByFlavor(int fid){
	
	List<CakeObject> cakes=new ArrayList<>();
	
	try {
		
		AddCakeDAO dao = new AddCakeDAO();
		cakes=dao.retrieveCakesByFlavor(fid);

    } catch (SQLException e) {
        e.printStackTrace();
       
    }
	
	return cakes;
	
}

public List<CakeObject> getCakeDetailsByOccasion(int oid){
	
	List<CakeObject> cakes=new ArrayList<>();
	
	try {
		
		AddCakeDAO dao = new AddCakeDAO();
		cakes=dao.retrieveCakesByOccasion(oid);

    } catch (SQLException e) {
        e.printStackTrace();
       
    }
	
	return cakes;
	
}

}
