package org.academiadecodigo.codezillas.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import org.academiadecodigo.codezillas.directions.Directions;
import org.academiadecodigo.codezillas.map.GameMap;

public class Player implements Entity {
    private float amount = 100;
    private Rectangle playerRect;
    private Texture img;
    private SpriteBatch batch;
    private GameMap gameMap;
    private TextureRegion[] regions = new TextureRegion[2];
    private Directions lastDirection = Directions.UP;
    private Bullets bullets = new Bullets();

    private Vector2 pos;

    public Player() {
    }

    public GameMap getGameMap() {
        return gameMap;
    }

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

    public void shoot() {

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && lastDirection == Directions.RIGHT) {
            bullets.create();
            bullets.moveX(100);
            System.out.println(bullets.getX());


        }

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && lastDirection == Directions.LEFT) {
            bullets.create();
            bullets.moveX(100);
            System.out.println(bullets.getX());


        }

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && lastDirection == Directions.UP) {
            bullets.create();
            bullets.moveY(100);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && lastDirection == Directions.DOWN) {
            bullets.create();
            bullets.moveY(100);


        }
    }

    @Override
    public void moveY(float amount) {

        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            if (!gameMap.doesRectCollideWithMap(playerRect.getX(), playerRect.getY(), (int) playerRect.getWidth(), (int) playerRect.getHeight())) {

                playerRect.y += amount * Gdx.graphics.getDeltaTime();
                lastDirection = Directions.UP;
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            if (!gameMap.doesRectCollideWithMap(playerRect.getX(), playerRect.getY(), (int) playerRect.getWidth(), (int) playerRect.getHeight())) {

                playerRect.y -= amount * Gdx.graphics.getDeltaTime();
                lastDirection = Directions.DOWN;
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            if (gameMap.doesRectCollideWithMap(playerRect.getX(), playerRect.getY(), (int) playerRect.getWidth(), (int) playerRect.getHeight())) {

                playerRect.y -= 5;
                lastDirection = Directions.UP;
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            if (gameMap.doesRectCollideWithMap(playerRect.getX(), playerRect.getY(), (int) playerRect.getWidth(), (int) playerRect.getHeight())) {

                playerRect.y += 5;
                lastDirection = Directions.DOWN;
            }
        }
    }

    @Override
    public void moveX(float amount) {

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            if (!gameMap.doesRectCollideWithMap(playerRect.getX(), playerRect.getY(), (int) playerRect.getWidth(), (int) playerRect.getHeight())) {

                playerRect.x -= amount * Gdx.graphics.getDeltaTime();
                lastDirection = Directions.LEFT;
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            if (!gameMap.doesRectCollideWithMap(playerRect.getX(), playerRect.getY(), (int) playerRect.getWidth(), (int) playerRect.getHeight())) {

                playerRect.x += amount * Gdx.graphics.getDeltaTime();
                lastDirection = Directions.RIGHT;
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            if (gameMap.doesRectCollideWithMap(playerRect.getX(), playerRect.getY(), (int) playerRect.getWidth(), (int) playerRect.getHeight())) {

                playerRect.x += 5;
                lastDirection = Directions.LEFT;
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            if (gameMap.doesRectCollideWithMap(playerRect.getX(), playerRect.getY(), (int) playerRect.getWidth(), (int) playerRect.getHeight())) {

                playerRect.x -= 5;
                lastDirection = Directions.RIGHT;
            }
        }
    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void render(SpriteBatch bacth) {
        batch.draw(img, pos.x, pos.y);
        bullets.render(bullets.getBatch());
    }

    @Override
    public Vector2 getPos() {
        return pos;
    }

    @Override
    public float getX() {
        return pos.x;
    }

    @Override
    public float getY() {
        return pos.y;
    }

    @Override
    public EntityType getType() {
        return EntityType.PLAYER;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    public Directions getLastDirection() {
        return lastDirection;
    }

    public void create() {
        img = new Texture("cop2.png");

        playerRect = new Rectangle();
        playerRect.x = 200;
        playerRect.y = 200;
        pos = new Vector2(playerRect.x, playerRect.y);
        playerRect.height = img.getHeight();
        playerRect.width = img.getWidth();
        bullets.create();

    }

    public void playerMove() {
        moveY(getAmount());
        moveX(getAmount());
    }
}
