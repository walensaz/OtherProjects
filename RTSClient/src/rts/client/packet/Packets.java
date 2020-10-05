package rts.client.packet;



import rts.client.packet.packets.LoginPacket;
import rts.client.packet.packets.PrivateMessagePacket;
import rts.client.packet.packets.SendMessagePacket;

public enum Packets {


    LOGIN_PACKET(1, LoginPacket.class),
    SEND_MESSAGE_PACKET(2, SendMessagePacket.class),
    PRIVATE_MESSAGE_PACKET(3, PrivateMessagePacket.class);


    private int packetId;
    private Class packetClass;


    Packets(int packetId, Class packetClass) {
        this.packetId = packetId;
        this.packetClass = packetClass;
    }

    public int getPacketId() {
        return packetId;
    }

    public Class getPacketClass() {
        return packetClass;
    }
}
