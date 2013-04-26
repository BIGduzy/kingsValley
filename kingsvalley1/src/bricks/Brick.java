package bricks;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.nick.kingsvalley1.KingsValley1;

import image.Image;

public class Brick extends Image
{
	//Field
	private char character;

	//Properties
	public char getCharacter() {
		return character;
	}
	public void setCharacter(char character) {
		this.character = character;
	}

	//Constructor
	public Brick(KingsValley1 game, Vector2 position, TextureRegion region, char character)
	{
		super(game, position, region);
		this.setCharacter(character);
	}

	//Draw
	public void Draw(float delta)
	{
		super.Draw(delta);
	}
}