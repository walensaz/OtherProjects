package me.zach.exyleserver.threads;

import me.zach.exyleserver.objects.Tasks.GlobalTask;
import me.zach.exyleserver.objects.objects.Player;

import java.util.ArrayList;

public class MainGameThread implements Runnable {

    private static final ArrayList<GlobalTask> tasks = new ArrayList<>();
    private static final ArrayList<Player> onlinePlayers = new ArrayList<>();

    public static ArrayList<Player> getOnlinePlayers() {
        return onlinePlayers;
    }

    public static void onLogin(Player user) {
        onlinePlayers.add(user);
    }

    public static void addTaskToQueue(GlobalTask task) {
        tasks.add(task);
    }

    public static Player getUser(String username) {
        for (Player user : onlinePlayers) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void run() {
        if (tasks.size() > 0 && tasks.get(0) != null) {
            tasks.get(0).run();
            tasks.remove(0);
        }
        for (Player user : onlinePlayers) {
            if (!user.getSocket().isConnected()) {
                onlinePlayers.remove(user);
            }
        }
    }
}
