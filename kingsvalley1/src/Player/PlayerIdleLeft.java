package Player;

import AnimatedSprite.AnimatedSprite;

public class PlayerIdleLeft  extends AnimatedSprite{
	
	//fields
	private Player player;
	
	
	//constructor
	public PlayerIdleLeft(Player player)
	{
		super(player);
		this.player = player;
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
