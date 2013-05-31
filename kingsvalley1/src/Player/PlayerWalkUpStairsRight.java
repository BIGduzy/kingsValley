package Player;

import AnimatedSprite.AnimatedSprite;

public class PlayerWalkUpStairsRight extends AnimatedSprite{

	//fields
	private Player player;
	
	//constructor
	public PlayerWalkUpStairsRight(Player player) {
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
		if (PlayerManager.CollisionDetectionTopStairsRight())
		{
			this.player.setState(this.player.getRight());
		}
		super.Update(delta);
	}
	
	public void Draw(float delta)
	{
		super.Draw(delta);
	}

}
