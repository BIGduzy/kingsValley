package floor;

import level.Level;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.nick.kingsvalley1.KingsValley1;

public class Floor
{
	private KingsValley1 game;
	private Vector2 position;
	private Rectangle collisionRectangle;

	public Rectangle getCollisionRectangle() {
		return collisionRectangle;
	}

	public void setCollisionRectangle(Rectangle collisionRectangle) {
		this.collisionRectangle = collisionRectangle;
	}

	//Constructor
	public Floor(KingsValley1 game, Vector2 position, int amountOfBricks)
	{
		this.game = game;
		this.position = position;
		this.collisionRectangle = new Rectangle(this.position.x,
												this.position.y,
												amountOfBricks * 16f,
												16f);
	}

	public void Draw(float delta)
	{
		/*this.game.getBatch().draw(Level.getCollisionTexture(),
								  this.collisionRectangle.x,
								  this.collisionRectangle.y,
								  this.collisionRectangle.getWidth(),
								  this.collisionRectangle.getHeight());*/
	}

}