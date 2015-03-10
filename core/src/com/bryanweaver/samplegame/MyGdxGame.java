package com.bryanweaver.samplegame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bryanweaver.samplegame.screen.GameScreen;
import com.bryanweaver.samplegame.screen.ScreenManager;

public class MyGdxGame extends ApplicationAdapter {

    private SpriteBatch batch;
    private static int WIDTH, HEIGHT;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
        WIDTH = Gdx.graphics.getWidth();
        HEIGHT = Gdx.graphics.getHeight();
        ScreenManager.setScreen(new GameScreen());
	}

    @Override
    public void dispose(){
        if(ScreenManager.getCurrentScreen() != null){
            ScreenManager.getCurrentScreen().dispose();
        }
        batch.dispose();
    }

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if(ScreenManager.getCurrentScreen() != null){
            ScreenManager.getCurrentScreen().update();
            ScreenManager.getCurrentScreen().render(batch);
        }
	}

    @Override
    public void resize(int width, int height) {
        if(ScreenManager.getCurrentScreen() != null){
            ScreenManager.getCurrentScreen().resize(width, height);
        }
    }

    @Override
    public void pause() {
        if(ScreenManager.getCurrentScreen() != null){
            ScreenManager.getCurrentScreen().pause();
        }
    }

    @Override
    public void resume() {
        if(ScreenManager.getCurrentScreen() != null){
            ScreenManager.getCurrentScreen().resume();
        }
    }
}
