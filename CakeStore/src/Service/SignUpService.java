package Service;

import java.sql.SQLException;

import DAO.SignUpDAO;
import Domain.UserObject;

public class SignUpService {
	
private SignUpDAO signupDAO; 
	
	public SignUpService() throws SQLException {
		
		signupDAO=new SignUpDAO();
		
	}
	
	
	public void insertUserData(UserObject user) throws SQLException {
	
		signupDAO.InsertUserDetails(user);

		
	}	

}
