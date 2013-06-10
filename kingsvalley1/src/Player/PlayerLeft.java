package Player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;

import AnimatedSprite.AnimatedSprite;

public class PlayerLeft extends AnimatedSprite{

	//Fields
	private Player player;

	//Constructor
	public PlayerLeft(Player player)
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
		super.Update(delta);
	}

	public void Draw(float delta)
	{
		super.Draw(delta);
	}

}