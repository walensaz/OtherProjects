
package src.com.Kingdom;

import java.io.*;
import java.net.*;

public class registerClient {

    private boolean bool;
    public boolean isRegistered() {
        return bool;
    }

    public registerClient(String username, String password, String email, int age, String country) {
        Socket client;
        PrintWriter pw;
        BufferedReader br;
        try {
            client = new Socket("96.9.252.47", 4555);

            pw = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
            br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            System.out.println("Connected....");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return;
        }

        try {
            bool = false;
            pw.println("Credentials");
            pw.println(username);
            pw.println(password);
            pw.println(email);
            pw.println(age);
            pw.println(country);
            pw.flush();

            if(br.readLine().equalsIgnoreCase("fail")) {
                FXLog.showError("User already exists");
                bool = true;
            } else if(br.readLine().equalsIgnoreCase("success")) {
                FXLog.showError("Successfully created account!");
                bool = false;
            } else if(br.readLine().equalsIgnoreCase("char")) {
                FXLog.showError("Illegal character");
                bool = true;

            } else if(br.readLine().equalsIgnoreCase("long")) {
                FXLog.showError("Username is either too short or too long");
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
