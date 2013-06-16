package Player;


import animatedSprite.AnimatedSprite;

import com.badlogic.gdx.math.Vector2;

public class PlayerJumpLeft extends AnimatedSprite
{
	//Fields
	private Player player;
	private float startX, startY, a;
	private int h, k, startH, startK;

	//Constructor
	//h is de afstand in pixels tot de symmetrie-as. k is de hoogte in pixels van de sprong
	public PlayerJumpLeft(Player player, int h, int k)
	{
		super(player);
		this.player = player;
		this.startH = h;
		this.startK = k;
		this.flipX = true;
		this.Initialize();
	}

	public void Initialize()
	{
		this.startX = player.getPosition().x;
		this.startY = player.getPosition().y;
		this.h = (int)this.startX + this.startH;
		this.k = (int)this.startY - this.startK;
		this.a = (this.startY - this.k)/ (float)Math.pow((double)(this.startX - h), 2);

		/* Maak de collisionrectangle dunner zodat de player net met zijn hakken
		 * op de rand kan staan */
		this.player.getCollisionRectStairs().setWidth(4f);
	}

	//Update method
	public void Update(float delta)
	{
		float x = this.player.getPosition().x - this.player.getSpeed();
		float y = this.a * (float)Math.pow((double)(x - this.h), 2) + this.k;

		this.player.setPosition(new Vector2(x, y));
		this.player.getCollisionRectStairs().setX(this.player.getCollisionRectStairs().x + 8f);

		if (PlayerManager.CollisionDectectionGroundAfterJump())
		{
			this.player.getPosition().set(this.player.getPosition().x,
											this.player.getPosition().y + 
												this.player.getPixelsThroughFloor());
			this.player.getIdleLeft().Inititialize();
			this.player.setState(this.player.getIdleLeft());
		}
	}

	//Draw method
	public void Draw(float delta)
	{
		super.Draw(delta);
	}
}