package KingdomServer.server;

import java.io.*;
import java.net.Socket;

import KingdomServer.server.actions.GameAction;
import KingdomServer.server.actions.GameActionFactory;

public class GameThread extends Thread implements Runnable
{
	
    Socket client;
    PrintWriter output;
    BufferedReader input;
    String inputLine, outputLine;
    String user;
    
    String perm;
    
    boolean logged = false;
    
    mysql sql = new mysql();

    public GameThread(Socket client, String user) {
        this.client = client;
        this.user = user;
        perm = sql.mySQLGetValue("select Rank from root_Accts.Users where Username = '" + user + "'", 1).toString();
    }


    public void run() {
        input = new BufferedReader(new InputStreamReader(client.getInputStream()));

        output = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
        while(LoginServer.notStopped) {
        	try {
               
            
        		inputLine = input.readLine();
            
               	GameAction action = GameActionFactory.getAction(inputLine,user);
               	action.execute();
               	
                input.close();
                output.close();
                client.close();
        	} catch(IOException e) {
        		e.printStackTrace();
            
        	}
    
    }
    }


}

    
    
    
    
    

