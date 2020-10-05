package zach.clientapi;

import java.io.*;
import java.net.Socket;

public class ServerConnection {

    private InputStream reader;
    private OutputStream writer;

    private Socket socket;

    public ServerConnection(Socket socket) throws IOException {
        this.socket = socket;
        this.reader = socket.getInputStream();
        this.writer = socket.getOutputStream();
    }

    public void sendMessage(String message) {
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(this.writer));
        writer.println(message);
        writer.flush();
    }

    public String readLine() throws IOException {
        if(!this.socket.isClosed()) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(this.reader));
            return reader.readLine();
        } else {
            return null;
        }
    }

    public InputStream getReader() {
        return reader;
    }

    public OutputStream getWriter() {
        return writer;
    }

    public Socket getSocket() {
        return socket;
    }

    public void terminate() {
        try {
            this.getSocket().close();
            Logger.log("Terminated connection!");
        } catch(IOException e) {
            Logger.log("Could not terminate connection!", LoggerLevel.INFO);
        }
    }

}
