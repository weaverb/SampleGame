package com.bryanweaver.samplegame.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.bryanweaver.samplegame.TextureManager;

/**
 * Created by Bryan on 3/9/2015.
 */
public class Projectile extends Entity {

    public Projectile(Vector2 position) {
        super(TextureManager.LASER, position, new Vector2(0, 5));
    }

    @Override
    public void update() {
        position.add(direction);
    }

    public boolean checkEnd(){
        return position.y >= Gdx.graphics.getHeight();
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(position.x, position.y,
                texture.getWidth(), texture.getHeight());
    }
}
