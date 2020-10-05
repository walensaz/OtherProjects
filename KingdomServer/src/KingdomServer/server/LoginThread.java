package KingdomServer.server;

import java.io.*;
import java.net.Socket;

public class LoginThread extends Thread implements Runnable {

    Socket client;
    PrintWriter output;
    BufferedReader input;
    String inputLine, outputLine;
    
    boolean logged = false;
    
    mysql sql = new mysql();

    public LoginThread(Socket client, int id) {
        id++;
        this.client = client;
        System.out.print("Login id: " + id);
        LoginServer.id = id;
    }


    public void run() {
        
        try {
            input = new BufferedReader(new InputStreamReader(client.getInputStream()));

            output = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
               
            
                if((inputLine = input.readLine()).equalsIgnoreCase("Login")) {
                    String username = input.readLine();
                    String password = input.readLine();
                    
                    
                    if(sql.mySQLGetValue("select Username from root_Accts.Users where Username = '" + username + "'", 1) == null) {
                        System.out.println("No user by the username : " + username);
                        output.println("user");
                        output.flush();
                        
                        
                    } else if(!(sql.mySQLGetValue("select Password from root_Accts.Users where Username = '" + username + "'", 1).equals(password))) {
                        System.out.println("Wrong password for user " + username);
                        output.println("pass");
                        output.flush();
                        
                        
                    
                        
                    } else {
                    	Main.online++;
                    	logged = true;
                        output.println("success");
                        output.flush();
                        System.out.println("----------New Login---------");
                        System.out.println("Username: " + username);
                        System.out.println("Password: " + password);
                        System.out.println("----------------------------");
                        new Thread(new GameThread(client, username)).start();;
                        input.close();
                        output.close();
                        client.close();   
                        
            
                    }
            }
                input.close();
                output.close();
                client.close();
        } catch(IOException e) {
            e.printStackTrace();
            
        }
    
    }


}
