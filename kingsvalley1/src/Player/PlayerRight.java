package Player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;

import AnimatedSprite.AnimatedSprite;

public class PlayerRight extends AnimatedSprite{

	//Fields
	private Player player;

	//Constructor
	public PlayerRight(Player player)
	{
		super(player);
		this.player = player;
	}

	public void Update(float delta)
	{
		this.player.setPosition(this.player.getPosition().
				add(new Vector2(this.player.getSpeed(), 0f)));

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

		super.Update(delta);
	}

	public void Draw(float delta)
	{
		super.Draw(delta);
	}

}