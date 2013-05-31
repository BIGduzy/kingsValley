package Player;

import level.Level;
import AnimatedSprite.AnimatedSprite;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.nick.kingsvalley1.KingsValley1;

public class Player  {
	
	//Fields
		private KingsValley1 game;
		private Vector2 position;
		private float speed;
		private Texture texture;
		private Rectangle collisionRectStairs;
		private AnimatedSprite state;
		private PlayerRight walkRight;
		private PlayerIdleRight idleRight;
		private PlayerIdleLeft idleLeft;
		private PlayerLeft walkLeft;
		private PlayerJumpRight jumpRight;
		private PlayerJumpLeft jumpLeft;
		private PlayerIdleJumpLeft idleJumpLeft;
		private PlayerIdleJumpRight idleJumpRight;
		private PlayerWalkUpStairsRight walkUpStairsRight;
		private PlayerWalkUpStairsLeft walkUpStairsLeft;
		private PlayerIdleUpStairsRight idleUpStairsRight;
		private PlayerWalkDownStairsRight walkDownStairsRight;
		private PlayerIdleDownStairsRight idleDownStairsRight;

		//Properties
		
		public PlayerIdleDownStairsRight getIdleDownStairsRight() {
			return idleDownStairsRight;
		}
		public void setIdleDownStairsRight(PlayerIdleDownStairsRight idleDownStairsRight) {
			this.idleDownStairsRight = idleDownStairsRight;
		}
		public PlayerWalkDownStairsRight getWalkDownStairsRight() {
			return walkDownStairsRight;
		}
		public void setWalkDownStairsRight(PlayerWalkDownStairsRight walkDownStairsRight) {
			this.walkDownStairsRight = walkDownStairsRight;
		}
		public PlayerIdleUpStairsRight getIdleUpStairsRight() {
			return idleUpStairsRight;
		}
		public void setIdleUpStairsRight(PlayerIdleUpStairsRight idleUpStairs) {
			this.idleUpStairsRight = idleUpStairs;
		}
		public PlayerWalkUpStairsLeft getWalkUpStairsLeft(){
			return walkUpStairsLeft;
		}
		public PlayerWalkUpStairsRight getWalkUpStairsRight() {
			return walkUpStairsRight;
		}
		public Rectangle getCollisionRectStairs() {
			return collisionRectStairs;
		}
		public void setCollisionRectStairs(Rectangle collisionRectStairs) {
			this.collisionRectStairs = collisionRectStairs;
		}
		public Vector2 getPosition()
		{
			return this.position;
		}
		public void setPosition(Vector2 position)
		{
			this.position = position;
			this.collisionRectStairs.x = this.position.x;
			this.collisionRectStairs.y = this.position.y;
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
		public PlayerJumpLeft getJumpLeft() {
			return jumpLeft;
		}
		public void setJumpLeft(PlayerJumpLeft jumpLeft) {
			this.jumpLeft = jumpLeft;
		}
		public PlayerIdleJumpLeft getIdleJumpLeft() {
			return idleJumpLeft;
		}
		public void setIdleJumpLeft(PlayerIdleJumpLeft idleJumpLeft) {
			this.idleJumpLeft = idleJumpLeft;
		}
		public PlayerIdleJumpRight getIdleJumpRight() {
			return idleJumpRight;
		}
		public void setIdleJumpRight(PlayerIdleJumpRight idleJumpRight) {
			this.idleJumpRight = idleJumpRight;
		}
		
		
		//Constructor
		public Player(KingsValley1 game, Vector2 position, float speed)
		{
			this.game = game;
			this.position = position;
			this.collisionRectStairs = new Rectangle(this.position.x,this.position.y+16,20,17);
			this.speed = speed;	
			this.texture = new Texture("data/explorer.png");	
			this.walkRight = new PlayerRight(this);
			this.idleRight = new PlayerIdleRight(this);
			this.idleLeft = new PlayerIdleLeft(this);
			this.walkLeft = new PlayerLeft(this);
			this.jumpRight = new PlayerJumpRight(this,20,32);
			this.jumpLeft = new PlayerJumpLeft(this,-20,32);
			this.idleJumpLeft = new PlayerIdleJumpLeft(this, -20,32);
			this.idleJumpRight = new PlayerIdleJumpRight(this,20,32);
			this.walkUpStairsRight = new PlayerWalkUpStairsRight(this);
			this.walkUpStairsLeft = new PlayerWalkUpStairsLeft(this);
			this.idleUpStairsRight = new PlayerIdleUpStairsRight(this);
			this.walkDownStairsRight = new PlayerWalkDownStairsRight(this);
			this.idleDownStairsRight = new PlayerIdleDownStairsRight(this);
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
			this.game.getBatch().setColor(1f,0f,0f,1f);
			this.game.getBatch().draw(Level.getCollisionTexture(),
										this.collisionRectStairs.x,
										this.collisionRectStairs.y,
										this.collisionRectStairs.getWidth(),
										this.collisionRectStairs.getHeight());
			this.game.getBatch().setColor(1f,1f,1f,0.9f);
			this.state.Draw(delta);		
		}
		
}
