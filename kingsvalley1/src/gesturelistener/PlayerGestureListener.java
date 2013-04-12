package gesturelistener;

import Screens.PlayScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;

import Player.Player;


public class PlayerGestureListener implements GestureListener
{
	//Fields
	private PlayScreen screen;
	private Player player;
	private Vector2 flingVector;


	//Constructor
	public PlayerGestureListener(PlayScreen screen)
	{
		this.screen = screen;
		this.player = screen.getPlayer();
	}

	@Override
	public boolean touchDown(float x, float y, int pointer, int button)
	{
		return false;
	}

	@Override
	public boolean tap(float x, float y, int count, int button)
	{
		if ( this.player.getState().equals(this.player.getRight()))
		{
			this.player.setState(this.player.getIdleRight());
		}
		else if ( this.player.getState().equals(this.player.getLeft()))
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
		Gdx.app.log("flingAngle", Float.toString(this.flingVector.angle()));

		if (velocityX > 0)
		{
			if ( this.flingVector.angle() >= 0 && this.flingVector.angle() < 30 ||
				 this.flingVector.angle() > 330 && this.flingVector.angle() <= 360)
			{
				this.player.setState(this.player.getRight());
			}
			else if (this.flingVector.angle() >= 30 && this.flingVector.angle() < 60)
			{
				//this.player.setState(this.player.());
			}
		}
		else if ( velocityX < 0)
		{
			this.player.setState(this.player.getLeft());
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
