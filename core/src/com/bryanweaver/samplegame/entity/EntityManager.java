package com.bryanweaver.samplegame.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.bryanweaver.samplegame.MyGdxGame;
import com.bryanweaver.samplegame.TextureManager;
import com.bryanweaver.samplegame.screen.GameOverScreen;
import com.bryanweaver.samplegame.screen.ScreenManager;

/**
 * Created by Bryan on 3/9/2015.
 */
public class EntityManager {

    private final Array<Entity> entities = new Array<Entity>();
    private final Player player;

    public EntityManager(int amount) {
        int w = Gdx.graphics.getWidth();
        int h = Gdx.graphics.getHeight();
        player = new Player(new Vector2(w/2, 18), new Vector2(0, 0), this);

        for (int i = 0; i < amount; i++) {
            float x = MathUtils.random(0, w - TextureManager.ENEMY.getWidth());
            float y = MathUtils.random(h, h*3);
            float speed = MathUtils.random(2, 5);
            addEntity(new Enemy( new Vector2(x, y),  new Vector2(0, -speed)));
        }
    }

    public void update(){
        for (Entity e : entities) {
            e.update();
        }
        for (Projectile p : getProjectiles()){
            if(p.checkEnd()){
                entities.removeValue(p, false);
            }
        }

        player.update();
        checkCollisions();
    }

    public void render(SpriteBatch batch){
        for (Entity e : entities) {
            e.render(batch);
        }
        player.render(batch);
    }

    public void addEntity(Entity entity){
        entities.add(entity);
    }

    private void checkCollisions(){
        for (Enemy e : getEnemies()){
            for(Projectile p : getProjectiles()){
                if(e.getBounds().overlaps(p.getBounds())){
                    entities.removeValue(e, false);
                    entities.removeValue(p, false);
                    if(gameOver()){
                        ScreenManager.setScreen(new GameOverScreen(true));
                    }
                }
            }
            if(e.getBounds().overlaps(player.getBounds())){
                ScreenManager.setScreen(new GameOverScreen(false));
            }
        }
    }

    private Array<Enemy> getEnemies(){
        Array<Enemy> ret = new Array<Enemy>();
        for (Entity e : entities){
            if(e instanceof Enemy){
                ret.add((Enemy)e);
            }
        }
        return ret;
    }

    private Array<Projectile> getProjectiles(){
        Array<Projectile> ret = new Array<Projectile>();
        for (Entity e : entities){
            if(e instanceof Projectile){
                ret.add((Projectile)e);
            }
        }
        return ret;
    }

    public boolean gameOver(){
        return getEnemies().size <= 0;
    }

}
