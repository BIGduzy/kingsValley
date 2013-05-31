package Player;

import AnimatedSprite.AnimatedSprite;



public class PlayerIdleUpStairsRight extends AnimatedSprite{

	private Player player;
	
	public PlayerIdleUpStairsRight(Player player) {
		// super verwijst naar de parent class AnimatedSprite
		super(player);
		this.i = 7;
		this.player = player;
	}
	
	public void Update(float delta){
	}

	public void Draw(float delta){
		super.Draw(delta);
	}
}
