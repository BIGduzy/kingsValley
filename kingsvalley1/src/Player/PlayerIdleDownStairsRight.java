package Player;

import AnimatedSprite.AnimatedSprite;

public class PlayerIdleDownStairsRight extends AnimatedSprite{

	
private Player player;
	
	public PlayerIdleDownStairsRight(Player player) {
		// super verwijst naar de parent class AnimatedSprite
		super(player);
		this.i = 7;
		this.flipX = true;
		this.player = player;
	}
	
	public void Update(float delta){
	}

	public void Draw(float delta){
		super.Draw(delta);
	}
}
