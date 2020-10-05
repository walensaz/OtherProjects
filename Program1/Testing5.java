import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Testing5 {
	static String myUrl = "jdbc:mysql://localhost:3306/javaaccounts";
	static String username = "java";
	static String password = "password";
	
	public static void main(String[] args) {
		try
	    {
	      // create our mysql database connection
	      Connection conn = DriverManager.getConnection(myUrl, username, password);
	      
	      // our SQL SELECT query. 
	      // if you only need a few columns, specify them by name instead of using "*"
	      String query = "SELECT * FROM javaaccounts.accounts";

	      // create the java statement
	      Statement st = conn.createStatement();
	      
	      // execute the query, and get a java resultset
	      ResultSet rs = st.executeQuery(query);
	      
	      // iterate through the java resultset
	      while (rs.next())
	      {
	    	String name = rs.getString("AccountName");
	        int age = rs.getInt("AccountAge");
	        double Balance = rs.getDouble("AccountBalance");
	        Date DOB = rs.getDate("AccountDOB");
	        
	        // print the results
	        String x = String.format("%s, %s, %s, %s", name, age, DOB, Balance);
	        System.out.println(x);
	      }
	      st.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	    }
	

	}
}
