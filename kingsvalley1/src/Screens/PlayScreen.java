package Screens;

import gesturelistener.PlayerGestureListener;
import image.Image;
import inputprocessor.PlayerInputProcessor;
import Player.Player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.nick.kingsvalley1.KingsValley1;

public class PlayScreen implements Screen{

	//Fields
	private KingsValley1 game;
	private Player player;
	private Image arrow_right, arrow_left;
	private OrthographicCamera camera;
	private PlayerInputProcessor inputProcessor;
	private PlayerGestureListener gestureListener;
	private InputMultiplexer multiplexer;
	private Vector2 mousePointer;

	//Properties
	public Player getPlayer()
	{
		return this.player;
	}
	public void setPlayer(Player player)
	{
		this.player = player;
	}
	public Image getArrowRight()
	{
		return this.arrow_right;
	}
	public void setMousePointer(Vector2 mousePointer)
	{		
		this.mousePointer = mousePointer;
	}

	//Constructor
	public PlayScreen(KingsValley1 game)
	{
		this.game = game;
		this.player = new Player(this.game, new Vector2(100f,0f), 1f);
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
	public void render(float delta) {
		this.player.Update(delta);
		this.game.getBatch().setProjectionMatrix(camera.combined);
		this.game.getBatch().begin();
			this.player.Draw(delta);
			this.arrow_right.Draw(delta);
			this.arrow_left.Draw(delta);
		this.game.getBatch().end();
	}

	@Override
	public void resize(int width, int height)
	{		
	}

	@Override
	public void show() {		

		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		if (w == 1280 )
		{
			w = w/2f;
			h = h/2f;
		}

		camera = new OrthographicCamera();
		camera.setToOrtho(false, w, h);
		camera.position.set(0f, 0f, 0f);
		camera.update();
		Gdx.app.log("schermbreedte", Float.toString(Gdx.graphics.getWidth()));
		Gdx.app.log("schermhoogt", Float.toString(Gdx.graphics.getHeight()));
		this.arrow_right = new Image(this.game,
									 new Vector2(w/2f - 64, -h/2f),
									 "data/arrows/Arrow-Right.png");
		this.arrow_left = new Image(this.game, 
									new Vector2(-w/2f, -h/2f),
									"data/arrows/Arrow-Left.png");
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
