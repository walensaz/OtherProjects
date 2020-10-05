package KingdomServer.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class LoginServer extends Thread implements Runnable{
	public static int id = 0;
	public static boolean notStopped;
	ServerSocket serversocket;

	public LoginServer() {
		
        try {
            serversocket = new ServerSocket(4554);
            System.out.println("Listening on port 4554");
            notStopped = true;
        } catch (IOException e) {
            System.out.println(e.getMessage());

            return;
        }


		
	}
	
	
	
	
	public void run() {
        Socket client;

        try {
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

            new Thread(new LoginThread(client, id)).start();
            
        }
        
        try {
			serversocket.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
        } catch(Exception e) {
        	e.printStackTrace();
        }

    }
		
	}
