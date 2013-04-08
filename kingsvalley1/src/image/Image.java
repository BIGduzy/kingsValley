package image;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.nick.kingsvalley1.KingsValley1;

public class Image {

	//Fields
		private KingsValley1 game;
		private Vector2 position;
		private String imageName;
		private Texture texture;

		//Properties
		public Vector2 getPosition()
		{
			return this.position;
		}
		public Texture getTexture()
		{
			return this.texture;
		}

		//Constructor
		public Image(KingsValley1 game, Vector2 position, String imageName )
		{
			this.game = game;
			this.position = position;
			this.imageName = imageName;	
			this.texture = new Texture(this.imageName);
		}

		public void Draw(float delta)
		{
			this.game.getBatch().draw(this.texture, this.position.x, this.position.y);
		}
}
