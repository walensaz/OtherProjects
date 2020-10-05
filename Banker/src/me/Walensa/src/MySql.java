package me.Walensa.src;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MySql {
	private MySql plugin = new MySql();
	
	
	static SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
	
	
	
	//Date method
    public Date newDate(String date) throws ParseException{
        java.util.Date newdate = format.parse(date);
        
        java.sql.Date sqlDate = new Date(newdate.getTime());
        return sqlDate;
    }
    
    
    
    
    
	
	//Create Account Method
    public void mySQLCreateAccount(String Name,String Username, String pin, Date AccountCreated, int AccountAge, Date AccountDOB, double AccountBalance) {
        try
        {
            
          // create our mysql database connection
            String myUrl = "jdbc:mysql://localhost:3306/javaaccounts";
            String username = "java";
            String password = "password";
          Connection conn = DriverManager.getConnection(myUrl, username, password);
          Calendar calendar = Calendar.getInstance();
          // our SQL SELECT query. 
          // if you only need a few columns, specify them by name instead of using "*"
          String query = "INSERT INTO accounts(AccountName,AccountUsername,AccountPin,AccountCreated,AccountAge,AccountDOB,AccountBalance)" +  " VALUES (?,?,?,?, ?, ?, ?)" ;
          String thedate = format.format(calendar.getTime());
          AccountCreated = plugin.newDate(thedate);
          System.out.println(AccountCreated);
          // create the java statement
          PreparedStatement statement = conn.prepareStatement(query);
          statement.setString(1, Name);
          statement.setString(2, Username);
          statement.setString(3, pin);
          statement.setDate(4, AccountCreated);
          statement.setInt(5, AccountAge);
          statement.setDate(6, AccountDOB);
          statement.setDouble(7, AccountBalance);
          // execute the query, and get a java resultset
          
          System.out.println("Success");
          // iterate through the java resultset
          statement.execute();
          conn.close();

        }
        catch (Exception e)
        {
          System.err.println("Got an exception! ");
          System.err.println(e.getMessage());
        }
    }
    
    
    
    
    
    
    
  //MySQL get a value
    public Object mySQLGetValue(String statement, int i) {
       Object sql = null;
        try
        {
        
        String myUrl = "jdbc:mysql://24.209.131.227:3306/javaaccounts";
        String username = "java";
        String password = "password";
      Connection conn = DriverManager.getConnection(myUrl, username, password);
      
      String query = statement;
      
      Statement st = conn.createStatement();
      
      ResultSet rs = st.executeQuery(query);
      
      while(rs.next()) {
          sql = rs.getObject(i);
          
        }
      
      
    } catch(Exception e) {
          System.out.println("Got an exception");
          System.out.println(e.getMessage());
        
    }
    return sql;
}
    

}
