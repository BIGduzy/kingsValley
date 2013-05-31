package com.nick.kingsvalley1;



import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import Screens.PlayScreen;

public class KingsValley1 extends Game {
	//Fields
	private SpriteBatch batch;
	private PlayScreen play;
	private FPSLogger logger;

	//Properties

	public SpriteBatch getBatch() {
		return batch;
	}
	public void setBatch(SpriteBatch batch) {
		this.batch = batch;
	}


	@Override
	public void create() {
		this.play = new PlayScreen(this);
		this.batch = new SpriteBatch();
		this.setBatch(this.batch);
		this.setScreen(this.play);
		this.logger = new FPSLogger();
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor(0.06f, 0.06f, 0.06f, 1f);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		this.logger.log();
		for (int i = 0; i < 1000000; i++)
		{
			//double dummy = Math.pow(Math.PI, Math.PI);
		}
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}
}