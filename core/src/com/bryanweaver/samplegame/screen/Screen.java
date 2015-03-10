package com.bryanweaver.samplegame.screen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Bryan on 3/9/2015.
 */
public abstract class Screen {

    public abstract void create();
    public abstract void update();
    public abstract void dispose();
    public abstract void render(SpriteBatch sb);
    public abstract void resize(int width, int height);
    public abstract void pause();
    public abstract void resume();

}
