package me.zach.exyleserver;

import me.zach.exyleserver.listeners.SocketListener;
import me.zach.exyleserver.threads.MainGameThread;
import me.zach.main.Server;

import java.io.OutputStream;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Launch {

    public static final ScheduledExecutorService gameThreads = Executors.newScheduledThreadPool(10);

    public static void main(String[] args) {
        Server s = new Server(Config.PORT);
        gameThreads.scheduleAtFixedRate(new MainGameThread(), 10, Config.UPDATE_RATE, TimeUnit.MILLISECONDS);
        gameThreads.scheduleAtFixedRate(new SocketListener(s), 10, 100, TimeUnit.MILLISECONDS);
    }


}
