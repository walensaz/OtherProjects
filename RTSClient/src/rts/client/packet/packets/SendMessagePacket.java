package rts.client.packet.packets;


import rts.client.packet.Packet;
import rts.client.packet.Packets;

public class SendMessagePacket implements Packet {


    //private Player user;
    private String sender;
    private String message;

    public SendMessagePacket() {
    }

    public SendMessagePacket(String sender, String message) {
        this.sender = sender;
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public String getMessage() {
        return message;
    }

    /*@Override
    public boolean process(Player user) {
        MainGameThread.addTaskToQueue(new SendMessageTask(this.sender, this.message));
        return true;
    }*/

    @Override
    public String encode() {
        return Packets.SEND_MESSAGE_PACKET.getPacketId() + ":" + sender + ":" + message;
    }

    @Override
    public Packet decode(String[] contents) {
        if (contents.length > 3) {
            String message = contents[2];
            for (int i = 2; i < contents.length; i++) {
                message += ":" + contents[i];
            }
            return new SendMessagePacket(contents[1], message);
        }
        return new SendMessagePacket(contents[1], contents[2]);
    }

    @Override
    public int getID() {
        return 0;
    }
}
