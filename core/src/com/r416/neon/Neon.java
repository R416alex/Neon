package com.r416.neon;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.r416.neon.Screens.PlayScreen;

public class Neon extends Game {
	public SpriteBatch batch;
	public static final int G_WIDTH = 480, G_HEIGHT = 270;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new PlayScreen(this));
	}

	@Override
	public void render () {

		super.render();
	}
}
