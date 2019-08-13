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
    private SpriteBatch batch;
    private Player player = new Player();

    @Override
    public void create() {
        batch = new SpriteBatch();
        player.create();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        createImage();
        player.playerMove();
    }

    @Override
    public void dispose() {
        batch.dispose();
        player.getImg();
    }

    public void createImage(){
        batch.begin();
        batch.draw(player.getImg(),player.getPlayerRect().getX(),player.getPlayerRect().getY());
        batch.end();
    }


}
