package bricks;

import java.util.ArrayList;

import stairsRight.StepRight;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.nick.kingsvalley1.KingsValley1;



public class StairsRight 
{
	//Fields
	private KingsValley1 game;
	private Vector2 position;
	private int amountOfSteps;
	private ArrayList<StepRight> stairs;
	
	
	
	public StairsRight(KingsValley1 game, Vector2 position, int amountOfSteps,
					   TextureRegion trapRight01, TextureRegion trapRight02,
					   TextureRegion trapTopRight02)
	{
		this.game = game;
		this.position = position;
		this.amountOfSteps = amountOfSteps;
		this.stairs = new ArrayList<StepRight>();
		this.LoadContent(trapRight01, trapRight02, trapTopRight02);
		
	}
	
	private void LoadContent(TextureRegion trapRight01, TextureRegion trapRight02,
							 TextureRegion trapTopRight02)
	{
		//Plaats alle traptreden (aantal = amountOfSteps) en .....
		for (int i = 0; i < this.amountOfSteps; i++)
		{
			this.stairs.add(new StepRight(this.game,
										  new Vector2(this.position.x + i * 16, this.position.y - i * 16),
										  trapRight01, '^'));
			
			this.stairs.add(new StepRight(this.game,
					  new Vector2(this.position.x +(i + 1) *16 , this.position.y - i * 16),
					  trapRight02, '^'));
		}
		//Plaats de bovenkant van de trap...
		this.stairs.add(new StepRight(this.game,
									new Vector2(this.position.x + (this.amountOfSteps + 1) * 16,
										    	this.position.y -  this.amountOfSteps*16),
									trapTopRight02,
									'^'));
	}
	
	public void Draw(float delta)
	{
		for (StepRight step : this.stairs)
		{
			step.Draw(delta);
		}
	}

}
