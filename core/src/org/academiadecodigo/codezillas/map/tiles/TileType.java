package org.academiadecodigo.codezillas.map.tiles;

import com.badlogic.gdx.math.Rectangle;

import java.util.HashMap;

public enum TileType {
    BUILDING1(1, true, "Building_One", new Rectangle()),
    BUILDING2(2, true, "Building_Two", new Rectangle()),
    FLOOR(3, false, "Floor", new Rectangle());

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
