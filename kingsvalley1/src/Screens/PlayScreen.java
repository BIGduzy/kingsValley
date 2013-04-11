package Screens;

import image.Image;
import inputprocessor.PlayerInputProcessor;
import Player.Player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.nick.kingsvalley1.KingsValley1;

public class PlayScreen implements Screen{
	
	//Fields
		private KingsValley1 game;
		private Player player;
		private Image arrow_right, arrow_left;
		private OrthographicCamera camera;
		private PlayerInputProcessor inputProcessor;
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
			//Inputprocessor zorgt voor alle inputdetectie
			//-----------------------------------------------------
			this.inputProcessor = new PlayerInputProcessor(this);
			Gdx.input.setInputProcessor(this.inputProcessor);
			//-----------------------------------------------------
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
			boolean isAndroid = true;
			if (isAndroid )
			{
				w = w/2f;
				h = h/2f;
			}

			camera = new OrthographicCamera();
			camera.setToOrtho(false, w, h);
			camera.position.set(0f, 0f, 0f);
			camera.update();
			Gdx.app.log("show", "Ik wordt een keer aangeroepen");
			Gdx.app.log("schermbreedte", Float.toString(Gdx.graphics.getWidth()));
			Gdx.app.log("schermgroote", Float.toString(Gdx.graphics.getHeight()));
			this.player = new Player(this.game, new Vector2(100f,0f), 1f);
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
