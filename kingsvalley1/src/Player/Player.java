package Player;

import level.Level;
import animatedSprite.AnimatedSprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.nick.kingsvalley1.KingsValley1;

public class Player 
{	
	//Fields
	private KingsValley1 game;
	private Vector2 position;
	private float speed;
	private Texture texture;
	private Rectangle collisionRectStairs;
	private AnimatedSprite state;
	private PlayerWalkRight walkRight;
	private PlayerIdleRight idleRight;
	private PlayerIdleLeft idleLeft;
	private PlayerWalkLeft walkLeft;
	private PlayerJumpRight jumpRight;
	private PlayerJumpLeft jumpLeft;
	private PlayerIdleJumpLeft idleJumpLeft;
	private PlayerIdleJumpRight idleJumpRight;
	private PlayerWalkUpStairsRight walkUpStairsRight;
	private PlayerIdleUpStairsRight idleUpStairsRight;
	private PlayerIdleDownStairsRight idleDownStairsRight;
	private PlayerWalkDownStairsRight walkDownStairsRight;
	private PlayerWalkUpStairsLeft walkUpStairsLeft;
	private PlayerIdleUpStairsLeft idleUpStairsLeft;
	private PlayerWalkDownStairsLeft walkDownStairsLeft;
	private PlayerIdleDownStairsLeft idleDownStairsLeft;
	private PlayerFallOfFloorLeft fallOfFloorLeft;
	private PlayerFallOfFloorRight fallOfFloorRight;
	private PlayerIdleLeftNoLineairMovement idleLeftNoLineairMovement;
	private PlayerIdleRightNoLineairMovement idleRightNoLineairMovement;
	private float pixelsThroughFloor;
	private float pixelsInWallLeft, pixelsInWallRight;

	//Properties
	public Vector2 getPosition()
	{
		return this.position;
	}
	public void setPosition(Vector2 position)
	{
		this.position = position;
		this.collisionRectStairs.x = this.position.x;
		this.collisionRectStairs.y = this.position.y + 16;
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
	public PlayerWalkRight getWalkRight()
	{
		return this.walkRight;
	}
	public void setWalkRight(PlayerWalkRight walkRight)
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
	public PlayerWalkLeft getWalkLeft() {
		return this.walkLeft;
	}
	public void setWalkLeft(PlayerWalkLeft walkLeft) {
		this.walkLeft = walkLeft;
	}
	public PlayerJumpLeft getJumpLeft() {
		return jumpLeft;
	}
	public void setJumpLeft(PlayerJumpLeft jumpLeft) {
		this.jumpLeft = jumpLeft;
	}	
	public PlayerJumpRight getJumpRight() {
		return jumpRight;
	}
	public void setJumpRight(PlayerJumpRight jumpRight) {
		this.jumpRight = jumpRight;
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

	public Rectangle getCollisionRectStairs() {
		return collisionRectStairs;
	}
	public void setCollisionRectStairs(Rectangle collisionRectStairs) {
		this.collisionRectStairs = collisionRectStairs;
	}

	public PlayerWalkUpStairsRight getWalkUpStairsRight() {
		return walkUpStairsRight;
	}
	public void setWalkUpStairsRight(PlayerWalkUpStairsRight walkUpStairsRight) {
		this.walkUpStairsRight = walkUpStairsRight;
	}
	public PlayerIdleUpStairsRight getIdleUpStairsRight() {
		return idleUpStairsRight;
	}
	public void setIdleUpStairsRight(PlayerIdleUpStairsRight idleUpStairs) {
		this.idleUpStairsRight = idleUpStairs;
	}

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

	public PlayerWalkUpStairsLeft getWalkUpStairsLeft() {
		return walkUpStairsLeft;
	}
	public void setWalkUpStairsLeft(PlayerWalkUpStairsLeft walkUpStairsLeft) {
		this.walkUpStairsLeft = walkUpStairsLeft;
	}
	public PlayerIdleUpStairsLeft getIdleUpStairsLeft() {
		return idleUpStairsLeft;
	}
	public void setIdleUpStairsLeft(PlayerIdleUpStairsLeft idleUpStairsLeft) {
		this.idleUpStairsLeft = idleUpStairsLeft;
	}
	public PlayerWalkDownStairsLeft getWalkDownStairsLeft() {
		return walkDownStairsLeft;
	}
	public void setWalkDownStairsLeft(PlayerWalkDownStairsLeft walkDownStairsLeft) {
		this.walkDownStairsLeft = walkDownStairsLeft;
	}

	public PlayerIdleDownStairsLeft getIdleDownStairsLeft() {
		return idleDownStairsLeft;
	}
	public void setIdleDownStairsLeft(PlayerIdleDownStairsLeft idleDownStairsLeft) {
		this.idleDownStairsLeft = idleDownStairsLeft;
	}

	public float getPixelsThroughFloor() {
		return pixelsThroughFloor;
	}
	public void setPixelsThroughFloor(float pixelsThroughFloor) {
		this.pixelsThroughFloor = pixelsThroughFloor;
	}
	public PlayerFallOfFloorLeft getFallOfFloorLeft() {
		return fallOfFloorLeft;
	}
	public void setFallOfFloorLeft(PlayerFallOfFloorLeft fallOfFloorLeft) {
		this.fallOfFloorLeft = fallOfFloorLeft;
	}
	public PlayerFallOfFloorRight getFallOfFloorRight() {
		return fallOfFloorRight;
	}
	public void setFallOfFloorRight(PlayerFallOfFloorRight fallOfFloorRight) {
		this.fallOfFloorRight = fallOfFloorRight;
	}
	public float getPixelsInWallLeft() {
		return pixelsInWallLeft;
	}
	public void setPixelsInWallLeft(float pixelsInWallLeft) {
		this.pixelsInWallLeft = pixelsInWallLeft;
	}
	public PlayerIdleLeftNoLineairMovement getIdleLeftNoLineairMovement() {
		return idleLeftNoLineairMovement;
	}
	public void setIdleLeftNoLineairMovement(PlayerIdleLeftNoLineairMovement idleLeftNoLineairMovement) {
		this.idleLeftNoLineairMovement = idleLeftNoLineairMovement;
	}
	public float getPixelsInWallRight() {
		return pixelsInWallRight;
	}
	public void setPixelsInWallRight(float pixelsInWallRight) {
		this.pixelsInWallRight = pixelsInWallRight;
	}
	public PlayerIdleRightNoLineairMovement getIdleRightNoLineairMovement() {
		return idleRightNoLineairMovement;
	}
	public void setIdleRightNoLineairMovement(PlayerIdleRightNoLineairMovement idleRightNoLineairMovement) {
		this.idleRightNoLineairMovement = idleRightNoLineairMovement;
	}
	//Constructor
	public Player(KingsValley1 game, Vector2 position, float speed)
	{
		this.game = game;
		this.position = position;
		this.collisionRectStairs = new Rectangle(this.position.x, this.position.y + 16, 20, 17);
		this.speed = speed;	
		this.texture = new Texture("data/explorer.png");	
		this.walkRight = new PlayerWalkRight(this);
		this.idleRight = new PlayerIdleRight(this);
		this.idleLeft = new PlayerIdleLeft(this);
		this.walkLeft = new PlayerWalkLeft(this);
		this.jumpRight = new PlayerJumpRight(this, 20, 32);
		this.jumpLeft = new PlayerJumpLeft(this, -20, 32);
		this.idleJumpLeft = new PlayerIdleJumpLeft(this, -20, 32);
		this.idleJumpRight = new PlayerIdleJumpRight(this, 20, 32);
		this.walkUpStairsRight = new PlayerWalkUpStairsRight(this);
		this.idleUpStairsRight = new PlayerIdleUpStairsRight(this);
		this.idleDownStairsRight = new PlayerIdleDownStairsRight(this);
		this.walkDownStairsRight = new PlayerWalkDownStairsRight(this);
		this.walkUpStairsLeft = new PlayerWalkUpStairsLeft(this);
		this.idleUpStairsLeft = new PlayerIdleUpStairsLeft(this);
		this.walkDownStairsLeft = new PlayerWalkDownStairsLeft(this);
		this.idleDownStairsLeft = new PlayerIdleDownStairsLeft(this);
		this.fallOfFloorLeft = new PlayerFallOfFloorLeft(this, -1, 1);
		this.fallOfFloorRight = new PlayerFallOfFloorRight(this, 2, 2);
		this.idleLeftNoLineairMovement = new PlayerIdleLeftNoLineairMovement(this);
		this.idleRightNoLineairMovement = new PlayerIdleRightNoLineairMovement(this);
		this.idleRight.Initialize();
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

		this.game.getBatch().setColor(1f, 0f, 0f, 1f);
		this.game.getBatch().draw(Level.getCollisionTexture(),
								  this.collisionRectStairs.x, 
								  this.collisionRectStairs.y,
								  this.collisionRectStairs.getWidth(),
								  this.collisionRectStairs.getHeight());
		this.game.getBatch().setColor(1f,1f, 1f, 1f);
		this.state.Draw(delta);		
	}
}