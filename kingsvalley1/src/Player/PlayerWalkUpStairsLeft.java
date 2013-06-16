package Player;

import animatedSprite.AnimatedSprite;

public class PlayerWalkUpStairsLeft extends AnimatedSprite 
{
	// Fields
	private Player player;

	//Constructor
	public PlayerWalkUpStairsLeft(Player player) 
	{
		super(player);
		this.player = player;
		this.Initialize();
		this.flipX = true;		
	}

	public void Initialize()
	{
		this.i = 3;
	}

	public void Update(float delta)
	{

		this.player.setPosition(this.player.getPosition().
				add(-this.player.getSpeed(), -this.player.getSpeed()));
		if (PlayerManager.CollisionDectectionTopStairsLeft())
		{
			this.player.setState(this.player.getWalkLeft());
		}
		super.Update(delta);
	}

	public void Draw(float delta)
	{
		super.Draw(delta);
	}

}