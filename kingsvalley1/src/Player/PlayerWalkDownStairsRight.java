package Player;

import animatedSprite.AnimatedSprite;

public class PlayerWalkDownStairsRight extends AnimatedSprite{
	
	//fields
	private Player player;
	
	public PlayerWalkDownStairsRight(Player player)
	{
		super(player);
		this.player = player;
		this.Initialize();
	}
	
	public void Initialize()
	{
		this.i = 3;
		this.flipX = true;
	}

	public void Update(float delta)
	{
		this.player.setPosition(this.player.getPosition().add(-this.player.getSpeed(),
				this.player.getSpeed()));
		if (PlayerManager.CollisionDetectionBottomStairsRight())
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
