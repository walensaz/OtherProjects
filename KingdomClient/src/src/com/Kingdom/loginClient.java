package src.com.Kingdom;

import java.io.*;
import java.net.*;

public class loginClient {

    private boolean bool = false;
    public boolean success() {
        return bool;
    }

    public loginClient(String username, String password) {

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

            pw.println("Login");
            pw.println(username);
            pw.println(password);
            pw.flush();

            if(br.readLine().equalsIgnoreCase("user")) {
                FXLog.showError("No user by that username!");

            } else if(br.readLine().equalsIgnoreCase("pass")) {
                FXLog.showError("Incorrect password!");

            } else if(br.readLine().equalsIgnoreCase("success")) {
                bool = true;
                //Start.uId = br.readLine();

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

