package com.bryanweaver.samplegame.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bryanweaver.samplegame.TextureManager;

/**
 * Created by Bryan on 3/9/2015.
 */
public class GameOverScreen extends Screen {

    private Texture texture;
    public GameOverScreen(boolean won) {
        if(won){
            texture = TextureManager.WON;
        }else {
            texture = TextureManager.LOST;
        }
    }

    @Override
    public void create() {

    }

    @Override
    public void update() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(texture, Gdx.graphics.getWidth() / 2 - texture.getWidth()/2,
                Gdx.graphics.getHeight()/2 - texture.getHeight()/2);
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
