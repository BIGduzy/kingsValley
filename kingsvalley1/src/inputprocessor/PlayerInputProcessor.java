package inputprocessor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;


import Screens.PlayScreen;


public class PlayerInputProcessor implements InputProcessor
{
	//Fields
	private PlayScreen screen;	

	//Constructor
	public PlayerInputProcessor(PlayScreen screen)
	{
		this.screen = screen;
	}

	@Override
	public boolean keyDown(int keycode) 
	{
		switch(keycode)
		{
			case Keys.RIGHT:
				Gdx.app.log("links", this.screen.getPlayer().getState().toString());
				Gdx.app.log("rechts", this.screen.getPlayer().getIdleLeft().toString());
				Gdx.app.log("gelijk", "" + this.screen.getPlayer().getState().equals(this.screen.getPlayer().getIdleLeft()));
				if (this.screen.getPlayer().getState() == (this.screen.getPlayer().getIdleRight()) ||
					this.screen.getPlayer().getState() == (this.screen.getPlayer().getIdleLeft()) ||
					this.screen.getPlayer().getState() == (this.screen.getPlayer().getLeft()))
				{
					this.screen.getPlayer().setState(this.screen.getPlayer().getRight());
				}
				break;	
			case Keys.LEFT:
				if (this.screen.getPlayer().getState() == (this.screen.getPlayer().getIdleLeft()) ||
					this.screen.getPlayer().getState() == (this.screen.getPlayer().getIdleRight())||
					this.screen.getPlayer().getState() == (this.screen.getPlayer().getRight()))
				{
					this.screen.getPlayer().setState(this.screen.getPlayer().getLeft());
				}
				break;	
		}	
		return false;
	}

	@Override
	public boolean keyUp(int keycode) 
	{	
		switch(keycode)
		{
			case Keys.RIGHT:
				if (this.screen.getPlayer().getState().equals(this.screen.getPlayer().getRight()))
				{
					this.screen.getPlayer().setState(this.screen.getPlayer().getIdleRight());
				}
				break;
			case Keys.LEFT:
				if (this.screen.getPlayer().getState().equals(this.screen.getPlayer().getLeft()))
				{
					this.screen.getPlayer().setState(this.screen.getPlayer().getIdleLeft());
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
			this.screen.getPlayer().setState(this.screen.getPlayer().getRight());
		}
		else if (screenX > x_left && screenX < x_left + 100 && screenY > y && screenY < y + 100)
		{
			this.screen.getPlayer().setState(this.screen.getPlayer().getLeft());
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
			this.screen.getPlayer().setState(this.screen.getPlayer().getIdleRight());
		}
		else if (screenX > x_left && screenX < x_left + 100 && screenY > y && screenY < y + 100)
		{
			this.screen.getPlayer().setState(this.screen.getPlayer().getIdleLeft());
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
			this.screen.getPlayer().setState(this.screen.getPlayer().getIdleRight());
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