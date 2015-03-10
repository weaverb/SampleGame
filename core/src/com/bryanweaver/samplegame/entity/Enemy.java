package com.bryanweaver.samplegame.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.bryanweaver.samplegame.TextureManager;

/**
 * Created by Bryan on 3/9/2015.
 */
public class Enemy extends Entity {

    public Enemy(Vector2 position, Vector2 direction){
        super(TextureManager.ENEMY, position, direction);
    }

    @Override
    public void update() {
        position.add(direction);

        if(position.y <= -TextureManager.ENEMY.getHeight()){
            float x = MathUtils.random(0, Gdx.graphics.getWidth() - TextureManager.ENEMY.getWidth());
            position.set(x, Gdx.graphics.getHeight());
        }
    }
}
