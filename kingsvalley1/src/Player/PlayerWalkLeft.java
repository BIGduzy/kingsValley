package Player;

import animatedSprite.AnimatedSprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;

public class PlayerWalkLeft extends AnimatedSprite{

	//Fields
	private Player player;

	//Constructor
	public PlayerWalkLeft(Player player)
	{
		super(player);
		this.player = player;
		this.flipX = true;
	}

	public void Update(float delta)
	{
		this.player.setPosition(this.player.getPosition().
				add(new Vector2(-this.player.getSpeed(), 0f)));

		if (PlayerManager.CollisionDectectionTopStairsRight() &&
			(Gdx.input.isTouched() || Gdx.input.isKeyPressed(Keys.DOWN)))
		{
			this.player.getWalkDownStairsRight().Initialize();
			this.player.setState(this.player.getWalkDownStairsRight());
		}

		if (PlayerManager.CollisionDetectionBottomStairsLeft() &&
			(Gdx.input.isTouched() || Gdx.input.isKeyPressed(Keys.UP)))
		{
			this.player.setState(this.player.getWalkUpStairsLeft());
		}

		if (PlayerManager.CollisionDetectFallOfFloorLeft())
		{
			this.player.setPosition(new Vector2(this.player.getPosition().x,
												  this.player.getPosition().y +
												  	this.player.getPixelsThroughFloor()));
			this.player.getFallOfFloorLeft().Initialize();
			this.player.setState(this.player.getFallOfFloorLeft());

		}
		super.Update(delta);
	}

	public void Draw(float delta)
	{
		super.Draw(delta);
	}

}