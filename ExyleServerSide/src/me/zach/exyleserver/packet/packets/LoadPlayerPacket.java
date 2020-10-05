package me.zach.exyleserver.packet.packets;

import me.zach.exyleserver.objects.Logger;
import me.zach.exyleserver.objects.User;
import me.zach.exyleserver.objects.objects.Player;
import me.zach.exyleserver.packet.Packet;
import me.zach.exyleserver.packet.Packets;

public class LoadPlayerPacket implements Packet {

    private int playerID;
    private Player player;

    public LoadPlayerPacket(int playerID) {
        this.playerID = playerID;
    }

    public LoadPlayerPacket(Player player) {
        this.player = player;
    }

    @Override
    public String encode() {
        return "";
    }

    @Override
    public Packet decode(String[] contents) throws ArrayIndexOutOfBoundsException {
        return null;
    }

    @Override
    public boolean process(Player player) {
        return false;
    }

    @Override
    public int getID() {
        return Packets.LOAD_PLAYER_PACKET.getPacketId();
    }
}
