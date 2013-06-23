package Screens;

import image.Image;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.nick.kingsvalley1.KingsValley1;

public class SplashScreen implements Screen
{
	//Fields
	private KingsValley1 game;
	private OrthographicCamera camera;
	private float ratio, zoom = 480f;
	private TextureRegion msxRegion, konamiRegion,
						  transparantRegion, kingsValleyRegion,
						  konami1985Region, pushRegion,
						  playStartRegion;	
	private Texture texture;
	private Image msxImage, konamiImage,
				  konami1985Image, pushImage,
				  playStartImage;
	private float timer, timerPlayStart;
	private boolean showKonami1985Image = false, showPushImage = false,
					showImagePlayStart = false;

	//Properties

	//Constructor
	public SplashScreen(KingsValley1 game)
	{
		this.game = game;
		camera = new OrthographicCamera();
		this.ratio = (float)Gdx.graphics.getWidth() / (float)Gdx.graphics.getHeight();
		camera.setToOrtho(true, this.ratio * this.zoom, this.zoom);
		camera.position.set(544f/2f, 480f/2f, 0f);
		camera.update();
	}

	@Override
	public void render(float delta) 
	{
		if (this.msxImage.getPosition().y > this.camera.position.y/2)
		{
			this.msxImage.getPosition().add(0f, -2f);
		}
		else
		{
			this.timer += delta;
			if ( this.timer < 2)
			{

			}
			else if (this.timer < 3)
			{
				this.msxRegion.setRegion(this.transparantRegion);
			}
			else if (this.timer < 4)
			{
				this.msxRegion.setRegion(this.konamiRegion);
				this.msxImage.getPosition().set(this.camera.position.x - this.konamiRegion.getRegionWidth()/2,
												this.camera.position.y - this.konamiRegion.getRegionHeight()/2 + 300);
				this.timer = 4f;
			}
			else if (this.timer < 100)
			{
				this.msxRegion.setRegion(this.kingsValleyRegion);
				this.msxImage.getPosition().set(this.camera.position.x - this.kingsValleyRegion.getRegionWidth()/2,
												this.camera.position.y/2);
				this.showKonami1985Image = true;
				this.showPushImage = true;
				this.game.getBackgroundColor().set(0f, 0f, 0f, 1f);
				if (Gdx.input.isKeyPressed(Keys.SPACE) || Gdx.input.isTouched())
				{
					this.timer = 100;
				}
			}
			else if (this.timer < 102)
			{
				this.showKonami1985Image = true;
				this.showPushImage = false;
				if ( this.timerPlayStart < 4)
				{
					this.timerPlayStart += delta * 40;
				}
				else
				{
					this.showImagePlayStart = !this.showImagePlayStart;
					this.timerPlayStart = 0;
				}
			}
			else
			{
				this.game.setScreen(this.game.getPlay());
			}

		}



		this.game.getBatch().setProjectionMatrix(camera.combined);
		this.game.getBatch().begin();
			this.msxImage.Draw(delta);
			if (this.showKonami1985Image)
			{
				this.konami1985Image.Draw(delta);
			}
			if (this.showPushImage)
			{
				this.pushImage.Draw(delta);
			}
			if (this.showImagePlayStart)
			{
				this.playStartImage.Draw(delta);
			}
		this.game.getBatch().end();
	}

	@Override
	public void resize(int width, int height)
	{		
	}

	@Override
	public void show() 
	{		
		this.texture = new Texture(Gdx.files.internal("data/SpriteSheet.png"));
		this.msxRegion = new TextureRegion(this.texture, 22, 164, 406, 204);
		this.konamiRegion = new TextureRegion(this.texture, 182, 377, 200, 80);
		this.transparantRegion = new TextureRegion(this.texture, 0, 0, 0, 0);
		this.kingsValleyRegion = new TextureRegion(this.texture, 148, 0, 300, 111);
		this.konami1985Region = new TextureRegion(this.texture, 148, 112, 197, 23);
		this.pushRegion = new TextureRegion(this.texture, 148, 136, 224, 20);
		this.playStartRegion = new TextureRegion(this.texture, 349, 113, 160, 20);
		this.msxRegion.flip(false, true);
		this.konamiRegion.flip(false, true);
		this.kingsValleyRegion.flip(false, true);
		this.konami1985Region.flip(false, true);
		this.pushRegion.flip(false, true);
		this.playStartRegion.flip(false, true);
		this.msxImage = new Image(this.game,
								  new Vector2(this.camera.position.x - this.msxRegion.getRegionWidth()/2,
										      this.camera.position.y - this.msxRegion.getRegionHeight()/2 + 300), 
								  this.msxRegion);
		this.konamiImage = new Image(this.game,
				  				new Vector2(this.camera.position.x - this.konamiRegion.getRegionWidth()/2,
				  							this.camera.position.y - this.konamiRegion.getRegionHeight()/2 + 300), 
				  				this.konamiRegion);
		this.konami1985Image = new Image(this.game,
  				new Vector2(this.camera.position.x - this.konami1985Region.getRegionWidth()/2,
  							this.camera.position.y + 0), 
  				this.konami1985Region);
		this.pushImage = new Image(this.game,
  				new Vector2(this.camera.position.x - this.pushRegion.getRegionWidth()/2,
  							this.camera.position.y + 50), 
  				this.pushRegion);
		this.playStartImage = new Image(this.game,
  				new Vector2(this.camera.position.x - this.playStartRegion.getRegionWidth()/2,
  							this.camera.position.y + 50), 
  				this.playStartRegion);


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