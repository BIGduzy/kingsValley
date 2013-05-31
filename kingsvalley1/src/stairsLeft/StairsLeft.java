package stairsLeft;

import java.util.ArrayList;

import level.Level;

import stairsRight.StepRight;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.nick.kingsvalley1.KingsValley1;



public class StairsLeft 
{
	//Fields
	private KingsValley1 game;
	private Vector2 position;
	private int amountOfSteps;
	private ArrayList<StepLeft> stairs;
	private Rectangle collisionRectBottom;

	//properties
		public Rectangle getCollisionRectBottom() {
			return collisionRectBottom;
		}

		public void setCollisionRectBottom(Rectangle collisionRectBottom) {
			this.collisionRectBottom = collisionRectBottom;
		}
	
	//Constructor
	public StairsLeft(KingsValley1 game, Vector2 position, int amountOfSteps,
					   TextureRegion trapLeft01, TextureRegion trapLeft02,
					   TextureRegion trapTopLeft02)
	{
		this.game = game;
		this.position = position.add(new Vector2(amountOfSteps * 16, amountOfSteps * 16));
		this.amountOfSteps = amountOfSteps;
		this.stairs = new ArrayList<StepLeft>();
		this.LoadContent(trapLeft01, trapLeft02, trapTopLeft02);
	}

	//Laad alle textureregions die nodig zijn om de trap te maken.
	private void LoadContent(TextureRegion trapLeft01, TextureRegion trapLeft02,
							 TextureRegion trapTopLeft02)
	{
		//Maak een rectangle aan de voet van de trap...
		this.collisionRectBottom = new Rectangle(this.position.x+16,this.position.y,16,16);
		

		//Plaats alle traptreden (aantal = amountOfSteps) en.....
		for (int i = 0; i < this.amountOfSteps; i++)
		{
			this.stairs.add(new StepLeft(this.game,
										  new Vector2(this.position.x - i * 16,
												      this.position.y - i * 16),
										  trapLeft01, '^'));
			this.stairs.add(new StepLeft(this.game,
										  new Vector2(this.position.x - (i - 1) * 16,
												  	  this.position.y - i * 16),
										  trapLeft02,
										  '^'));
		}
		//Plaats de bovenkant van de trap...
		this.stairs.add(new StepLeft(this.game,
									  new Vector2(this.position.x - (this.amountOfSteps - 1) * 16,
											  	  this.position.y - this.amountOfSteps * 16),
											  	  trapTopLeft02,
											  	  '^'));
	}

	public void Draw(float delta)
	{
		this.game.getBatch().setColor(0f,0f,1f,1f);
		this.game.getBatch().draw(Level.getCollisionTexture(),
									this.collisionRectBottom.x,
									this.collisionRectBottom.y,
									this.collisionRectBottom.getWidth(),
									this.collisionRectBottom.getHeight());
		this.game.getBatch().setColor(1f,1f,1f,0.9f);
		
		for (StepLeft step : this.stairs)
		{
			step.Draw(delta);
		}
	}

}