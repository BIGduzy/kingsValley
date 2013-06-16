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
				if (this.player.getState() == this.player.getIdleRight()||
					this.player.getState() == this.player.getIdleLeft() ||
					this.player.getState() == this.player.getWalkLeft()) 
				{
					this.player.setState(this.player.getWalkRight());
				}
				else if ( this.player.getState() == this.player.getIdleUpStairsRight() ||
						  this.player.getState() == this.player.getIdleDownStairsRight())
				{
					this.player.getWalkUpStairsRight().Initialize();
					this.player.setState(this.player.getWalkUpStairsRight());
				}
				else if (this.player.getState() == this.player.getIdleUpStairsLeft() ||
						 this.player.getState() == this.player.getIdleDownStairsLeft())
				{
					this.player.getWalkDownStairsLeft().Initialize();
					this.player.setState(this.player.getWalkDownStairsLeft());
				}
				break;	
			case Keys.LEFT:
				if (this.player.getState() == this.player.getIdleLeft() ||
					this.player.getState() == this.player.getIdleRight()||
					this.player.getState() == this.player.getWalkRight())
				{
					this.player.setState(this.player.getWalkLeft());
				}
				else if (this.player.getState() == this.player.getIdleUpStairsRight() ||
						 this.player.getState() == this.player.getIdleDownStairsRight())
				{
					this.player.getWalkDownStairsRight().Initialize();
					this.player.setState(this.player.getWalkDownStairsRight());
				}
				else if (this.player.getState() == this.player.getIdleDownStairsLeft() ||
						this.player.getState() == this.player.getIdleUpStairsLeft())
				{
					this.player.getWalkUpStairsLeft().Initialize();
					this.player.setState(this.player.getWalkUpStairsLeft());
				}
				break;
			case Keys.SPACE:
				if (this.player.getState() == this.player.getWalkRight() ||
					this.player.getState() == this.player.getIdleRightNoLineairMovement())
				{
					this.player.getJumpRight().Initialize();
					this.player.setState(this.player.getJumpRight());
				}
				else if (this.player.getState() == this.player.getWalkLeft() ||
						 this.player.getState() == this.player.getIdleLeftNoLineairMovement())
				{
					this.player.getJumpLeft().Initialize();
					this.player.setState(this.player.getJumpLeft());
				}
				else if (this.player.getState() == this.player.getIdleRight())
				{
					this.player.getIdleJumpRight().Initialize();
					this.player.setState(this.player.getIdleJumpRight());
				}
				else if (this.player.getState() == this.player.getIdleLeft())
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
				if (this.player.getState() == this.player.getWalkRight())
				{
					this.player.setState(this.player.getIdleRight());
				}
				else if (this.player.getState() == this.player.getWalkUpStairsRight())
				{
					this.player.setState(this.player.getIdleUpStairsRight());
				}
				else if (this.player.getState() == this.player.getWalkDownStairsLeft())
				{
					this.player.getIdleDownStairsLeft().Initialize();
					this.player.setState(this.player.getIdleDownStairsLeft());
				}
				else if (this.player.getState() == this.player.getIdleRightNoLineairMovement())
				{
					this.player.setState(this.player.getIdleRight());
				}
				break;
			case Keys.LEFT:
				if (this.player.getState() == this.player.getWalkLeft())
				{
					this.player.setState(this.player.getIdleLeft());
				}
				else if (this.player.getState() == this.player.getWalkDownStairsRight())
				{
					this.player.setState(this.player.getIdleDownStairsRight());
				}
				else if (this.player.getState() == this.player.getWalkUpStairsLeft())
				{
					this.player.setState(this.player.getIdleUpStairsLeft());
				}
				else if (this.player.getState() == this.player.getIdleLeftNoLineairMovement())
				{
					this.player.setState(this.player.getIdleLeft());
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
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button)
	{
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) 
	{
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