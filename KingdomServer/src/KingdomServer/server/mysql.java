package KingdomServer.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class mysql {

	
	

	
	
    //MySQL get a value
	
	
    public Object mySQLGetValue(String statement, int i) {
       Object sql = null;
        try
        {
        
            String url = "jdbc:mysql://96.9.252.47:3306/root_Accts";
            String user = "root_IBJava";
            String pass = "Platform893";
      Connection conn = DriverManager.getConnection(url, user, pass);
      
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
