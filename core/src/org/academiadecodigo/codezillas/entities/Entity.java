package org.academiadecodigo.codezillas.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public interface Entity {

    Vector2 pos = null;

    EntityType type = null;

    float velocity = 0;

    GameMap2 map = null;

    void moveX (float amount);

    void moveY (float amount);

    public void update(float deltaTime);

    public void render (SpriteBatch bacth);

    public Vector2 getPos();

    public float getX();

    public float getY();

    public EntityType getType();

    public int getWidth();

    public int getHeight();


}
