package Player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;

import AnimatedSprite.AnimatedSprite;

public class PlayerRight extends AnimatedSprite{
	
	//fields
	private Player player;
	
	//constructor
	public PlayerRight(Player player)
	{
		super(player);	
		this.player = player;
	}
	
	public void Update(float delta)
	{
		this.player.setPosition(this.player.getPosition().
				add(new Vector2(this.player.getSpeed(),0f)));
		
		// collision detection tussen onderkant trap en player
		if (PlayerManager.CollisionDetectionBottomStairsRight() && Gdx.input.isKeyPressed(Keys.UP)){
			
			this.player.setState(this.player.getWalkUpStairsRight());
		}
		
		super.Update(delta);
		
	}
	
	public void Draw(float delta)
	{
		super.Draw(delta);
	}
}
