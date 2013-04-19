package Player;

import AnimatedSprite.AnimatedSprite;

import com.badlogic.gdx.math.Vector2;

public class PlayerJumpLeft extends AnimatedSprite {

	//Fields
		private Player player;
		private float startX, startY, a;
		private int h, k, startH, startK;

		//Constructor
		//h is de afstand in pixels tot de symmetrie-as. k is de hoogte in pixels van de sprong
		public PlayerJumpLeft(Player player, int h, int k)
		{
			super(player);
			this.flipX = true;
			this.player = player;
			this.startH = h;
			this.startK = k;
			this.Initialize();
		}

		public void Initialize()
		{
			this.startX = player.getPosition().x;
			this.startY = player.getPosition().y;
			this.h = (int)this.startX + this.startH;
			this.k = (int)this.startY - this.startK;
			this.a = (this.startY - this.k)/ (float)Math.pow((double)(this.startX - h), 2);
		}

		//Update method
		public void Update(float delta)
		{
			float x = this.player.getPosition().x - this.player.getSpeed();
			float y = this.a * (float)Math.pow((double)(x - this.h), 2) + this.k;

			this.player.setPosition(new Vector2(x, -y));
			if ( this.player.getPosition().y < this.startY)
			{
				this.player.setPosition(new Vector2(x, this.startY));
				this.player.setState(this.player.getLeft());
			}
		}

		//Draw method
		public void Draw(float delta)
		{
			super.Draw(delta);
		}
}
