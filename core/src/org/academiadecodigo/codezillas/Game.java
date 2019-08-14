package org.academiadecodigo.codezillas;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import org.academiadecodigo.codezillas.entities.Player;
import org.academiadecodigo.codezillas.entities.Police;
import org.academiadecodigo.codezillas.entities.PoliceFactory;
import org.academiadecodigo.codezillas.map.GameMap;
import org.academiadecodigo.codezillas.map.TiledGameMap;

import java.util.ArrayList;
import java.util.Iterator;

public class Game extends ApplicationAdapter {
    SpriteBatch batch;
    OrthographicCamera camera;
    Texture img;
    GameMap gameMap;
    private Player player = new Player();
    private Police police = new Police();
    private Array<Police> cops;
    private long dropRate;


    @Override
    public void create() {
        cops = new Array<>();
        batch = new SpriteBatch();
        player.create();
        police.create();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.update();
        gameMap = new TiledGameMap();
        player.setGameMap(gameMap);
        police.setGameMap(gameMap);


        /*if (TimeUtils.nanoTime() - dropRate > 1000000000) {
            cops.add(police);
            dropRate = TimeUtils.nanoTime();
        }*/


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

    public void createImage() {
        gameMap.render(camera);
        batch.begin();
        batch.draw(player.getImg(), player.getPlayerRect().getX(), player.getPlayerRect().getY());
        //batch.draw(police.getImg(), police.getPoliceRect().getX(), police.getPoliceRect().getY());

        spawnCops();

        moveCops();

        batch.end();
    }

    public void spawnCops() {

        for (Police cop : cops) {
            batch.draw(cop.getImg(), cop.getX(), cop.getY());
        }
    }

    public void moveCops() {
        for (Police cop : cops) {
            if (player.getPlayerRect().overlaps(cop.getPoliceRect())) {
                cop.getPoliceRect().set(100000, 1000000, 32, 32);
            }

            cop.moveDirection();
        }

    }


}
