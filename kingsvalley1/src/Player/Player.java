package Player;

import AnimatedSprite.AnimatedSprite;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.nick.kingsvalley1.KingsValley1;

public class Player  {
	
	//Fields
		private KingsValley1 game;
		private Vector2 position;
		private float speed;
		private Texture texture;
		private AnimatedSprite state;
		private PlayerRight walkRight;
		private PlayerIdleRight idleRight;
		private PlayerIdleLeft idleLeft;
		private PlayerLeft walkLeft;
		private PlayerJumpRight jumpRight;



		//Properties
		public Vector2 getPosition()
		{
			return this.position;
		}
		public void setPosition(Vector2 position)
		{
			this.position = position;
		}
		public float getSpeed()
		{
			return this.speed;
		}
		public Texture getTexture()
		{
			return this.texture;
		}
		public KingsValley1 getGame()
		{
			return this.game;
		}
		public AnimatedSprite getState()
		{
			return this.state;
		}
		public void setState(AnimatedSprite state)
		{
			this.state = state;
		}
		public PlayerIdleRight getIdleRight()
		{
			return this.idleRight;
		}
		public void setIdleRight(PlayerIdleRight idleRight)
		{
			this.idleRight = idleRight;
		}
		public PlayerRight getRight()
		{
			return this.walkRight;
		}
		public void setWalkRight(PlayerRight walkRight)
		{
			this.walkRight = walkRight;
		}
		public PlayerIdleLeft getIdleLeft()
		{
			return this.idleLeft;
		}
		public void setIdleLeft(PlayerIdleLeft idleLeft)
		{
			this.idleLeft = idleLeft;
		}	
		public PlayerLeft getLeft() {
			return this.walkLeft;
		}
		public void setWalkLeft(PlayerLeft walkLeft) {
			this.walkLeft = walkLeft;
		}	
		public PlayerJumpRight getJumpRight() {
			return jumpRight;
		}
		public void setJumpRight(PlayerJumpRight jumpRight) {
			this.jumpRight = jumpRight;
		}

		//Constructor
		public Player(KingsValley1 game, Vector2 position, float speed)
		{
			this.game = game;
			this.position = position;
			this.speed = speed;	
			this.texture = new Texture("data/explorer.png");	
			this.walkRight = new PlayerRight(this);
			this.idleRight = new PlayerIdleRight(this);
			this.idleLeft = new PlayerIdleLeft(this);
			this.walkLeft = new PlayerLeft(this);
			this.jumpRight = new PlayerJumpRight(this);
			this.state = this.idleRight;
		}


		//Update
		public void Update(float delta)
		{
			this.state.Update(delta);
		}


		//Draw
		public void Draw(float delta)
		{
			this.state.Draw(delta);		
		}
}
