package Player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

import animatedSprite.AnimatedSprite;

public class PlayerIdleRight extends AnimatedSprite
{
	//Field	

	//Constructor
	public PlayerIdleRight(Player player)
	{
		super(player);
		this.i = 7;
	}

	public void Initialize()
	{
		this.player.getCollisionRectStairs().setWidth(20f);		
	}

	//Update
	public void Update(float delta)
	{
		if (Gdx.input.isKeyPressed(Keys.RIGHT))
		{
			this.player.setState(this.player.getWalkRight());
		}
	}

	public void Draw(float delta)
	{
		super.Draw(delta);		
	}
}