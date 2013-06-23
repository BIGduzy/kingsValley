package level;

import floor.Floor;
import gesturelistener.PlayerGestureListener;
import inputprocessor.PlayerInputProcessor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import jewel.Jewel;

import stairsLeft.StairsLeft;
import stairsRight.StairsRight;

import Player.Player;
import Player.PlayerManager;
import bricks.Brick;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;

import com.nick.kingsvalley1.KingsValley1;

public class Level
{
	//Field
	private KingsValley1 game;
	private String levelPath;
	private ArrayList<String> lines;
	private int height, width;
	private Texture spriteSheet;
	private Map<String, TextureRegion> region;
	private Brick bricks[][];
	private Player player;
	private PlayerInputProcessor inputProcessor;
	private PlayerGestureListener gestureListener;
	private InputMultiplexer multiplexer;
	private ArrayList<StairsRight> stairsRight;
	private ArrayList<StairsLeft> stairsLeft;
	private ArrayList<Floor> floors;
	private ArrayList<Jewel> jewels;
	private static TextureRegion collisionTexture;
	private Music masterMelody;
	private ArrayList<Brick> score;
	private ArrayList<Brick> highScore;

	//Properties
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}

	public static TextureRegion getCollisionTexture() {
		return collisionTexture;
	}

	public ArrayList<Brick> getScore() {
		return score;
	}
	public void setScore(ArrayList<Brick> score) {
		this.score = score;
	}
	public ArrayList<Brick> getHighScore() {
		return highScore;
	}
	public void setHighScore(ArrayList<Brick> highScore) {
		this.highScore = highScore;
	}
	public KingsValley1 getGame() {
		return game;
	}
	public void setGame(KingsValley1 game) {
		this.game = game;
	}
	public Map<String, TextureRegion> getRegion() {
		return region;
	}
	public void setRegion(Map<String, TextureRegion> region) {
		this.region = region;
	}
	//Constructor
	public Level(KingsValley1 game, int levelIndex)
	{
		this.game = game;

		this.jewels = new ArrayList<Jewel>();
		this.score = new ArrayList<Brick>();
		this.highScore = new ArrayList<Brick>();

		this.levelPath = "data/" + levelIndex + ".txt";
		try {
			this.LoadAssets();
		} catch (IOException e) {
			e.getMessage();
		}

		//Stop alle rechtertrappen in een arraylist object
		this.stairsRight = new ArrayList<StairsRight>();

		//Stop alle linkertrappen in een arraylist object
		this.stairsLeft = new ArrayList<StairsLeft>();

		this.floors = new ArrayList<Floor>();

		this.DetectStairsRight();
		this.DetectStairsLeft();
		this.DetectFloors();

		PlayerManager.setJewels(this.jewels);
		PlayerManager.setPlayer(this.player);
		PlayerManager.setStairsRight(this.stairsRight);
		PlayerManager.setStairsLeft(this.stairsLeft);
		PlayerManager.setFloors(this.floors);


		//Inputprocessor zorgt voor alle inputdetectie
		//-----------------------------------------------------
		this.inputProcessor = new PlayerInputProcessor(this);
		//-----------------------------------------------------

		//Met een gestureListener kun je andere scherminput afvangen zoals de fling en de pinch
		//-----------------------------------------------------
		this.gestureListener = new PlayerGestureListener(this);
		//----------------------------------------------------

		//Met een multiplexer kun je zowel de inputprocessor als de gesturelistener gebruiken
		this.multiplexer = new InputMultiplexer();
		this.multiplexer.addProcessor(this.inputProcessor);
		this.multiplexer.addProcessor(new GestureDetector(this.gestureListener));

		//Voeg de multiplexer toe aan setInputProcessor
		Gdx.input.setInputProcessor(this.multiplexer);

		this.masterMelody = Gdx.audio.newMusic(Gdx.files.internal("data/Sounds/masterMelody.mp3"));
		this.masterMelody.play();
		this.masterMelody.setLooping(true);
		this.masterMelody.setVolume(0.6f);
	}

	private void LoadAssets() throws IOException
	{
		this.spriteSheet = new Texture("data/SpriteSheet.png");
		this.region = new HashMap<String, TextureRegion>();
		this.region.put("brick", new TextureRegion(this.spriteSheet, 0, 0, 16, 16));
		this.region.put("fundament", new TextureRegion(this.spriteSheet, 32, 0, 16, 16));
		this.region.put("brick_transparent", new TextureRegion(this.spriteSheet, 0, 16, 16, 16));
		this.region.put("traptopright01", new TextureRegion(this.spriteSheet, 100, 16, 16, 16));
		this.region.put("traptopleft01", new TextureRegion(this.spriteSheet, 68, 16, 16, 16));
		this.region.put("trapRight01", new TextureRegion(this.spriteSheet, 100, 0, 16, 16));
		this.region.put("trapRight02", new TextureRegion(this.spriteSheet, 116, 0, 16,16));
		this.region.put("trapTopRight02", new TextureRegion(this.spriteSheet, 116, 16, 16, 16));
		this.region.put("trapLeft01", new TextureRegion(this.spriteSheet, 68, 0, 16, 16));
		this.region.put("trapLeft02", new TextureRegion(this.spriteSheet, 84, 0, 16, 16));
		this.region.put("trapTopLeft02", new TextureRegion(this.spriteSheet, 84, 16, 16, 16));
		collisionTexture = new TextureRegion(this.spriteSheet, 16, 0, 16, 16);

		// TextureRegion voor de Jewel
		this.region.put("jewel", new TextureRegion(this.spriteSheet, 16, 80, 16, 16));
		this.region.put("crownPartLeft", new TextureRegion(this.spriteSheet, 112, 80, 16, 16));
		this.region.put("crownPartMiddle", new TextureRegion(this.spriteSheet, 80, 80, 16, 16));
		this.region.put("crownPartRight", new TextureRegion(this.spriteSheet, 48, 80, 16, 16));

		//Characters
		this.region.put("c", new TextureRegion(this.spriteSheet, 80, 128, 16, 16));
		this.region.put("K", new TextureRegion(this.spriteSheet, 128, 112, 16, 16));
		this.region.put("O", new TextureRegion(this.spriteSheet, 32, 128, 16, 16));
		this.region.put("N", new TextureRegion(this.spriteSheet, 16, 128, 16, 16));
		this.region.put("A", new TextureRegion(this.spriteSheet, 16, 112, 16, 16));
		this.region.put("M", new TextureRegion(this.spriteSheet, 0, 128, 16, 16));
		this.region.put("I", new TextureRegion(this.spriteSheet, 112, 112, 16, 16));
		this.region.put("P", new TextureRegion(this.spriteSheet, 48, 128, 16, 16));
		this.region.put("Y", new TextureRegion(this.spriteSheet, 128, 128, 16, 16));
		this.region.put("R", new TextureRegion(this.spriteSheet, 64, 128, 16, 16));
		this.region.put("-", new TextureRegion(this.spriteSheet, 64, 112, 16, 16));
		this.region.put("D", new TextureRegion(this.spriteSheet, 48, 112, 16, 16));
		this.region.put("o", new TextureRegion(this.spriteSheet, 16, 96, 16, 16));
		this.region.put("C", new TextureRegion(this.spriteSheet, 32, 112, 16, 16));
		this.region.put("S", new TextureRegion(this.spriteSheet, 96, 128, 16, 16));
		this.region.put("E", new TextureRegion(this.spriteSheet, 80, 112, 16, 16));
		this.region.put("T", new TextureRegion(this.spriteSheet, 112, 128, 16, 16));
		this.region.put("H", new TextureRegion(this.spriteSheet, 96, 112, 16, 16));

		//Numbers
		this.region.put("0", new TextureRegion(this.spriteSheet, 0, 96, 16, 16));
		this.region.put("1", new TextureRegion(this.spriteSheet, 16, 96, 16, 16));
		this.region.put("2", new TextureRegion(this.spriteSheet, 32, 96, 16, 16));
		this.region.put("3", new TextureRegion(this.spriteSheet, 48, 96, 16, 16));
		this.region.put("4", new TextureRegion(this.spriteSheet, 64, 96, 16, 16));
		this.region.put("5", new TextureRegion(this.spriteSheet, 80, 96, 16, 16));
		this.region.put("6", new TextureRegion(this.spriteSheet, 96, 96, 16, 16));
		this.region.put("7", new TextureRegion(this.spriteSheet, 112, 96, 16, 16));
		this.region.put("8", new TextureRegion(this.spriteSheet, 128, 96, 16, 16));
		this.region.put("9", new TextureRegion(this.spriteSheet, 0, 112, 16, 16));

		//Alle stenen omdraaien
		for (Map.Entry<String, TextureRegion> e : this.region.entrySet())
		{
			e.getValue().flip(false, true);
		}

		this.lines = new ArrayList<String>();
		FileHandle handle = Gdx.files.internal(this.levelPath);
		BufferedReader reader = new BufferedReader(new InputStreamReader(handle.read()));
		String line = reader.readLine();
		this.width = line.length();
		//Gdx.app.log("line", line);

		while ( line != null)
		{
			lines.add(line);
			line = reader.readLine();
			//Gdx.app.log("line", line);	
		}
		this.height = this.lines.size();

		this.bricks = new Brick[this.width][this.height];

		//Doorlopen van de regels
		for (int i=0; i< this.height; i++)
		{
			//Doorlopen van alle tekens van een regel
			for (int j=0; j < this.width; j++)
			{
				//Nu weten we voor een i,j combinatie wat voor teken het is.
				char brickElement = this.lines.get(i).charAt(j);
				this.bricks[j][i] = this.LoadAssets(brickElement, j * 16, i * 16);
			}			
		}				
	}

	private Brick LoadAssets(char brickElement, int i, int j)
	{
		switch ( brickElement)
		{
			case '1':
				return new Brick(this.game, new Vector2(i,j), this.region.get("brick"), '1');
			case '2':
				return new Brick(this.game, new Vector2(i,j), this.region.get("fundament"), '2');
			case '3':
				return new Brick(this.game, new Vector2(i,j), this.region.get("brick_transparent"), '3');
			case '.':
				return new Brick(this.game, new Vector2(i,j), this.region.get("brick_transparent"), '.');
			case '+':
				this.player = new Player(this.game, new Vector2(i,j), 1f);
				return new Brick(this.game, new Vector2(i,j), this.region.get("brick_transparent"), '+');
			case 's':
				return new Brick(this.game, new Vector2(i,j), this.region.get("traptopright01"), 's');
			case 'x':
				return new Brick(this.game, new Vector2(i,j), this.region.get("traptopleft01"), 'x');
			case 'g':
				this.jewels.add(new Jewel(this.game, new Vector2(i,j),
									new Color(0.125f, 0.847f, 0.125f, 1f), this.region));
				return new Brick(this.game, new Vector2(i,j), this.region.get("brick_transparent"), 'g');
			case 'b':
				this.jewels.add(new Jewel(this.game, new Vector2(i,j),
									new Color(0.125f, 0.125f, 0.968f, 1f), this.region));
				return new Brick(this.game, new Vector2(i,j), this.region.get("brick_transparent"), 'b');
			case 'r':
				this.jewels.add(new Jewel(this.game, new Vector2(i,j),
									new Color(0.847f, 0.282f, 0.690f, 1f), this.region));
				return new Brick(this.game, new Vector2(i,j), this.region.get("brick_transparent"), 'r');
			case 't':
				this.jewels.add(new Jewel(this.game, new Vector2(i,j),
									new Color(0.243f, 0.847f, 0.969f, 1f), this.region));
				return new Brick(this.game, new Vector2(i,j), this.region.get("brick_transparent"), 't');

			//Character
			case 'c':
				return new Brick(this.game, new Vector2(i,j), this.region.get("c"), 'c');
			case 'K':
				return new Brick(this.game, new Vector2(i,j), this.region.get("K"), 'K');
			case 'O':
				return new Brick(this.game, new Vector2(i,j), this.region.get("O"), 'O');
			case 'N':
				return new Brick(this.game, new Vector2(i,j), this.region.get("N"), 'N');
			case 'A':
				return new Brick(this.game, new Vector2(i,j), this.region.get("A"), 'A');
			case 'M':
				return new Brick(this.game, new Vector2(i,j), this.region.get("M"), 'M');
			case 'I':
				return new Brick(this.game, new Vector2(i,j), this.region.get("I"), 'I');
			case 'P':
				return new Brick(this.game, new Vector2(i,j), this.region.get("P"), 'P');
			case 'Y':
				return new Brick(this.game, new Vector2(i,j), this.region.get("Y"), 'Y');
			case 'R':
				return new Brick(this.game, new Vector2(i,j), this.region.get("R"), 'R');
			case 'D':
				return new Brick(this.game, new Vector2(i,j), this.region.get("D"), 'D');
			case '-':
				return new Brick(this.game, new Vector2(i,j), this.region.get("-"), '-');
			case 'o':
				return new Brick(this.game, new Vector2(i,j), this.region.get("o"), 'o');
			case 'C':
				return new Brick(this.game, new Vector2(i,j), this.region.get("C"), 'C');
			case 'S':
				return new Brick(this.game, new Vector2(i,j), this.region.get("S"), 'S');
			case 'E':
				return new Brick(this.game, new Vector2(i,j), this.region.get("E"), 'E');
			case 'T':
				return new Brick(this.game, new Vector2(i,j), this.region.get("T"), 'T');
			case 'H':
				return new Brick(this.game, new Vector2(i,j), this.region.get("H"), 'H');
			case '0':
				return new Brick(this.game, new Vector2(i,j), this.region.get("0"), '0');
			case 'y':
				return new Brick(this.game, new Vector2(i,j), this.region.get("y"), 'y');
			case 'z':
				return new Brick(this.game, new Vector2(i,j), this.region.get("z"), 'z');
			case '4':
				return new Brick(this.game, new Vector2(i,j), this.region.get("4"), '4');
			case '5':
				return new Brick(this.game, new Vector2(i,j), this.region.get("5"), '5');
			case '6':
				return new Brick(this.game, new Vector2(i,j), this.region.get("6"), '6');
			case '7':
				return new Brick(this.game, new Vector2(i,j), this.region.get("7"), '7');
			case '8':
				return new Brick(this.game, new Vector2(i,j), this.region.get("8"), '8');
			case '9':
				return new Brick(this.game, new Vector2(i,j), this.region.get("9"), '9');
			case '/':
				this.score.add(new Brick(this.game, new Vector2(i,j), this.region.get("0"), '/'));
				return new Brick(this.game, new Vector2(i,j), this.region.get("brick_transparent"), '/');
			case '!':
				this.highScore.add(new Brick(this.game, new Vector2(i,j), this.region.get("0"), '!'));
				return new Brick(this.game, new Vector2(i,j), this.region.get("brick_transparent"), '!');


			default:
				return new Brick(this.game, new Vector2(i,j), this.region.get("brick_transparent"), '.');

		}

	}

	private void DetectStairsRight()
	{
		for (int i = 0; i < this.height; i++)
		{
			for (int j = 0; j < this.width; j++)
			{
				if (this.bricks[j][i].getCharacter() == 's')
				{
					int amountOfSteps = 0;
					int horizontal = j + 1;
					for (int k = (i+1); k < this.height; k++)
					{
						horizontal--;
						if (this.bricks[horizontal][k].getCharacter() == '1')
						{
							amountOfSteps = k - i - 1;
							break;
						}
					}
					this.stairsRight.add(new StairsRight(this.game,
														 new Vector2(j * 16, i * 16),
														 amountOfSteps,
														 this.region.get("trapRight01"),
														 this.region.get("trapRight02"),
														 this.region.get("trapTopRight02")));
				}
			}
		}
	}

	private void DetectStairsLeft()
	{
		for (int i = 0; i < this.height; i++)
		{
			for (int j = 0; j < this.width; j++)
			{
				if (this.bricks[j][i].getCharacter() == 'x')
				{
					int amountOfSteps = 0;
					int horizontal = j;
					for (int k = (i+1); k < this.height; k++)
					{
						horizontal++;
						if (this.bricks[horizontal][k].getCharacter() == '1')
						{
							amountOfSteps = k - i - 1;
							break;
						}
					}
					this.stairsLeft.add(new StairsLeft(this.game,
														 new Vector2(j * 16, i * 16),
														 amountOfSteps,
														 this.region.get("trapLeft01"),
														 this.region.get("trapLeft02"),
														 this.region.get("trapTopLeft02")));
				}
			}
		}
	}

	private void DetectFloors()
	{
		for (int i = 0; i < this.height; i++)
		{
			int amountOfBricks = 0;
			Vector2 position = Vector2.Zero;

			for (int j = 0; j < this.width; j++)
			{
				if (this.bricks[j][i].getCharacter() == '1' ||
					this.bricks[j][i].getCharacter() == 's' ||
					this.bricks[j][i].getCharacter() == 'x' ||
					this.bricks[j][i].getCharacter() == '3')
				{
					if (amountOfBricks == 0)
					{
						position = new Vector2(j * 16, i * 16);
					}
					amountOfBricks++;
				}
				else
				{
					if (amountOfBricks > 0)
					{
						this.floors.add(new Floor(this.game, position, amountOfBricks));
						amountOfBricks = 0;
						position = Vector2.Zero;
					}
				}
			}
		}		
	}

	public void Update(float delta)
	{
		this.player.Update(delta);
		for (Jewel jewel : this.jewels)
		{
			jewel.Update(delta);
		}
		PlayerManager.setLevel(this);
	}


	public void Draw(float delta)
	{
		for (int i=0; i<this.height; i++)
		{
			for (int j=0; j < this.width; j++)
			{
				this.bricks[j][i].Draw(delta);
			}				
		}

		for (Brick brick : this.score)
		{
			brick.Draw(delta);
		}

		for (Brick brick : this.highScore)
		{
			brick.Draw(delta);
		}

		for (StairsRight stairsRight : this.stairsRight)
		{
			stairsRight.Draw(delta);
		}

		for (StairsLeft stairsLeft : this.stairsLeft)
		{
			stairsLeft.Draw(delta);
		}

		for (Floor floor : this.floors)
		{
			floor.Draw(delta);
		}

		for (Jewel jewel : this.jewels)
		{
			jewel.Draw(delta);
		}

		this.player.Draw(delta);
	}
}