package AnimatedSprite;

import Player.Player;

public class AnimatedSprite {
	//fields
	private Player player;
	private int[] xValue = {0,18,36,54,72,90,108,126};
	protected int i = 0;
	protected boolean flipX = false;
	private float timer = 0;
	
	//constructor
	public AnimatedSprite(Player player){
		this.player = player;
	}
	
	//update
	public void Update(float delta)
	{
		this.timer += delta;
		if (this.timer > 5f/60f)
		{
			this.timer = 0;
			this.i++;
			if (this.i > 7)
			{
				this.i = 0;
			}
		}
		
	}
	//Draw
	public void Draw(float delta)
	{
		this.player.getGame().getBatch().draw(this.player.getTexture(),
				  this.player.getPosition().x,
				  this.player.getPosition().y,
				  this.player.getTexture().getWidth()/8,
				  this.player.getTexture().getHeight(),
			      this.xValue[this.i],
				  0,
				  18,
				  32,
				  flipX,
				  true);
		
	}
}
