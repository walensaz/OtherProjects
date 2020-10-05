package packets;

import objects.serializablepackets.Client;

import java.io.*;
import java.net.Socket;

public class Connection {

    private Client client;
    private Socket connection;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private boolean isConnected;

    public Connection(Client client, Socket socket) throws IOException {
        this.client = client;
        connection = socket;
        output = new ObjectOutputStream(connection.getOutputStream());
        output.flush();
        input = new ObjectInputStream(connection.getInputStream());
    }

    private boolean login() throws Exception {
        output.writeObject(client);
        output.flush();
        Object temp;
        if ((temp = input.readObject()) instanceof Client) {
            if(((Client)temp).getUsername().equalsIgnoreCase(client.getUsername())) {
                isConnected = true;
                System.out.println("Connected...");
                return true;
            }
        }
        System.out.println("Not connected");
        return false;
    }

    public void connect() throws Exception {
        if (login()) {
            System.out.println("Worked");
        }
    }
}
