package Player;

import animatedSprite.AnimatedSprite;

import com.badlogic.gdx.math.Vector2;

public class PlayerFallOfFloorLeft extends AnimatedSprite
{
	//Fields
	private float startX, startY, a;
	private int startH, startK, h, k;


	/* Constructor */
	public PlayerFallOfFloorLeft(Player player, int h, int k) 
	{
		super(player);
		this.startH = h; 				//Leg de start h vast
		this.startK = k;				//Leg de start k vast
		this.flipX = true;				//Keer het gezicht naar links
		this.i = 0;						//Spreid de benen van de player
	}

	public void Initialize()
	{
		this.startX = this.player.getPosition().x;
		this.startY = this.player.getPosition().y;
		this.h = (int)(this.startX + this.startH);
		this.k = (int)(this.startY - startK);
		this.a = CalculateA();
		this.player.getCollisionRectStairs().setWidth(5f);
	}

	private float CalculateA()
	{
		return (this.startY - this.k) / (float)Math.pow((double)(this.startX - this.h), 2d);
	}

	public void Update(float delta)
	{
		float x = this.player.getPosition().x - this.player.getSpeed();

		float y = (float)(this.a * Math.pow(x - this.h, 2d) + this.k);

		this.player.setPosition(new Vector2(x, y));

		if (PlayerManager.CollisionDectectionGroundAfterJump())
		{
			this.player.setPosition(new Vector2(x,
												  this.player.getPosition().y +
												  this.player.getPixelsThroughFloor()));
			this.player.getIdleLeft().Inititialize();
			this.player.setState(this.player.getIdleLeft());
		}		
	}

	public void Draw(float delta)
	{
		super.Draw(delta);
	}
}