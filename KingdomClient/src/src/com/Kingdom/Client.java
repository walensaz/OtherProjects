package src.com.Kingdom;

import java.io.*;
import java.net.*;

public class Client {

    private boolean bool = false;
    public boolean success() {
        return bool;
    }

    
    public Client(String username, String password) {
        while(FXLog.running) {

            Socket client;
            PrintWriter pw;
            BufferedReader br;

            try {
                client = new Socket("96.9.252.47", 4554);
                pw = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
                br = new BufferedReader(new InputStreamReader(client.getInputStream()));
                System.out.println("Connected....");
            } catch (IOException e) {
                System.out.println(e.getMessage());
                return;
            }

            try {

                pw.println("Check");
                pw.println(username);
                pw.println(password);
                pw.flush();

                if(br.readLine().equalsIgnoreCase("user")) {

                } else if(br.readLine().equalsIgnoreCase("pass")) {

                } else if(br.readLine().equalsIgnoreCase("success")) {
                    bool = true;

                }

                pw.close();
                br.close();
                client.close();

            } catch (UnknownHostException e) {
                System.err.println("Trying to connect to unknown host: " + e);
            } catch (IOException e) {
                System.err.println("IOException:  " + e);
            }
        }
    }

}

