package zach.clientapi.clients;

import zach.clientapi.ServerConnection;

import java.net.Socket;

public class BaseClient implements Client {

    ServerConnection connection;

    public BaseClient(ServerConnection connection) {
        this.connection = connection;
    }

    public ServerConnection getConnection() {
        return connection;
    }

    public void startListener() {

    }

    public void listen() {

    }




}
