package me.zach.exyleserver.packet.packets;

import me.zach.exyleserver.objects.Tasks.SendPrivateMessageTask;
import me.zach.exyleserver.objects.User;
import me.zach.exyleserver.objects.objects.Player;
import me.zach.exyleserver.packet.Packet;
import me.zach.exyleserver.packet.Packets;
import me.zach.exyleserver.threads.MainGameThread;

public class PrivateMessagePacket implements Packet {


    private String sender;
    private String message;
    private String receiver;
    public PrivateMessagePacket() {
    }

    public PrivateMessagePacket(String sender, String message, String receiver) {
        this.sender = sender;
        this.message = message;
        this.receiver = receiver;
    }

    public String getSender() {
        return sender;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean process(Player user) {
        MainGameThread.addTaskToQueue(new SendPrivateMessageTask(this.sender, this.message, this.receiver));
        return true;
    }

    @Override
    public String encode() {
        return Packets.PRIVATE_MESSAGE_PACKET.getPacketId() + ":" + sender + ":" + receiver + ":" + message;
    }

    @Override
    public Packet decode(String[] contents) {
        if (contents.length > 4) {
            String message = contents[3];
            for (int i = 3; i < contents.length; i++) {
                message += ":" + contents[i];
            }
            return new PrivateMessagePacket(contents[1], message, contents[2]);
        }
        return new PrivateMessagePacket(contents[1], contents[3], contents[2]);
    }

    @Override
    public int getID() {
        return 0;
    }
}
