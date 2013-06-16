package Player;

import animatedSprite.AnimatedSprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;


public class PlayerWalkRight extends AnimatedSprite{

	//Fields
	private Player player;

	//Constructor
	public PlayerWalkRight(Player player)
	{
		super(player);
		this.player = player;
	}

	public void Inititialize()
	{
		this.player.getCollisionRectStairs().setWidth(20f);
		this.player.getCollisionRectStairs().setX(this.player.getCollisionRectStairs().x);
	}

	public void Update(float delta)
	{
		this.player.setPosition(this.player.getPosition().
				add(new Vector2(this.player.getSpeed(), 0f)));

		if (PlayerManager.CollisionDetectionWallInFrontRight())
		{
			this.player.setPosition(this.player.getPosition().
					add(this.player.getPixelsInWallRight(), 0f));
			this.player.setState(this.player.getIdleRightNoLineairMovement());			
		}

		if (PlayerManager.CollisionDectectionTopStairsLeft() &&
				(Gdx.input.isTouched() || Gdx.input.isKeyPressed(Keys.DOWN)))
			{
				this.player.setState(this.player.getWalkDownStairsLeft());
			}

		/******************************************************************
		 * Check of er een botsing is tussen de rectangle van de player *
		 * en de rectangle van de onderkant van de trap					  *
		 ******************************************************************/
		if (PlayerManager.CollisionDetectionBottomStairsRight() &&
			(Gdx.input.isTouched() || Gdx.input.isKeyPressed(Keys.UP)))
		{
			this.player.setState(this.player.getWalkUpStairsRight());
		}

		if (PlayerManager.CollisionDetectFallOfFloorRight())
		{
			this.player.getFallOfFloorRight().Initialize();
			this.player.setState(this.player.getFallOfFloorRight());

		}

		super.Update(delta);
	}

	public void Draw(float delta)
	{
		super.Draw(delta);
	}

}