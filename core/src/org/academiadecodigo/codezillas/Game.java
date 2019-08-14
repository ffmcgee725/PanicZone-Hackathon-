package org.academiadecodigo.codezillas;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.codezillas.entities.Bullets;
import org.academiadecodigo.codezillas.entities.Player;
import org.academiadecodigo.codezillas.entities.Police;
import org.academiadecodigo.codezillas.map.GameMap;
import org.academiadecodigo.codezillas.map.TiledGameMap;

public class Game extends ApplicationAdapter {
    private static Player player = new Player();
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private static GameMap gameMap;
    private Police police = new Police();
    private Bullets bullets = new Bullets();
    private Music music;
    private Sound sound;

    public static Player getPlayer() {
        return player;
    }

    public static GameMap getGameMap() {
        return gameMap;
    }

    @Override
    public void create() {
        batch = new SpriteBatch();
        player.create();
        police.create();
        bullets.create();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.update();
        gameMap = new TiledGameMap();
        player.setGameMap(gameMap);
        police.setGameMap(gameMap);
        bullets.setGameMap(gameMap);

        sound = Gdx.audio.newSound(Gdx.files.internal("FTP.mp3"));
        music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
        music.setLooping(true);
        music.play();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        createImage();
        player.playerMove();
        player.shoot();
        police.moveDirection();

        if (player.getPlayerRect().overlaps(police.getPoliceRect())) {
            police.getPoliceRect().set(police.getPoliceRect()).set(100000, 1000000, 32, 32);
            music.stop();
            sound.play();

        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        player.getImg();
        bullets.getImg();
        police.getImg();
    }

    public void createImage() {
        gameMap.render(camera);
        batch.begin();
        batch.draw(player.getImg(), player.getPlayerRect().getX(), player.getPlayerRect().getY());
        batch.draw(police.getImg(), police.getPoliceRect().getX(), police.getPoliceRect().getY());
        batch.draw(bullets.getImg(), player.getPlayerRect().getX(), player.getPlayerRect().getY());
        batch.end();
    }


}
