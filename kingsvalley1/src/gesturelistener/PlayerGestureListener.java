package gesturelistener;

import level.Level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;

import Player.Player;


public class PlayerGestureListener implements GestureListener
{
	//Fields
	private Player player;
	private Vector2 flingVector;


	//Constructor
	public PlayerGestureListener(Level level)
	{
		this.player = level.getPlayer();
	}

	@Override
	public boolean touchDown(float x, float y, int pointer, int button)
	{
		if (this.player.getState() == this.player.getWalkUpStairsRight())
		{
			this.player.setState(this.player.getIdleUpStairsRight());
		}
		else if (this.player.getState() == this.player.getWalkDownStairsRight())
		{
			this.player.setState(this.player.getIdleDownStairsRight());
		}
		return false;
	}

	@Override
	public boolean tap(float x, float y, int count, int button)
	{
		if ( this.player.getState() == (this.player.getRight()))
		{
			this.player.setState(this.player.getIdleRight());
		}
		else if ( this.player.getState() == (this.player.getLeft()))
		{
			this.player.setState(this.player.getIdleLeft());
		}
		return false;
	}

	@Override
	public boolean longPress(float x, float y)
	{
		return false;
	}

	@Override
	public boolean fling(float velocityX, float velocityY, int button) 
	{
		this.flingVector = new Vector2(velocityX, velocityY);
		//Gdx.app.log("flingAngle", Float.toString(this.flingVector.angle()));
		if (this.player.getState() != this.player.getWalkUpStairsRight()   && 
			this.player.getState() != this.player.getWalkDownStairsRight() &&
			this.player.getState() != this.player.getJumpLeft()            &&
			this.player.getState() != this.player.getJumpRight()			 &&
			this.player.getState() != this.player.getIdleJumpRight()		 &&
			this.player.getState() != this.player.getIdleJumpLeft())
			{
				if (velocityX > 0)
				{
					if ( this.flingVector.angle() >= 0 && this.flingVector.angle() < 30 ||
						 this.flingVector.angle() > 330 && this.flingVector.angle() <= 360)
					{
						if (this.player.getState() == this.player.getIdleUpStairsRight() ||
							this.player.getState() == this.player.getIdleDownStairsRight())
						{
							this.player.setState(this.player.getWalkUpStairsRight());
						}
						else
						{
							this.player.setState(this.player.getRight());
						}
					}
					else if (this.flingVector.angle() >= 300 && this.flingVector.angle() <= 330)
					{
						if (this.player.getState() == this.player.getRight() ||
						    this.player.getState() == this.player.getLeft()	 ||
						    this.player.getState() == this.player.getIdleRight() ||
						    this.player.getState() == this.player.getIdleLeft())
						{
							this.player.getJumpRight().Initialize();
							this.player.setState(this.player.getJumpRight());
						}						
					}
					else if (this.flingVector.angle() > 270 && this.flingVector.angle() < 300)
					{
						if (this.player.getState() == this.player.getRight() ||
							    this.player.getState() == this.player.getLeft()  ||
							    this.player.getState() == this.player.getIdleRight() ||
							    this.player.getState() == this.player.getIdleLeft())
						{
							this.player.getIdleJumpRight().Initialize();
							this.player.setState(this.player.getIdleJumpRight());
						}
					}
				}
				else if ( velocityX < 0)
				{
					if ( this.flingVector.angle() >= 150 && this.flingVector.angle() < 210)
					{
						if ( this.player.getState() == this.player.getIdleUpStairsRight() ||
							 this.player.getState() == this.player.getIdleDownStairsRight())
						{
							this.player.setState(this.player.getWalkDownStairsRight());
						}
						else
						{
							this.player.setState(this.player.getLeft());
						}
					}
					else if (this.flingVector.angle() >= 210 && this.flingVector.angle() <= 240)
					{
						if (this.player.getState() == this.player.getRight() ||
							    this.player.getState() == this.player.getLeft() ||
							    this.player.getState() == this.player.getIdleRight() ||
							    this.player.getState() == this.player.getIdleLeft())
						{
							this.player.getJumpLeft().Initialize();
							this.player.setState(this.player.getJumpLeft());
						}
					}
					else if (this.flingVector.angle() >= 240 && this.flingVector.angle() < 270)
					{
						if (this.player.getState() == this.player.getRight() ||
							    this.player.getState() == this.player.getLeft()  ||
							    this.player.getState() == this.player.getIdleRight() ||
							    this.player.getState() == this.player.getIdleLeft())
						{
							this.player.getIdleJumpLeft().Initialize();
							this.player.setState(this.player.getIdleJumpLeft());
						}
					}
				}			
			}	
		return false;
	}

	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) 
	{
		return false;
	}

	@Override
	public boolean zoom(float initialDistance, float distance) 
	{
		return false;
	}

	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2,
			Vector2 pointer1, Vector2 pointer2) 
	{
		return false;
	}	
}
