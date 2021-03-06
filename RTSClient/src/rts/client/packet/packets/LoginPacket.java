package rts.client.packet.packets;


import rts.client.Logger;
import rts.client.LoggerLevel;
import rts.client.packet.Packet;
import rts.client.packet.Packets;

public class LoginPacket implements Packet {

    private String username;
    private String password;
    private boolean success;
    private String ip;

    public LoginPacket() {
    }

    public LoginPacket(String username, String password, boolean success, String ip) {
        this.username = username;
        this.password = password;
        this.success = success;
        this.ip = ip;
    }

/*    @Override
    public boolean process(Player user) {
        if (success) {
            success = false;
            Logger.log("Packet has been tampered with, [Username:" + username + "] [IP: " + ip + "]", LoggerLevel.SEVERE);
            return false;
        }
        if (username.length() > 1) {
            Logger.log(username + " has successfully logged in to the server with the ip " + ip);
            success = true;
            return true;
        }
        success = false;
        return false;
    }*/

    @Override
    public int getID() {
        return Packets.LOGIN_PACKET.getPacketId();
    }

    @Override
    public String encode() {
        return Packets.LOGIN_PACKET.getPacketId() + ":" + username + ":" + password + ":" + success;
    }

    @Override
    public Packet decode(String[] contents) {
        if (Integer.valueOf(contents[0]) == Packets.LOGIN_PACKET.getPacketId()) {
            return new LoginPacket(contents[1], contents[2], Boolean.valueOf(contents[3]), contents[4]);
        }
        return null;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isSuccess() {
        return success;
    }
}
