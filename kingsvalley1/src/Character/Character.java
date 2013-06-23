package Character;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.nick.kingsvalley1.KingsValley1;

import image.Image;

public class Character extends Image implements IBuildingBlock {

	public Character(KingsValley1 game, Vector2 position, TextureRegion region) {
		super(game, position, region);
	}

}
