package org.academiadecodigo.codezillas.map.tiles;

import java.util.HashMap;

public enum TileType {
    GRASS(1, true, "Grass"),
    DIRT(2, true, "Dirt"),
    SKY(3, true, "Sky"),
    LAVA(4, false, "Lava"),
    CLOUD(5, true, "Cloud"),
    STONE(6, true, "Stone");


    public static final int TILE_SIZE = 16;

    private int id;
    private boolean collidable;
    private String name;

    private TileType(int id, boolean collidable, String name) {
        this.collidable = collidable;
        this.id = id;
        this.name = name;
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
