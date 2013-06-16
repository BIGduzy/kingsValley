package Player;

import animatedSprite.AnimatedSprite;

public class PlayerIdleRightNoLineairMovement extends AnimatedSprite{

	//Fields
	private Player player;

	//Constructor
	public PlayerIdleRightNoLineairMovement(Player player)
	{
		super(player);
		this.player = player;
		this.i = 7;
		this.flipX = false;
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