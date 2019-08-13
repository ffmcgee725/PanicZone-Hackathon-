package org.academiadecodigo.codezillas.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import org.academiadecodigo.codezillas.directions.Directions;
import org.academiadecodigo.codezillas.map.GameMap;

public class Police implements Entity {
    private float amount = 150;
    private Rectangle policeRect;
    private Texture img;
    private GameMap gameMap;
    private Directions lastDirection = Directions.RIGHT;
    private Directions movingDirection;

    public void create() {
        img = new Texture("police_32.png");

        policeRect = new Rectangle();
        policeRect.x = 500;
        policeRect.y = 500;
        policeRect.height = img.getHeight();
        policeRect.width = img.getWidth();
    }

    public Rectangle getPoliceRect() {
        return policeRect;
    }

    public Texture getImg() {
        return img;
    }

    public float getAmount() {
        return amount;
    }

    @Override
    public void moveX(float amount) {

        double rng = Math.random();

        if (rng <= 0.9) {
            movingDirection = lastDirection;
        }

        if (rng > 0.91 && rng <= 0.925) {
            movingDirection = Directions.UP;
        }

        if (rng > 0.926 && rng <= 0.95) {
            movingDirection = Directions.DOWN;
        }

        if (rng > 0.951 && rng <= 0.975) {
            movingDirection = Directions.LEFT;
        }

        if (rng > 0.976 && rng <= 1.0) {
            movingDirection = Directions.RIGHT;
        }

        switch (movingDirection) {
            case UP:
                policeRect.y += amount * Gdx.graphics.getDeltaTime();
                lastDirection = Directions.UP;
                break;
            case DOWN:
                policeRect.y -= amount * Gdx.graphics.getDeltaTime();
                lastDirection = Directions.DOWN;
                break;
            case LEFT:
                policeRect.x -= amount * Gdx.graphics.getDeltaTime();
                lastDirection = Directions.LEFT;
                break;
            case RIGHT:
                policeRect.x += amount * Gdx.graphics.getDeltaTime();
                lastDirection = Directions.RIGHT;
                break;
            default:
                policeRect.y += amount * Gdx.graphics.getDeltaTime();
                lastDirection = Directions.UP;
        }


//
//        if (rng <= 0.6) {
//            policeRect.x -= amount * Gdx.graphics.getDeltaTime();
//
//        }
//
//        if (rng > 0.6 && rng <= 0.7) {
//            policeRect.y += amount * Gdx.graphics.getDeltaTime();
//            lastDirection = Directions.UP;
//        }
//
//        if (rng > 0.7 && rng <= 0.8) {
//            policeRect.y -= amount * Gdx.graphics.getDeltaTime();
//            lastDirection = Directions.DOWN;
//        }
//
//        if (rng > 0.8 && rng <= 0.9) {
//            policeRect.x -= amount * Gdx.graphics.getDeltaTime();
//            lastDirection = Directions.LEFT;
//        }
//
//        if (rng > 0.9 && rng <= 1.0) {
//            policeRect.x += amount * Gdx.graphics.getDeltaTime();
//            lastDirection = Directions.RIGHT;
//        }


    }

    @Override
    public void moveY(float amount) {

    }

    public void moveDirection(float amount) {
        double rng1 = Math.random();


    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void render(SpriteBatch batch) {

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
        return EntityType.POLICE;
    }

    @Override
    public int getWidth() {
        return getType().getWeith();
    }

    @Override
    public int getHeight() {
        return getType().getHeight();
    }

    public boolean colision() {
        if (policeRect.x < 0) {
            policeRect.x = 0;
            return true;
        }

        if (policeRect.x > 576) {
            policeRect.x = 576;
            return true;
        }

        if (policeRect.y < 0) {
            policeRect.y = 0;
            return true;
        }

        if (policeRect.y > 576) {
            policeRect.y = 576;
            return true;
        }
        return false;
    }
}
