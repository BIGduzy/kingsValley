package Screens;

import level.Level;
import gesturelistener.PlayerGestureListener;
import image.Image;
import inputprocessor.PlayerInputProcessor;
import Player.Player;

import com.nick.kingsvalley1.KingsValley1;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;



public class PlayScreen implements Screen{

	//Fields
	private KingsValley1 game;
	private Player player;
	private OrthographicCamera camera;
	private float ratio, zoom = 480f;
	private PlayerInputProcessor inputProcessor;
	private PlayerGestureListener gestureListener;
	private InputMultiplexer multiplexer;
	private Vector2 mousePointer;
	private Level level;

	//Properties
	public Player getPlayer()
	{
		return this.player;
	}
	public void setExplorer(Player player)
	{
		this.player = player;
	}

	public void setMousePointer(Vector2 mousePointer)
	{		
		this.mousePointer = mousePointer;
	}

	//Constructor
	public PlayScreen(KingsValley1 game)
	{
		this.game = game;
		camera = new OrthographicCamera();
		this.ratio = (float)Gdx.graphics.getWidth() / (float)Gdx.graphics.getHeight();
		camera.setToOrtho(true, this.ratio * this.zoom, this.zoom);
		camera.position.set(544f/2f, 480f/2f, 0f);
		camera.update();		

		this.player = new Player(this.game, new Vector2(0f,0f), 1f);
		//Inputprocessor zorgt voor alle inputdetectie
		//-----------------------------------------------------
		this.inputProcessor = new PlayerInputProcessor(this);
		//-----------------------------------------------------

		//Met een gestureListener kun je andere scherminput afvangen zoals de fling en de pinch
		//-----------------------------------------------------
		this.gestureListener = new PlayerGestureListener(this);
		//----------------------------------------------------

		//Met een multiplexer kun je zowel de inputprocessor als de gesturelistener gebruiken
		this.multiplexer = new InputMultiplexer();
		this.multiplexer.addProcessor(this.inputProcessor);
		this.multiplexer.addProcessor(new GestureDetector(this.gestureListener));

		//Voeg de multiplexer toe aan setInputProcessor
		Gdx.input.setInputProcessor(this.multiplexer);
	}

	@Override
	public void render(float delta) 
	{
		this.player.Update(delta);
		this.game.getBatch().setProjectionMatrix(camera.combined);
		this.game.getBatch().begin();
			this.level.Draw(delta);
			this.player.Draw(delta);
		this.game.getBatch().end();
	}

	@Override
	public void resize(int width, int height)
	{		
	}

	@Override
	public void show() 
	{		
		this.level = new Level(this.game, 0);
	}

	@Override
	public void hide() {		
	}

	@Override
	public void pause() {		
	}

	@Override
	public void resume() {		
	}

	@Override
	public void dispose() {		
	}

}