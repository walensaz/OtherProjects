package objects;

import objects.worldobjects.Tile;
import objects.worldobjects.Tiles.Throne;
import objects.worldobjects.Tiles.WoodTile;

import java.io.Serializable;
import java.util.Random;

public class Kingdom implements Serializable {

    private static final long serialVersionUID = -942038562193532152L;

    private int kingdomnum;
    private Tile[][] map;

    public Kingdom(int kingdomnum) {
        this.kingdomnum = kingdomnum;
        this.map = new Tile[700][1000];
        createMap();
    }

    private void createMap() {
        this.map[350][500] = new Throne(350,500, false, false, null);
        Random random = new Random();
        for(int i = 0; i < 1000; i++) {
            for(int k = 0; k < 1000; k++) {
                if((random.nextInt(1000) < 200)) {
                    int spawn = random.nextInt();
                    if(spawn == 1) {
                        map[i][k];
                    }
                }
            }
        }


    }

    private boolean inForest(int x, int y) {
        return ((x > 325 && y > 475) && (x < 375 && y < 525));
    }

    private int getKingdomLevel(int x, int y) {
        if(inForest(x, y)) {
            return 6;
        } else if((x > 250 && y > 375) && (x < 400 && y < 625)) {
            return 5;
        } else if((x > 200 && y > 300) && (x < 550 && y < 700)) {
            return 4;
        } else if((x > 150 && y > 225) && (x < 600 && y < 750)) {
            return 3;
        } else if((x > 100 && y > 175) && (x < 700 && y < 850)) {
            return 2;
        } else {
            return 1;
        }
    }





}
