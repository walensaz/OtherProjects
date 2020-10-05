package objects.serializablepackets;

import java.io.Serializable;

public class Client implements Serializable{


    private static final long serialVersionUID = 5837462938485224L;
    private String username;

    public Client(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {this.username = username;}

    @Override
    public String toString() {
        return "objects.serializablepackets.Client{" +
                "username='" + username + '\'' +
                '}';
    }
}
