package level;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.nick.kingsvalley1.KingsValley1;

public class Level {

	//fields
	private KingsValley1 game;
	private String levelPath;
	private ArrayList<String> lines;
	
	//constructor
	public Level(KingsValley1 game,int levelIndex)
	{
		this.game = game;
		this.levelPath = String.format("data/%s",levelIndex);
	}
	
	private void LoadAssets()
	{
		this.lines = new ArrayList<String>();
		FileHandle handle = Gdx.files.internal(this.levelPath);
	}
}
