package Service;

import java.sql.SQLException;

import DAO.*;

public class DeleteCakeService {
	
public void deleteCake(int id){
		
		
		try {
			DeletecakeDAO dao = new DeletecakeDAO();
 
             dao.DeleteCake(id);
 
        } catch (SQLException e) {
            e.printStackTrace();
           
        }

	}

}
