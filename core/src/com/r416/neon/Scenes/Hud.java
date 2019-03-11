package com.r416.neon.Scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.r416.neon.Neon;

public class Hud {
    public Stage stage;
    private Viewport viewPort;

    private int worldTimer;


    Label countdownLable;

    public Hud(Batch sb){
        worldTimer = 300;

        viewPort = new FitViewport(Neon.G_WIDTH, Neon.G_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewPort, sb);

        Table table = new Table();
        table.top();
        table.setFillParent(true);

        countdownLable = new Label(String.format("%03d", worldTimer), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        table.add(countdownLable).expandX();
        stage.addActor(table);
    }
}
