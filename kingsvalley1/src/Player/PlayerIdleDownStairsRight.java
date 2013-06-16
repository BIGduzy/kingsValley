package Player;

import animatedSprite.AnimatedSprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;


public class PlayerIdleDownStairsRight extends AnimatedSprite
{

	public PlayerIdleDownStairsRight(Player player) 
	{
		// Super verwijst naar de parent class AnimatedSprite
		super(player);
		this.i = 7;
		this.flipX = true;
	}

	public void Update(float delta)
	{
		if (Gdx.input.isKeyPressed(Keys.RIGHT))
		{			
			this.player.getWalkUpStairsRight().Initialize();
			this.player.setState(this.player.getWalkUpStairsRight());
		}
	}

	public void Draw(float delta)
	{
		super.Draw(delta);
	}
}