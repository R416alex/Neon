package com.r416.neon.Sprites;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.r416.neon.Neon;

import static com.r416.neon.Neon.G_HEIGHT;
import static com.r416.neon.Neon.G_WIDTH;

public class Player {
    public float posx = 0;
    public float posy = 0;
    private Sprite sprite;
    private Texture tex;
    private TextureRegion current;
    private Viewport port;
    private Neon game;
    private ShapeRenderer sr;

    public Player(Viewport port, Neon g){
        game = g;
        this.port = port;
        tex = new Texture("First Character.png");
        current = new TextureRegion(tex, 0,0, 32, 48);
        sprite = new Sprite(current);
        sr = new ShapeRenderer();
    }
    public void update(){
        sprite.setX(port.getWorldWidth()- (float)((G_WIDTH/2) - (current.getRegionWidth() / 2)));
        sprite.setY(port.getWorldHeight() - (float)((G_HEIGHT/2) - (current.getRegionHeight() / 2)));
    }
    public void render(float delta, Batch batch){
        sr.begin(ShapeRenderer.ShapeType.Line);
        sr.setColor(new Color(0,0,1,0));
        //sr.rect((port.getScreenX() * sprite.getWidth()), (port.getScreenY() * sprite.getHeight()), sprite.getWidth(), sprite.getHeight());

        sr.end();
        sprite.draw(batch);
    }
}
