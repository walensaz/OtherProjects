package KingdomServer.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class RegisterServer {
	public static int id = 0;
	public static boolean notStopped;
	
    public static void registerServer()  {
    	

    	
    	ServerSocket serversocket;
        notStopped = true;

        try {
            serversocket = new ServerSocket(4555);
            new Thread(new LoginServer()).start();
            System.out.println("Listening on port 4555");
        } catch (IOException e) {
            System.out.println(e.getMessage());

            return;
        }


        Socket client;


        while(notStopped) {
            try {
                client = serversocket.accept();
            } catch (IOException e){
                System.out.println(e.getMessage());
                try {
					serversocket.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
                return;
            }

            new Thread(new RegisterThread(client, id)).start();
            
        }
        
        try {
			serversocket.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

    }
}



