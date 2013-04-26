package image;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.nick.kingsvalley1.KingsValley1;

public class Image
{
	//Fields
	private KingsValley1 game;
	private Vector2 position;
	private TextureRegion region;

	//Properties
	public Vector2 getPosition()
	{
		return this.position;
	}


	//Constructor
	public Image(KingsValley1 game, Vector2 position, TextureRegion region)
	{
		this.game = game;
		this.position = position;
		this.region = region;
	}

	public void Draw(float delta)
	{
		this.game.getBatch().draw(this.region,
								  this.position.x,
								  this.position.y,
								  0f,
								  0f,
								  16f,
								  16f,
								  1f,
								  1f,
								  0f);
	}	
}
