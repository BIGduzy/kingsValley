package Player;

import AnimatedSprite.AnimatedSprite;



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

	}

	public void Draw(float delta)
	{
		super.Draw(delta);
	}
}