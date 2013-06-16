package Player;

import animatedSprite.AnimatedSprite;

public class PlayerWalkUpStairsRight extends AnimatedSprite 
{
	// Fields
	private Player player;

	//Constructor
	public PlayerWalkUpStairsRight(Player player) 
	{
		super(player);
		this.player = player;
		this.Initialize();

	}

	public void Initialize()
	{
		this.i = 3;
	}

	public void Update(float delta)
	{

		this.player.setPosition(this.player.getPosition().
				add(this.player.getSpeed(), -this.player.getSpeed()));
		if (PlayerManager.CollisionDectectionTopStairsRight())
		{
			this.player.setState(this.player.getWalkRight());
		}
		super.Update(delta);
	}

	public void Draw(float delta)
	{
		super.Draw(delta);
	}

}