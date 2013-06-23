package Score;

import com.badlogic.gdx.math.Vector2;

import level.Level;
import bricks.Brick;

public class Score 
{
	//Fields
	private static int gameScore = 0;
	private static int highScore = 0;


	public static int getGameScore() {
		return gameScore;
	}
	public static void setGameScore(int gameScore) {
		Score.gameScore = gameScore;
	}
	public static int getHighScore() {
		return highScore;
	}
	public static void setHighScore(int highScore) {
		Score.highScore = highScore;
	}

	public static void AdjustScore(Level level)
	{
		String theScore = Integer.toString(gameScore);

		//Bepaal het vershil tussen beide array's
		int diff = level.getScore().size() - theScore.length();

		//We bouwen nu het scorebord op van links naar rechts
		for ( int i = 0; i < diff; i++)
		{
			level.getScore().set(i, new Brick(level.getGame(),
											  level.getScore().get(i).getPosition(),
											  level.getRegion().get("0"),
											  '0'));			
		}		
		for ( int i = diff; i < level.getScore().size(); i++)
		{
			level.getScore().set(i, new Brick(level.getGame(),
											  new Vector2(level.getScore().get(i).getPosition().x,
													      level.getScore().get(i).getPosition().y),
											  level.getRegion().get(String.valueOf(theScore.charAt(i-diff))),
											  theScore.charAt(i-diff)));			
		}		
	}

	public static void AdjustHighScore(Level level)
	{
		String theScore = Integer.toString(highScore);

		//Bepaal het vershil tussen beide array's
		int diff = level.getHighScore().size() - theScore.length();

		//We bouwen nu het scorebord op van links naar rechts
		for ( int i = 0; i < diff; i++)
		{
			level.getHighScore().set(i, new Brick(level.getGame(),
											  level.getHighScore().get(i).getPosition(),
											  level.getRegion().get("0"),
											  '0'));			
		}		
		for ( int i = diff; i < level.getHighScore().size(); i++)
		{
			level.getHighScore().set(i, new Brick(level.getGame(),
											  new Vector2(level.getHighScore().get(i).getPosition().x,
													      level.getHighScore().get(i).getPosition().y),
											  level.getRegion().get(String.valueOf(theScore.charAt(i-diff))),
											  theScore.charAt(i-diff)));			
		}		
	}

}