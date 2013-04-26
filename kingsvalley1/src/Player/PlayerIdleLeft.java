package Player;

import AnimatedSprite.AnimatedSprite;

public class PlayerIdleLeft  extends AnimatedSprite{
	
	//fields
	
	
	//constructor
	public PlayerIdleLeft(Player player)
	{
		super(player);
		this.i = 7;
		this.flipX = true;
		
	}
	
	//update
	public void Update(float delta)
	{
		
	}
	
	
	//draw
	public void Deaw(float delta)
	{
		super.Draw(delta);
	}
}
