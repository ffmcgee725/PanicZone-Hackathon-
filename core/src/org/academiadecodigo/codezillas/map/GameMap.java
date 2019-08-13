package org.academiadecodigo.codezillas.map;

import com.badlogic.gdx.graphics.OrthographicCamera;
import org.academiadecodigo.codezillas.map.tiles.TileType;

public interface GameMap {

    public void render(OrthographicCamera camera);

    public void update(float delta);

    public void dispose();

    public TileType getTileTypeByLocation(int layer, float x, float y);

    public TileType getTileTypeByCoordinate(int layer, int col, int row);

    public int getWidth();

    public int getHeight();

    public int getLayers();
}
