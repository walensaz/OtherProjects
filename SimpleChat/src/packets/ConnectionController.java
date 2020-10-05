package packets;

import objects.serializablepackets.Client;

import java.net.Socket;

public class ConnectionController {

    public static boolean login(String username) throws Exception {
        Client client = new Client(username);
        Connection connection = new Connection(client, new Socket("0.0.0.0", 4554));
        connection.connect();
        return true;
    }


}
