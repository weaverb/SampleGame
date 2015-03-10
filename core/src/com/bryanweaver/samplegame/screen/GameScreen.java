package com.bryanweaver.samplegame.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bryanweaver.samplegame.entity.EntityManager;

/**
 * Created by Bryan on 3/9/2015.
 */
public class GameScreen extends Screen {

    private EntityManager entityManager;

    @Override
    public void create() {
        entityManager = new EntityManager(10);
    }

    @Override
    public void update() {
        entityManager.update();
    }

    @Override
    public void dispose() {

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        entityManager.render(sb);
        sb.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }
}
