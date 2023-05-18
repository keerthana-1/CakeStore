package DAO;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbDAO {
	
	
	 private Connection connection;
	 
	 
	 public DbDAO() throws SQLException {
		 DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		    
		    String  user  = "akeerthi" ;
		    String  password ="akeerthi";
		   
		   String connStr =  "jdbc:oracle:thin:@localhost:1521:dbs3";
		  
		    connection = DriverManager.getConnection (connStr, user, password);
		  }
	 
	 
		// package protection: no need to call this from service layer
		Connection getConnection() {
			return connection;
		}
		
		
		
		public void close() throws SQLException {
			connection.close();  // this object opened it, so it gets to close it
		}


	 
	 


}
