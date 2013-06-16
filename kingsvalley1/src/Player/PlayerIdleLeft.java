package Player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

import animatedSprite.AnimatedSprite;

public class PlayerIdleLeft extends AnimatedSprite
{
	//Field	

	//Constructor
	public PlayerIdleLeft(Player player)
	{
		super(player);
		this.i = 7;
		this.flipX = true;
	}

	public void Inititialize()
	{
		this.player.getCollisionRectStairs().setWidth(20f);
		this.player.getCollisionRectStairs().setX(this.player.getCollisionRectStairs().x-8);
	}

	//Update
	public void Update(float delta)
	{
		if (Gdx.input.isKeyPressed(Keys.LEFT))
		{
			this.player.setState(this.player.getWalkLeft());
		}
	}

	public void Draw(float delta)
	{
		super.Draw(delta);		
	}
}