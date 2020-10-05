package KingdomServer.server;

import java.io.*;
import java.net.Socket;
import java.util.Timer;

public class RegisterThread extends Thread implements Runnable {

    Socket client;
    PrintWriter output;
    BufferedReader input;
    String inputLine, outputLine;
    
    mysql sql = new mysql();

    public RegisterThread(Socket client, int id) {
        id++;
        this.client = client;
        System.out.println("Register id: " + id);
        RegisterServer.id = id;
    }


    public void run() {
        
        try {
            input = new BufferedReader(new InputStreamReader(client.getInputStream()));

            output = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
               
            
                if((inputLine = input.readLine()).equalsIgnoreCase("Credentials")) {
                    String username = input.readLine();
                    String password = input.readLine();
                    String email = input.readLine();
                    String age = input.readLine();
                    
                    
                    if(sql.mySQLGetValue("select Username from root_Accts.Users where Username = '" + username + "'", 1) != null) {
                        System.out.println("user already exists");
                        output.println("fail");
                        output.flush();
                        
                        
                    } else if((username.matches("^(?=.*[A-Z])(?=.*[0-9])[A-Z0-9]+$"))) {
                        System.out.println("Illegal characters");
                        output.println("char");
                        output.flush();
                        
                        
                    } else if(!(username.length() >= 3 && username.length() <= 21)) { 
                        System.out.println("Not long enough");
                        output.println("long");
                        output.flush();
                        
                    } else {
                        output.println("success");
                        output.flush();
                        System.out.println("----------New User---------");
                        System.out.println("Username: " + username);
                        System.out.println("Password: " + password);
                        System.out.println("Email: " + email);
                        System.out.println("Age: " + age);
                        System.out.println("----------------------------");
                        new myRegister(username, password, email, Integer.valueOf(age));
                        input.close();
                        output.close();
                        client.close();
                        
            
                    }
            }
        
            
                input.close();
                output.close();
                client.close();
                
                 
            
        } catch(IOException e) {
            
            
        }
    
    }


}
