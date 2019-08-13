package org.academiadecodigo.codezillas.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import org.academiadecodigo.codezillas.map.GameMap;
import org.academiadecodigo.codezillas.map.tiles.TileType;

public class Player implements Entity {
    private float amount = 100;
    private Rectangle playerRect;
    private Texture img;
    private SpriteBatch batch;
    private GameMap gameMap;
    private TextureRegion[] regions = new TextureRegion[2];


    public void setGameMap(GameMap gameMap) {
        this.gameMap = gameMap;
    }

    public float getAmount() {
        return this.amount;
    }

    public Texture getImg() {
        return img;
    }

    public Rectangle getPlayerRect() {
        return playerRect;
    }

    @Override
    public void moveY(float amount) {

        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            if (!gameMap.doesRectCollideWithMap(playerRect.getX(), playerRect.getY(), (int) playerRect.getWidth(), (int) playerRect.getHeight())) {


                playerRect.y += amount * Gdx.graphics.getDeltaTime();
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            if (!gameMap.doesRectCollideWithMap(playerRect.getX(), playerRect.getY(), (int) playerRect.getWidth(), (int) playerRect.getHeight())) {
                playerRect.y -= amount * Gdx.graphics.getDeltaTime();
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            if (gameMap.doesRectCollideWithMap(playerRect.getX(), playerRect.getY(), (int) playerRect.getWidth(), (int) playerRect.getHeight())) {
                playerRect.y -= 5;
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            if (gameMap.doesRectCollideWithMap(playerRect.getX(), playerRect.getY(), (int) playerRect.getWidth(), (int) playerRect.getHeight())) {
                playerRect.y += 5;
            }
        }


    }

    @Override
    public void moveX(float amount) {


        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            if (!gameMap.doesRectCollideWithMap(playerRect.getX(), playerRect.getY(), (int) playerRect.getWidth(), (int) playerRect.getHeight())) {
                playerRect.x -= amount * Gdx.graphics.getDeltaTime();
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            if (!gameMap.doesRectCollideWithMap(playerRect.getX(), playerRect.getY(), (int) playerRect.getWidth(), (int) playerRect.getHeight())) {
                playerRect.x += amount * Gdx.graphics.getDeltaTime();
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            if (gameMap.doesRectCollideWithMap(playerRect.getX(), playerRect.getY(), (int) playerRect.getWidth(), (int) playerRect.getHeight())) {
                playerRect.x += 5;
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            if (gameMap.doesRectCollideWithMap(playerRect.getX(), playerRect.getY(), (int) playerRect.getWidth(), (int) playerRect.getHeight())) {
                playerRect.x -= 5;
            }
        }

    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void render(SpriteBatch bacth) {

    }

    @Override
    public Vector2 getPos() {
        return null;
    }

    @Override
    public float getX() {
        return 0;
    }

    @Override
    public float getY() {
        return 0;
    }

    @Override
    public EntityType getType() {
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

    public void create() {
        img = new Texture("cop2.png");

        playerRect = new Rectangle();
        playerRect.x = 250;
        playerRect.y = 240;
        playerRect.height = img.getHeight();
        playerRect.width = img.getWidth();
    }

    public void playerMove() {
        moveY(getAmount());
        moveX(getAmount());
    }

}
