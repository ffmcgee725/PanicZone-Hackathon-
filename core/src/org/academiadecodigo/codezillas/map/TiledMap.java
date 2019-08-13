package org.academiadecodigo.codezillas.map;

import com.badlogic.gdx.graphics.OrthographicCamera;
import org.academiadecodigo.codezillas.map.tiles.TileType;

public class TiledMap implements GameMap {

    @Override
    public void render(OrthographicCamera camera) {

    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void dispose() {

    }

    @Override
    public TileType getTileTypeByLocation(int layer, float x, float y) {
        return getTileTypeByCoordinate(layer, (int) (x/TileType.TILE_SIZE), (int) (y/TileType.TILE_SIZE));
    }

    @Override
    public TileType getTileTypeByCoordinate(int layer, int col, int row) {
        return null;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public int getLayers() {
        return 0;
    }
}
