package inputprocessor;

import level.Level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;


import Player.Player;
import Player.PlayerIdleJumpRight;
import Player.PlayerIdleUpStairsRight;


public class PlayerInputProcessor implements InputProcessor
{
	//Fields
	private Player player;

	//Constructor
	public PlayerInputProcessor(Level level)
	{
		this.player = level.getPlayer();
	}

	@Override
	public boolean keyDown(int keycode) 
	{
		switch(keycode)
		{
			case Keys.RIGHT:
				if (this.player.getState().equals(this.player.getIdleRight())||
					this.player.getState().equals(this.player.getIdleLeft()) ||
					this.player.getState().equals(this.player.getLeft()) )
				{
					this.player.setState(this.player.getRight());
				}
				else if ( this.player.getState().equals(this.player.getIdleUpStairsRight()) ||
						  this.player.getState().equals(this.player.getIdleDownStairsRight()))
				{
					this.player.getWalkUpStairsRight().Initialize();
					this.player.setState(this.player.getWalkUpStairsRight());
				}
				break;	
			case Keys.LEFT:
				if (this.player.getState().equals(this.player.getIdleLeft()) ||
					this.player.getState().equals(this.player.getIdleRight())||
					this.player.getState().equals(this.player.getRight()))
				{
					this.player.setState(this.player.getLeft());
				}
				else if (this.player.getState().equals(this.player.getIdleUpStairsRight()))
				{
					this.player.getWalkDownStairsRight().Initialize();
					this.player.setState(this.player.getWalkDownStairsRight());
				}
				break;
			case Keys.SPACE:
				if (this.player.getState().equals(this.player.getRight()))
				{
					this.player.getJumpRight().Initialize();
					this.player.setState(this.player.getJumpRight());
				}
				else if (this.player.getState().equals(this.player.getLeft()))
				{
					this.player.getJumpLeft().Initialize();
					this.player.setState(this.player.getJumpLeft());
				}
				else if (this.player.getState().equals(this.player.getIdleRight()))
				{
					this.player.getIdleJumpRight().Initialize();
					this.player.setState(this.player.getIdleJumpRight());
				}
				else if (this.player.getState().equals(this.player.getIdleLeft()))
				{
					this.player.getIdleJumpLeft().Initialize();
					this.player.setState(this.player.getIdleJumpLeft());
				}

		}	
		return false;
	}

	@Override
	public boolean keyUp(int keycode) 
	{	
		switch(keycode)
		{
			case Keys.RIGHT:
				if (this.player.getState().equals(this.player.getRight()))
				{
					this.player.setState(this.player.getIdleRight());
				}
				else if (this.player.getState().equals(this.player.getWalkUpStairsRight()))
				{
					this.player.setState(this.player.getIdleUpStairsRight());
				}
				break;
			case Keys.LEFT:
				if (this.player.getState().equals(this.player.getLeft()))
				{
					this.player.setState(this.player.getIdleLeft());
				}
				else if (this.player.getState().equals(this.player.getWalkDownStairsRight()))
				{
					this.player.setState(this.player.getIdleDownStairsRight());
				}
				break;
		}	
		return false;
	}

	@Override
	public boolean keyTyped(char character) 
	{
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button)
	{
		int x_right = 1200;
		int x_left = 0;
		int y = 600;
		if ( screenX > x_right  && screenX < x_right + 100  && screenY > y && screenY < y + 100)
		{
			this.player.setState(this.player.getRight());
		}
		else if (screenX > x_left && screenX < x_left + 100 && screenY > y && screenY < y + 100)
		{
			this.player.setState(this.player.getLeft());
		}
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button)
	{
		int x_right = 1200;
		int x_left = 0;
		int y = 600;
		if ( screenX > x_right  && screenX < x_right + 100  && screenY > y && screenY < y + 100)
		{
			this.player.setState(this.player.getIdleRight());
		}
		else if (screenX > x_left && screenX < x_left + 100 && screenY > y && screenY < y + 100)
		{
			this.player.setState(this.player.getIdleLeft());
		}
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) 
	{
		int x = 1200;
		int y = 600;
		if ( screenX > x  && screenX < x + 10  && screenY > y && screenY < y + 100)
		{
			this.player.setState(this.player.getIdleRight());
		}
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY)
	{

		return false;
	}

	@Override
	public boolean scrolled(int amount) 
	{
		return false;
	}
}