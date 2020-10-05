package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class MultiThreadServer {
	public static int id = 0;
	
    public static void main(String[] args)  {


    	
        ServerSocket serversocket;


        try {
            serversocket = new ServerSocket(4445);
            System.out.println("Connected....");
        } catch (IOException e) {
            System.out.println(e.getMessage());

            return;
        }


        Socket client;


        while(true) {
            try {
                client = serversocket.accept();
                System.out.println("Started");
            } catch (IOException e){
                System.out.println(e.getMessage());
                try {
					serversocket.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
                return;
            }

            new Thread(new ServerClientThread(client, id)).start();
            
        }
        


    }
}



