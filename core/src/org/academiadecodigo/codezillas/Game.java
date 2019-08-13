package org.academiadecodigo.codezillas;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import org.academiadecodigo.codezillas.entities.EntityType;
import org.academiadecodigo.codezillas.entities.Player;


public class Game extends ApplicationAdapter {
    SpriteBatch batch;
    Texture img;
    private Rectangle playerRect;

    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture("police3.png");

        playerRect = new Rectangle();
        playerRect.x = 0;
        playerRect.y = 0;
        playerRect.height = img.getHeight();
        playerRect.width = img.getWidth();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        createImage();
        userInput();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }

    public void createImage(){
        batch.begin();
        batch.draw(img,playerRect.x,playerRect.y);
        batch.end();
    }


    public void userInput(){
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            playerRect.x -= 400 * Gdx.graphics.getDeltaTime();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            playerRect.x += 400 * Gdx.graphics.getDeltaTime();
        }

        if (playerRect.x < 0) {
            playerRect.x = 0;
        }

        if (playerRect.x > 576) {
            playerRect.x = 576;
        }
    }

}
