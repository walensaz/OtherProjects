package Run;

import connection.LoginConnection;
import handlers.LoginHandler;
import objects.Player;
import objects.playerobjects.Building;
import threads.UpgradeThread;

import java.util.ArrayList;

public class Main {

    public static int newestkingdom = 1;

    public static ArrayList<Building> upgrading;

    public static ArrayList<Player> connected;
    public static int id = 0;

    public static void main(String[] args) throws Exception {
        upgrading = new ArrayList<>();
        Player myplayer = LoginHandler.getPlayer(null,null, "zachdabest");
        Player secplayer = LoginHandler.getPlayer(null, null, "Zaachary");
        myplayer.setPower(100000);
        myplayer.getCastle().upgrade(Building.FARM.getId());
        System.out.println(myplayer);
        System.out.println(secplayer);
        new Thread(new UpgradeThread()).start();
        /*
        connected = new ArrayList<>();
        new Thread(new LoginConnection()).start();
        */
        Thread.sleep(3000);
        System.out.println(myplayer);
        System.out.println(System.currentTimeMillis());
    }

}
