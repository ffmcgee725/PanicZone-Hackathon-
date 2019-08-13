package org.academiadecodigo.codezillas.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.FileTextureData;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player implements Entity {
    private float amount = 100;
    private Rectangle playerRect;
    private Texture img;
    private SpriteBatch batch;



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

        if (Gdx.input.isKeyPressed(Input.Keys.UP)){
            playerRect.y += amount * Gdx.graphics.getDeltaTime();
            /*batch.draw(new Texture("police2.png"), playerRect.getX(), playerRect.getY());
            batch.draw(new Texture("police3.png"), playerRect.getX(), playerRect.getY());
            batch.draw(new Texture("police4.png"), playerRect.getX(), playerRect.getY());
            batch.draw(new Texture("police5.png"), playerRect.getX(), playerRect.getY());
            batch.draw(new Texture("police6.png"), playerRect.getX(), playerRect.getY());*/
        }

        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            playerRect.y -= amount * Gdx.graphics.getDeltaTime();
        }

    }

    @Override
    public void moveX(float amount) {

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            playerRect.x -= amount * Gdx.graphics.getDeltaTime();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            playerRect.x += amount * Gdx.graphics.getDeltaTime();
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

    public void create(){
        img = new Texture("police1.png");

        playerRect = new Rectangle();
        playerRect.x = 0;
        playerRect.y = 0;
        playerRect.height = img.getHeight();
        playerRect.width = img.getWidth();
    }

    public void colision(){
        if (playerRect.x < 0) {
            playerRect.x = 0;
        }

        if (playerRect.x > 576) {
            playerRect.x = 576;
        }

        if (playerRect.y < 0){
            playerRect.y = 0;
        }

        if (playerRect.y > 576){
            playerRect.y = 576;
        }
    }

    public void playerMove(){
        colision();
        moveY(getAmount());
        moveX(getAmount());
    }

}
