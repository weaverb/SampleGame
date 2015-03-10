package com.bryanweaver.samplegame.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.bryanweaver.samplegame.TextureManager;

/**
 * Created by Bryan on 3/9/2015.
 */
public class Player extends Entity {

    private final EntityManager entityManager;
    private long lastFire;

    private enum PlayerDirection{
        Left,
        Right,
        None
    }

    public Player(Vector2 position, Vector2 direction, EntityManager entityManager){
        super(TextureManager.PLAYER, position, direction);
        this.entityManager = entityManager;
    }

    @Override
    public void update() {
        position.add(direction);

        PlayerDirection directionToMove = PlayerDirection.None;

        if(Gdx.input.isTouched()){
           Vector2 touch = new Vector2(Gdx.input.getX(), Gdx.input.getY());
            if(touch.x > position.x + texture.getWidth()){
                directionToMove = PlayerDirection.Right;
            }else if (touch.x < position.x){
                directionToMove = PlayerDirection.Left;
            }else{
                directionToMove = PlayerDirection.None;
            }

        }

        if(directionToMove == PlayerDirection.Left){
            setDirection(-300, 0);
        }else if(directionToMove == PlayerDirection.Right){
            setDirection(300, 0);
        }else{
            setDirection(0,0);
        }

        if(System.currentTimeMillis() - lastFire >= 350){
            entityManager.addEntity(new Projectile(position.cpy().add(TextureManager.PLAYER.getWidth()/2, TextureManager.PLAYER.getHeight())));
            lastFire = System.currentTimeMillis();
        }
    }
}
