package Player;

import AnimatedSprite.AnimatedSprite;

public class PlayerIdleRight  extends AnimatedSprite{
	
	//fields
	private Player player;
	
	
	//constructor
	public PlayerIdleRight(Player player)
	{
		super(player);
		this.player = player;
		this.i = 7;
		
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
