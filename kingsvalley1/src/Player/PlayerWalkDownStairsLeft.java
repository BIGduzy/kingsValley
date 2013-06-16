package Player;

import animatedSprite.AnimatedSprite;

public class PlayerWalkDownStairsLeft extends AnimatedSprite
{
	//Fields
	private Player player;

	//Constructor
	public PlayerWalkDownStairsLeft(Player player)
	{
		super(player);
		this.player = player;
	}

	public void Initialize()
	{
		this.i = 3;
	}

	public void Update(float delta)
	{
		this.player.setPosition(this.player.getPosition().add(this.player.getSpeed(),
				this.player.getSpeed()));
		if (PlayerManager.CollisionDetectionBottomStairsLeft())
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