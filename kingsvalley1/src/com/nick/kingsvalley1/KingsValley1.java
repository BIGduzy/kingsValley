package com.nick.kingsvalley1;



import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import Screens.PlayScreen;
import Screens.SplashScreen;

public class KingsValley1 extends Game {
	//Fields
	private SpriteBatch batch;
	private PlayScreen play;
	private SplashScreen splash;
	private FPSLogger logger;
	private Color BackgroundColor = new Color(0.125f, 0.125f, 0.957f, 1f);

	//Properties

	public SpriteBatch getBatch() {
		return batch;
	}
	public void setBatch(SpriteBatch batch) {
		this.batch = batch;
	}


	public Color getBackgroundColor() {
		return BackgroundColor;
	}
	public void setBackgroundColor(Color backgroundColor) {
		BackgroundColor = backgroundColor;
	}


	public PlayScreen getPlay() {
		return play;
	}
	public void setPlay(PlayScreen play) {
		this.play = play;
	}
	@Override
	public void create() {
		this.setPlay(new PlayScreen(this));
		this.splash = new SplashScreen(this);
		this.batch = new SpriteBatch();
		this.setBatch(this.batch);
		this.setScreen(this.splash);
		this.logger = new FPSLogger();
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor(this.BackgroundColor.r,
							this.BackgroundColor.g,
							this.BackgroundColor.b,
							this.BackgroundColor.a);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		//this.logger.log();
		for (int i = 0; i < 850000; i++)
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