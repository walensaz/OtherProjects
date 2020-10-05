package me.zach.exyleserver.handlers;

import me.zach.exyleserver.objects.objects.Player;
import me.zach.exyleserver.objects.Logger;
import me.zach.exyleserver.packet.Packet;

import java.io.IOException;

public class PacketHandler implements Runnable {

    private Player player;
    private String incomingPacket;

    public PacketHandler(Player player) {
        this.incomingPacket = "";
        Logger.log("Enabling Packer Handler");
        this.player = player;
    }

    @Override
    public void run() {
        while(player.getSocket().isConnected()) {
            try {
                if ((incomingPacket = player.getInputStream().readLine()) != null) {
                    Packet packet = Packet.packetDecoder(incomingPacket);
                    if(packet != null) {
                        player.addPacketToQueue(packet);
                    }
                }
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}