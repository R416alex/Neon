package com.r416.neon.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.BatchTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import com.r416.neon.Neon;
import com.r416.neon.Scenes.Hud;
import com.r416.neon.Sprites.Player;

import static com.r416.neon.Neon.G_HEIGHT;
import static com.r416.neon.Neon.G_WIDTH;

public class PlayScreen implements Screen {
    private Neon game;
    private OrthographicCamera gameCam;
    private Viewport gamePort;
    private Hud hud;
    private Player player;
    private TmxMapLoader mapLoader;
    private TiledMap map;
    private TiledMapRenderer r;
   // private SpriteBatch batch;

    public PlayScreen(Neon game){
        this.game = game;

        gameCam = new OrthographicCamera();
        gamePort = new FitViewport(G_WIDTH, G_HEIGHT, gameCam);
        player = new Player(gamePort, game);
      //  batch = new SpriteBatch();
        hud = new Hud(game.batch);
        map = new TmxMapLoader().load("ProjectNeon.tmx");
        r = new OrthogonalTiledMapRenderer(map);
        gameCam.position.set(gamePort.getWorldWidth()/2, gamePort.getWorldHeight()/2, 0);
    }
    @Override
    public void show() {

    }

    private void handleInput(float dt){
        if(Gdx.input.isKeyPressed(Input.Keys.W)){
            gameCam.translate(0, 100 * dt);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            gameCam.translate(-100 * dt, 0);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S)){
            gameCam.translate(0, -100 * dt);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            gameCam.translate(100 * dt, 0);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
            Gdx.app.exit();
        }
    }
    private void update(float dt){
        handleInput(dt);
        gameCam.update();
        player.update();
        r.setView(gameCam);
    }

    @Override
    public void render(float delta) {
        this.update(delta);
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        r.render();

        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        game.batch.begin();
        player. render(delta, game.batch);
        game.batch.end();
        hud.stage.draw();


    }

    @Override
    public void resize(int width, int height) {
        gamePort.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
    map.dispose();
    }
}
