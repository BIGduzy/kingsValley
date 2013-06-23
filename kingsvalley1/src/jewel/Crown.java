package jewel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.nick.kingsvalley1.KingsValley1;

public class Crown
{
	//Fields
	private KingsValley1 game;
	private Vector2 position;
	private Map<String, TextureRegion> region;
	private ArrayList<Ray> rays;
	private Map<String, Color> colors;
	private Color color;
	private float timer;

	//Constructor
	public Crown(KingsValley1 game, Vector2 position, Map<String, TextureRegion> region)
	{
		this.game = game;
		this.position = position;
		this.region = region;
		this.rays = new ArrayList<Ray>();
		this.rays.add(new Ray(this.game,
							  new Vector2(-16f, 0f).add(this.position),
							  this.region.get("crownPartLeft")));
		this.rays.add(new Ray(this.game,
							  new Vector2(0f, -16f).add(this.position),
							  this.region.get("crownPartMiddle")));
		this.rays.add(new Ray(this.game,
							  new Vector2(16f, 0f).add(this.position),
							  this.region.get("crownPartRight")));
		this.colors = new HashMap<String, Color>();
		this.colors.put("white", new Color(0.969f, 0.969f, 0.969f, 1f));
		this.colors.put("yellow", new Color(0.847f, 0.847f, 0.125f, 1f));
		this.colors.put("transparant", new Color(0.969f, 0.969f, 0.969f, 0f));
		this.color = this.colors.get("white");		
	}

	public void Update(float delta)
	{
		this.timer += delta * 40;
		if (this.timer < 2f)
		{
			this.color = this.colors.get("transparant");
		}
		else if (this.timer < 4f)
		{
			this.color = this.colors.get("white");
		}
		else if (this.timer < 8f)
		{
			this.color = this.colors.get("yellow");
		}
		else
		{
			this.timer = 0f;
		}
	}

	public void Draw(float delta)
	{
		this.game.getBatch().setColor(this.color);
		for (Ray ray : this.rays)
		{
			ray.Draw(delta);
		}

	}
}