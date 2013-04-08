package Player;

import AnimatedSprite.AnimatedSprite;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.nick.kingsvalley1.KingsValley1;

public class Player  {
	


	//fields
	private KingsValley1 game;
	private Vector2 position;
	private float speed;
	private Texture texture;
	private AnimatedSprite state;
	private PlayerRight walkRight;
	private PlayerIdleRight idleRight;
	private PlayerLeft walkLeft;
	private PlayerIdleLeft idleLeft;
	
	//properties
	public Vector2 getPosition() {
		return position;
	}
	public void setPosition(Vector2 position) {
		this.position = position;
	}	
	public float getSpeed() {
		return speed;
	}
	public void setSpeed(float speed) {
		this.speed = speed;
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
	public PlayerIdleLeft getIdleLeft()
	{
		return this.idleLeft;
	}
	public void setIdleLeft(PlayerIdleLeft idleLeft)
	{
		this.idleLeft = idleLeft;
	}
	public PlayerRight getWalkRight()
	{
		return this.walkRight;
	}
	public void setWalkRight(PlayerRight walkRight)
	{
		this.walkRight = walkRight;
	}
	public PlayerLeft getWalkLeft()
	{
		return this.walkLeft;
	}
	public void setWalkLeft(PlayerLeft walkLeft)
	{
		this.walkLeft = walkLeft;
	}
	
	
	//Constructor
	public Player(KingsValley1 game,Vector2 position,float speed)
	{
		this.game = game;
		this.position = position;
		this.speed = speed;
		this.texture = new Texture("data/explorer.png");
		this.walkRight = new PlayerRight(this);
		this.walkLeft = new PlayerLeft(this);
		this.idleRight = new PlayerIdleRight(this);
		this.idleLeft = new PlayerIdleLeft(this);
		this.state = this.idleLeft;
	}
	//Update
	public void Update(float delta)
	{
		this.state.Update(delta);
	}
	
	//Draw
	public void Draw(float delta){
		this.state.Draw(delta);
	}
}
