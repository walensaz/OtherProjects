package me.zach.exyleserver.threads;

import me.zach.exyleserver.Utils;
import me.zach.exyleserver.objects.Logger;
import me.zach.exyleserver.objects.objects.Player;
import me.zach.exyleserver.packet.Packet;

import java.io.IOException;
import java.net.SocketException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class GameThread implements Runnable {

    private Player player;
    private Future<?> gameThread;

    public GameThread(Player player) {
        MainGameThread.onLogin(player);
        this.player = player;
        gameThread = Utils.playerThreads.scheduleAtFixedRate(this, 10, 10, TimeUnit.MILLISECONDS);
    }

    @Override
    public void run() {
        String incomingPacket = "";
        try {
            if ((incomingPacket = player.getInputStream().readLine()) != null) {
                Packet packet = Packet.packetDecoder(incomingPacket);
                if (packet != null) {
                    player.addPacketToQueue(packet);
                }
            }
        } catch (SocketException e) {
            Logger.log(player.getUsername() + " has disconnected from the server!");
            gameThread.cancel(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        player.processPackets();
    }
}
