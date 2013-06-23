package jewel;

import java.util.Map;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.nick.kingsvalley1.KingsValley1;

public class Ray {
	
	//fields
	private KingsValley1 game;
	private Vector2 position;
	private TextureRegion region;
	
	
	//constructor	
	public Ray(KingsValley1 game, Vector2 postition, TextureRegion region)
	{
		this.region = region;
		this.game = game;
		this.position = postition;
	}
	
	public void Update(float delta)
	{
		
	}
	
	public void Draw(float delta)
	{
		this.game.getBatch().draw(this.region,
								this.position.x, this.position.y,
								this.region.getRegionWidth(),
								this.region.getRegionHeight());
	}
}
