package Player;

import AnimatedSprite.AnimatedSprite;

public class PlayerWalkUpStairsLeft extends AnimatedSprite{

	//fields
	private Player player;
	
	//constructor
	public PlayerWalkUpStairsLeft(Player player) {
		super(player);
		this.player = player;
	}
	
	public void Update(float delta)
	{
		this.player.setPosition(this.player.getPosition().
				add(-this.player.getSpeed(), -this.player.getSpeed()));
		super.Update(delta);
	}
	
	public void Draw(float delta)
	{
		super.Draw(delta);
	}

}
