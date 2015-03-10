package com.bryanweaver.samplegame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Bryan on 3/9/2015.
 */
public class TextureManager {

    public static Texture PLAYER = new Texture(Gdx.files.internal("player.png"));
    public static Texture LASER = new Texture(Gdx.files.internal("playerlaserbeam.png"));
    public static Texture ENEMY = new Texture(Gdx.files.internal("basicenemy.png"));
    public static Texture WON = new Texture(Gdx.files.internal("gamewon.png"));
    public static Texture LOST = new Texture(Gdx.files.internal("gameover.png"));
}
