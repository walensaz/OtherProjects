package objects.worldobjects.Tiles;

import objects.worldobjects.Tile;

public class ResourceTile implements Tile {

    private int x;
    private int y;
    private int level;
    private int resources;
    private int type;

    public ResourceTile(int x, int y, int level, int resources, int type) {

        this.x = x;
        this.y = y;
        this.level = level;
        this.resources = resources;
    }

    public int getResources() {
        return resources;
    }

    public void setResources(int resources) {
        this.resources = resources;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }
}
