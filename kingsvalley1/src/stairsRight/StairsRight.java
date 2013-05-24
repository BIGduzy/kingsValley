package stairsRight;

import java.util.ArrayList;

import level.Level;


import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.nick.kingsvalley1.KingsValley1;



public class StairsRight 
{
	//Fields
	private KingsValley1 game;
	private Vector2 position;
	private int amountOfSteps;
	private ArrayList<StepRight> stairs;
	private Rectangle collisionRectBottom;


	public Rectangle getCollisionRectBottom() {
		return collisionRectBottom;
	}

	public void setCollisionRectBottom(Rectangle collisionRectBottom) {
		this.collisionRectBottom = collisionRectBottom;
	}

	//Constructor
	public StairsRight(KingsValley1 game, Vector2 position, int amountOfSteps,
					   TextureRegion trapRight01, TextureRegion trapRight02,
					   TextureRegion trapTopRight02)
	{
		this.game = game;
		this.position = position.add(new Vector2(-amountOfSteps * 16, amountOfSteps * 16));
		this.amountOfSteps = amountOfSteps;
		this.stairs = new ArrayList<StepRight>();
		this.LoadContent(trapRight01, trapRight02, trapTopRight02);
	}

	//Laad alle textureregions die nodig zijn om de trap te maken.
	private void LoadContent(TextureRegion trapRight01, TextureRegion trapRight02,
							 TextureRegion trapTopRight02)
	{
		//Maak een rectangle aan de voet van de trap...
		this.collisionRectBottom = new Rectangle(this.position.x,this.position.y,16,16);
		
		//Plaats alle traptreden (aantal = amountOfSteps) en.....
		for (int i = 0; i < this.amountOfSteps; i++)
		{
			this.stairs.add(new StepRight(this.game,
										  new Vector2(this.position.x + i * 16,
												      this.position.y - i * 16),
										  trapRight01, '^'));
			this.stairs.add(new StepRight(this.game,
										  new Vector2(this.position.x + (i + 1) * 16,
												  	  this.position.y - i * 16),
										  trapRight02,
										  '^'));
		}
		//Plaats de bovenkant van de trap...
		this.stairs.add(new StepRight(this.game,
									  new Vector2(this.position.x + (this.amountOfSteps + 1) * 16,
											  	  this.position.y - this.amountOfSteps * 16),
											  	  trapTopRight02,
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
		
		for (StepRight step : this.stairs)
		{
			step.Draw(delta);
		}
	}

}