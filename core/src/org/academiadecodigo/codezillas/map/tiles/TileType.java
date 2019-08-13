package org.academiadecodigo.codezillas.map.tiles;

import com.badlogic.gdx.math.Rectangle;

import java.util.HashMap;

public enum TileType {
    GRASS(1, true, "Grass",new Rectangle()),
    DIRT(2, true, "Dirt",new Rectangle()),
    SKY(3, true, "Sky",new Rectangle()),
    LAVA(4, false, "Lava", new Rectangle()),
    CLOUD(5, true, "Cloud",new Rectangle()),
    STONE(6, true, "Stone",new Rectangle());


    public static final int TILE_SIZE = 16;

    private int id;
    private boolean collidable;
    private String name;
    private Rectangle rectangle;

    private TileType(int id, boolean collidable, String name, Rectangle rectangle) {
        this.collidable = collidable;
        this.id = id;
        this.name = name;
        this.rectangle = rectangle;
    }

    public static int getTileSize() {
        return TILE_SIZE;
    }

    public int getId() {
        return id;
    }

    public boolean isCollidable() {
        return collidable;
    }

    public String getName() {
        return name;
    }

    private static HashMap<Integer, TileType> tileMap;

    static {
        tileMap = new HashMap<Integer, TileType>();
        for (TileType tileType : TileType.values()) {
            tileMap.put(tileType.getId(), tileType);
        }
    }

    public static TileType getTileTypeById(int id) {
        return tileMap.get(id);
    }
}
