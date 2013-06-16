package Player;

import animatedSprite.AnimatedSprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;




public class PlayerIdleUpStairsLeft extends AnimatedSprite
{

	public PlayerIdleUpStairsLeft(Player player) 
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
			this.player.getWalkDownStairsLeft().Initialize();
			this.player.setState(this.player.getWalkDownStairsLeft());
		}

	}

	public void Draw(float delta)
	{
		super.Draw(delta);
	}
}