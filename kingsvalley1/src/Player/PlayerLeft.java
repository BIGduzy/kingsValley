package Player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;

import AnimatedSprite.AnimatedSprite;

public class PlayerLeft extends AnimatedSprite{
	
	//fields
	private Player player;
	
	
	//constructor
	public PlayerLeft(Player player)
	{
		super(player);	
		this.player = player;
		this.flipX = true;
	}
	
	public void Update(float delta)
	{
		this.player.setPosition(this.player.getPosition().
				add(new Vector2(-this.player.getSpeed(),0f)));
		
		//collision detection tussen onderkant trap en player
		if (PlayerManager.CollisionDetectionBottomStairsLeft() && Gdx.input.isKeyPressed(Keys.UP)){
			
			this.player.setState(this.player.getWalkUpStairsLeft());
		}
		
		super.Update(delta);
		
	}
	
	public void Draw(float delta)
	{
		super.Draw(delta);
	}
}
