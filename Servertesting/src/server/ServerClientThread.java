package server;

import java.io.*;
import java.net.Socket;

public class ServerClientThread extends Thread implements Runnable {

    Socket client;
    PrintWriter output;
    BufferedReader input;
    String inputLine, outputLine;

    public ServerClientThread(Socket client, int id) {
        id++;
        this.client = client;
        System.out.print("Client: " + this.client.getInetAddress() + " id = " + id);
        MultiThreadServer.id = id;
    }


    public void run() {
        System.out.println("Update");
        try {
            input = new BufferedReader(new InputStreamReader(client.getInputStream()));

            output = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
               
            
            if((inputLine = input.readLine()).equalsIgnoreCase("Credentials")) {
                String username = input.readLine();
                String password = input.readLine();
                String email = input.readLine();
                String age = input.readLine();
                System.out.println(username + password + email + age);
                input.close();
                output.close();
                client.close();
            } else {
            
        inputLine = "";
        outputLine = "";
        while(!(inputLine).equalsIgnoreCase("End")) {
            inputLine = input.readLine();
            if(inputLine.equalsIgnoreCase("login")) {
                System.out.println(inputLine);
                System.out.println("Accepted");
                output.println("Accepted");
                output.flush();
                
            } else {
                System.out.println(inputLine);
                System.out.println("declined");
                output.println("Declined");
                output.flush();
            }
            
            
            }
        
            
                input.close();
                output.close();
                client.close();
                
            }     
            
        
        } catch (Exception e) {
            System.out.println(e.getMessage());

            return;
        }
    
    }


}
