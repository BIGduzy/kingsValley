package inputprocessor;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;


import Screens.PlayScreen;


public class PlayerInputProcessor implements InputProcessor{

	
	//fields
	private PlayScreen screen;
	
	
	//constructor
	public PlayerInputProcessor(PlayScreen screen)
	{
		this.screen = screen;
		
	}


	@Override
	public boolean keyDown(int keycode) {
		
		switch(keycode)
		{
			case Keys.RIGHT:
				if (this.screen.getPlayer().getState() == this.screen.getPlayer().getIdleRight()||
					this.screen.getPlayer().getState() == this.screen.getPlayer().getIdleLeft()||
					this.screen.getPlayer().getState() == this.screen.getPlayer().getWalkLeft())
				{
					this.screen.getPlayer().setState(this.screen.getPlayer().getWalkRight());
				}
			break;
			case Keys.LEFT:
				if (this.screen.getPlayer().getState() == this.screen.getPlayer().getIdleLeft() ||
					this.screen.getPlayer().getState() == this.screen.getPlayer().getIdleRight() ||
					this.screen.getPlayer().getState() == this.screen.getPlayer().getWalkRight())
				{
					this.screen.getPlayer().setState(this.screen.getPlayer().getWalkLeft());
				}
			break;
		
		}
		
		return false;
	}


	@Override
	public boolean keyUp(int keycode) {
		
		switch(keycode)
		{
			case Keys.RIGHT:
				if (this.screen.getPlayer().getState() == this.screen.getPlayer().getWalkRight())
				{
					this.screen.getPlayer().setState(this.screen.getPlayer().getIdleRight());
				}
			break;
			case Keys.LEFT:
				if (this.screen.getPlayer().getState() == this.screen.getPlayer().getWalkLeft())
				{
					this.screen.getPlayer().setState(this.screen.getPlayer().getIdleLeft());
				}
			break;
		
		}
		return false;
	}


	@Override
	public boolean keyTyped(char character) {
		return false;
	}


	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}


	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}


	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}


	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}


	@Override
	public boolean scrolled(int amount) {
		return false;
	}
}
