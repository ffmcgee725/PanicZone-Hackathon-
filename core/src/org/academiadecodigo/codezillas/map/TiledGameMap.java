package org.academiadecodigo.codezillas.map;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import org.academiadecodigo.codezillas.map.tiles.TileType;

public class TiledGameMap implements GameMap {

    private TiledMap tiledMap;
    private OrthogonalTiledMapRenderer tiledMapRenderer;

    public TiledGameMap() {
        tiledMap = new TmxMapLoader().load("testingTiledMap.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
    }


    @Override
    public void render(OrthographicCamera camera) {
        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void dispose() {
        tiledMap.dispose();
    }

    @Override
    public TileType getTileTypeByLocation(int layer, float x, float y) {
        return getTileTypeByCoordinate(layer, (int) (x / TileType.TILE_SIZE), (int) (y / TileType.TILE_SIZE));
    }

    @Override
    public TileType getTileTypeByCoordinate(int layer, int col, int row) {
        TiledMapTileLayer.Cell cell = ((TiledMapTileLayer) tiledMap.getLayers().get(layer)).getCell(col, row);

        if (cell != null) {
            TiledMapTile tile = cell.getTile();

            if (tile != null) {
                int id = tile.getId();
                return TileType.getTileTypeById(id);
            }
        }
        return null;
    }

    @Override
    public boolean doesRectCollideWithMap(float x, float y, int width, int height) {
        if (x < 0 || y < 0 || x + width > getPixelWidth() || y + height > getPixelHeight()) {
            return true;
        }

        for (int row = (int) (y / TileType.TILE_SIZE); row < Math.ceil((y + height) / TileType.TILE_SIZE); row++) {
            for (int col = (int) (x / TileType.TILE_SIZE); col < Math.ceil((x + width) / TileType.TILE_SIZE); col++) {
                for (int layer = 0; layer < getLayers(); layer++) {
                    TileType tileType = getTileTypeByCoordinate(layer, col, row);
                    if (tileType != null && tileType.isCollidable()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    @Override
    public int getWidth() {
        return ((TiledMapTileLayer) tiledMap.getLayers().get(0)).getWidth();
    }

    @Override
    public int getHeight() {
        return ((TiledMapTileLayer) tiledMap.getLayers().get(0)).getHeight();
    }

    @Override
    public int getLayers() {
        return tiledMap.getLayers().getCount();
    }

    public int getPixelWidth() {
        return getWidth() * TileType.TILE_SIZE;
    }

    public int getPixelHeight() {
        return getHeight() * TileType.TILE_SIZE;
    }

}
