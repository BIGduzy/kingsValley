package Player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

import AnimatedSprite.AnimatedSprite;

public class PlayerIdleDownStairsLeft extends AnimatedSprite
{	
	public PlayerIdleDownStairsLeft(Player player) 
	{
		// Super verwijst naar de parent class AnimatedSprite
		super(player);
	}

	public void Initialize()
	{
		this.i = 7;
	}

	public void Update(float delta)
	{
		if (Gdx.input.isKeyPressed(Keys.LEFT))
		{			
			this.player.getWalkUpStairsLeft().Initialize();
			this.player.setState(this.player.getWalkUpStairsLeft());
		}
	}

	public void Draw(float delta)
	{
		super.Draw(delta);
	}
}