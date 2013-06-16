package Player;

import animatedSprite.AnimatedSprite;

public class PlayerIdleLeftNoLineairMovement extends AnimatedSprite{

	//Fields
	private Player player;

	//Constructor
	public PlayerIdleLeftNoLineairMovement(Player player)
	{
		super(player);
		this.player = player;
		this.i = 7;
		this.flipX = true;
	}

	public void Update(float delta)
	{
		super.Update(delta);
	}

	public void Draw(float delta)
	{
		super.Draw(delta);
	}

}