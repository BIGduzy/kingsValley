package jewel;

import java.util.Map;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.nick.kingsvalley1.KingsValley1;

public class Jewel
{
	//Fields
	private KingsValley1 game;
	private Vector2 position;
	private Color color;
	private Map<String, TextureRegion> region;
	private Crown crown;
	private Rectangle collisionRectangle;

	//Properties
	public Rectangle getCollisionRectangle() {
		return collisionRectangle;
	}

	public void setCollisionRectangle(Rectangle collisionRectangle) {
		this.collisionRectangle = collisionRectangle;
	}

	//Constructor
	public Jewel(KingsValley1 game, Vector2 position, Color color,
						Map<String, TextureRegion> region)
	{
		this.game = game;
		this.position = position;
		this.color = color;
		this.region = region;
		this.crown = new Crown(this.game, this.position, this.region);
		this.collisionRectangle = new Rectangle(this.position.x,
												this.position.y,
												16f,
												16f);
	}

	public void Update(float delta)
	{
		this.crown.Update(delta);
	}

	public void Draw(float delta)
	{
		this.crown.Draw(delta);
		this.game.getBatch().setColor(this.color);
		this.game.getBatch().draw(this.region.get("jewel"),
								  this.position.x,
								  this.position.y,
								  this.region.get("jewel").getRegionWidth(),
								  this.region.get("jewel").getRegionHeight());
	}
}