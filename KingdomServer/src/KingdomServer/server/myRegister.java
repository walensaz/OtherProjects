package KingdomServer.server;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Calendar;

public class myRegister {
	
	
	public myRegister(String username, String password, String email, int age) {
	
	        try
	        {
	            
	          // create our mysql database connection
	            String url = "jdbc:mysql://96.9.252.47:3306/root_Accts";
	            String user = "root_IBJava";
	            String pass = "Platform893";
	          Connection conn = DriverManager.getConnection(url, user, pass);
	          
	          //
	          String state = "INSERT INTO Users(Username, Password, Email, Age, Balance, Rank)" +  " VALUES (?,?,?,?, ?, ?)" ;
	          // create the java statement
	          PreparedStatement statement = conn.prepareStatement(state);
	          statement.setString(1, username);
	          statement.setString(2, password);
	          statement.setString(3, email);
	          statement.setInt(4, age);
	          statement.setInt(5, 0);
	          statement.setInt(6, 0);
	          // execute the query, and get a java resultset
	          statement.execute();
	          
	          System.out.println("Success");
	          
	          // iterate through the java resultset
	          //statement.execute();
	          conn.close();

	        }
	        catch (Exception e)
	        {
	          System.err.println("Got an exception! ");
	          System.err.println(e.getMessage());
	        }
	    }
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	
	

}
