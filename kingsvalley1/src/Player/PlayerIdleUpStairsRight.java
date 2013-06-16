package Player;

import animatedSprite.AnimatedSprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;




public class PlayerIdleUpStairsRight extends AnimatedSprite
{

	public PlayerIdleUpStairsRight(Player player) 
	{
		// Super verwijst naar de parent class AnimatedSprite
		super(player);
		this.i = 7;		
	}

	public void Update(float delta)
	{
		if (Gdx.input.isKeyPressed(Keys.LEFT))
		{			
			this.player.getWalkDownStairsRight().Initialize();
			this.player.setState(this.player.getWalkDownStairsRight());
		}
	}

	public void Draw(float delta)
	{
		super.Draw(delta);
	}
}