package org.academiadecodigo.codezillas.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import org.academiadecodigo.codezillas.Game;
import org.academiadecodigo.codezillas.directions.Directions;
import org.academiadecodigo.codezillas.map.GameMap;

import java.util.PrimitiveIterator;

public class Bullets implements Entity {

    private Rectangle bulletRect;
    private float amount = 100;
    private Texture img;
    private Player player;
    private Array<Bullets> bulletsArray = new Array<>();
    private SpriteBatch batch;
    private Directions movingDirection;
    private Directions lastDirection = Directions.UP;
    private GameMap gameMap;

    private Vector2 pos;


    public void create() {
        img = new Texture("cop2.png");
        batch = new SpriteBatch();
        setPlayer(Game.getPlayer());

        bulletRect = new Rectangle();
        pos = new Vector2(bulletRect.x, bulletRect.y);
        bulletRect.x = player.getPlayerRect().x;
        bulletRect.y = player.getPlayerRect().y;
        bulletRect.height = img.getHeight();
        bulletRect.width = img.getWidth();

    }





    @Override
    public void moveX(float amount) {

        if (player.getLastDirection() == Directions.RIGHT) {
            bulletRect.x += amount * Gdx.graphics.getDeltaTime();
        }

        if (player.getLastDirection() == Directions.LEFT) {
            bulletRect.x -= amount * Gdx.graphics.getDeltaTime();
        }

    }

    public void setBulletRect(Rectangle bulletRect) {

        this.bulletRect = bulletRect;
    }

    @Override
    public void moveY(float amount) {

        if (player.getLastDirection() == Directions.UP) {
            bulletRect.y += amount * Gdx.graphics.getDeltaTime();
        }

        if (player.getLastDirection() == Directions.DOWN) {
            bulletRect.y -= amount * Gdx.graphics.getDeltaTime();
        }
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public Array<Bullets> getBulletsArray() {
        return bulletsArray;
    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(img, pos.x, pos.y);
    }

    @Override
    public Vector2 getPos() {
        return pos;
    }

    @Override
    public float getX() {
        return bulletRect.x;
    }

    @Override
    public float getY() {
        return bulletRect.y;
    }

    @Override
    public EntityType getType() {
        return EntityType.BULLETS;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    public Texture getImg() {
        return img;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setGameMap(GameMap gameMap) {
        this.gameMap = gameMap;
    }
}
