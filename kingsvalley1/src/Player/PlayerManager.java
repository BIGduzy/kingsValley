package Player;

import java.util.ArrayList;

import Score.Score;

import jewel.Jewel;
import level.Level;

import floor.Floor;

import stairsLeft.StairsLeft;
import stairsRight.StairsRight;

public class PlayerManager
{
	private static Player player;
	private static ArrayList<StairsRight> stairsRight;
	private static ArrayList<StairsLeft> stairsLeft;
	private static ArrayList<Floor> floors;
	private static ArrayList<Jewel> jewels;
	private static Level level;

	public static void setPlayer(Player player) 
	{
		PlayerManager.player = player;
	}
	public static void setStairsRight(ArrayList<StairsRight> stairsRight) 
	{
		PlayerManager.stairsRight = stairsRight;
	}

	public static void setStairsLeft(ArrayList<StairsLeft> stairsLeft) {
		PlayerManager.stairsLeft = stairsLeft;
	}

	public static void setJewels(ArrayList<Jewel> jewels)
	{
		PlayerManager.jewels  = jewels;
	}


	public static ArrayList<Floor> getFloors() {
		return floors;
	}

	public static void setFloors(ArrayList<Floor> floors) {
		PlayerManager.floors = floors;
	}	

	public static Level getLevel() {
		return level;
	}
	public static void setLevel(Level level) {
		PlayerManager.level = level;
	}
	public static boolean CollisionDetectionBottomStairsRight()
	{
		for (StairsRight stairs : stairsRight)
		{
			if (player.getCollisionRectStairs().overlaps(stairs.getCollisionRectBottom()))
			{
				if (player.getState().equals(player.getWalkRight()))
				{
					int offset = 10;
					if ((player.getCollisionRectStairs().x 
							+ player.getCollisionRectStairs().getWidth()) >
						 stairs.getCollisionRectBottom().x + offset -2  &&
						(player.getCollisionRectStairs().x 
							+ player.getCollisionRectStairs().getWidth()  <
						 stairs.getCollisionRectBottom().x + offset + 2)) 
					{					
						return true;
					}
				}
				else if (player.getState().equals(player.getWalkDownStairsRight()))
				{
					int offset = 0;
					if ((player.getCollisionRectStairs().y > 
							stairs.getCollisionRectBottom().y + offset - 2) &&
						(player.getCollisionRectStairs().y < 
							stairs.getCollisionRectBottom().y + offset + 5))
					{
						player.setPosition(player.getPosition().add(0f,
											(stairs.getCollisionRectBottom().y - 
											 player.getCollisionRectStairs().y)));
						return true;
					}
				}
			}

		}
		return false;
	}

	public static boolean CollisionDetectionBottomStairsLeft()
	{
		for (StairsLeft stairs : stairsLeft)
		{
			if (player.getCollisionRectStairs().overlaps(stairs.getCollisionRectBottom()))
			{
				if (player.getState().equals(player.getWalkLeft()))
				{
					int offset = 10;
					if ((player.getCollisionRectStairs().x) >
						 stairs.getCollisionRectBottom().x + 
						 	stairs.getCollisionRectBottom().getWidth() -
						 		offset - 2  &&
						(player.getCollisionRectStairs().x  <
						 stairs.getCollisionRectBottom().x + 
						 	stairs.getCollisionRectBottom().getWidth() -
						 		offset + 2)) 
					{					
						return true;
					}
				}
				else if (player.getState().equals(player.getWalkDownStairsLeft()))
				{
					int offset = 0;
					if ((player.getCollisionRectStairs().y > 
							stairs.getCollisionRectBottom().y + offset - 2) &&
						(player.getCollisionRectStairs().y < 
							stairs.getCollisionRectBottom().y + offset + 5))
					{
						player.setPosition(player.getPosition().add(0f,
											(stairs.getCollisionRectBottom().y - 
											 player.getCollisionRectStairs().y)));
						return true;
					}
				}
			}

		}
		return false;
	}

	public static boolean CollisionDectectionTopStairsRight()
	{
		for (StairsRight stair : stairsRight)
		{
			if (player.getCollisionRectStairs().overlaps(stair.getCollisionRectTop()))
			{
				if (player.getState().equals(player.getWalkUpStairsRight()))
				{
					float diff = stair.getCollisionRectTop().y - 
									(player.getCollisionRectStairs().y + 
										player.getCollisionRectStairs().getHeight()) + 1;
					if ((player.getCollisionRectStairs().y +
							player.getCollisionRectStairs().getHeight()) < 
								stair.getCollisionRectTop().y + 2f)
					{
						player.getPosition().add(1.5f, diff );
						return true;
					}
				}
				else if (player.getState().equals(player.getWalkLeft()) )
				{
					int offset = 8;
					if (player.getCollisionRectStairs().x > 
							(stair.getCollisionRectTop().x + offset - 1) &&
						player.getCollisionRectStairs().x < 
							(stair.getCollisionRectTop().x + offset + 1))
					{
						return true;
					}
				}
			}
		}
		return false;
	}

	public static boolean CollisionDectectionTopStairsLeft()
	{
		for (StairsLeft stair : stairsLeft)
		{
			if (player.getCollisionRectStairs().overlaps(stair.getCollisionRectTop()))
			{
				if (player.getState().equals(player.getWalkUpStairsLeft()))
				{
					float diff = stair.getCollisionRectTop().y - 
									(player.getCollisionRectStairs().y + 
										player.getCollisionRectStairs().getHeight()) + 1;
					if ((player.getCollisionRectStairs().y +
							player.getCollisionRectStairs().getHeight()) < 
								stair.getCollisionRectTop().y + 2f)
					{
						player.getPosition().add(1.5f, diff );
						return true;
					}
				}
				else if (player.getState().equals(player.getWalkRight()) )
				{
					int offset = 8;
					if ((player.getCollisionRectStairs().x +
							player.getCollisionRectStairs().getWidth()) > 
								(stair.getCollisionRectTop().x + offset - 1) &&
						(player.getCollisionRectStairs().x + 
						 	player.getCollisionRectStairs().getWidth()) < 
						 		(stair.getCollisionRectTop().x + offset + 1))
					{
						return true;
					}
				}
			}
		}
		return false;
	}

	public static boolean CollisionDectectionGroundAfterJump()
	{
		//Check voor ieder floor.....
		for (Floor floor : floors)
		{
			//Of de rectangle van de player de rectangle van de floor raakt.....
			if (player.getCollisionRectStairs().overlaps(floor.getCollisionRectangle()) &&
					/* en stel als eis dat de bovenkant van de playerrectangle boven
					 * de bovenkant van de floorrectangle zit */
					player.getCollisionRectStairs().y < floor.getCollisionRectangle().y)
			{
				float pixelsThroughFloor = floor.getCollisionRectangle().y -
												(player.getCollisionRectStairs().y 
														+ player.getTexture().getHeight() / 2);
				player.setPixelsThroughFloor(pixelsThroughFloor);
				return true;
			}
		}
		return false;
	}

	public static boolean CollisionDetectFallOfFloorLeft()
	{
		//Kijk voor alle vloeren of ......
		for (Floor floor : floors)
		{
			// de vloerrectangle overlaps met de floor rectangle....
			if (player.getCollisionRectStairs().overlaps(floor.getCollisionRectangle()))
			{
				if (player.getCollisionRectStairs().x + 8 < floor.getCollisionRectangle().x)
				{
					return true;
				}
			}
		}
		return false;
	}

	public static boolean CollisionDetectFallOfFloorRight()
	{
		//Kijk voor alle vloeren of ......
		for (Floor floor : floors)
		{
			// de vloerrectangle overlaps met de floor rectangle....
			if (player.getCollisionRectStairs().overlaps(floor.getCollisionRectangle()))
			{
				if ((player.getCollisionRectStairs().x + 
						player.getCollisionRectStairs().getWidth() - 8f) > 
							floor.getCollisionRectangle().x + 
								floor.getCollisionRectangle().getWidth())
				{
					return true;
				}
			}
		}
		return false;
	}

	public static boolean CollisionDetectionWallInFrontLeft()
	{
		for (Floor floor : floors)
		{
			if (player.getCollisionRectStairs().overlaps(floor.getCollisionRectangle()))
			{
				if (player.getCollisionRectStairs().x <
						floor.getCollisionRectangle().x + 
							floor.getCollisionRectangle().getWidth())
				{
					if (player.getCollisionRectStairs().x > floor.getCollisionRectangle().x )							
					{
						if ((player.getPosition().y + 2 * player.getCollisionRectStairs().getHeight()) >
								(floor.getCollisionRectangle().y + floor.getCollisionRectangle().getHeight()))
						{
							float inWall = floor.getCollisionRectangle().x +
												floor.getCollisionRectangle().getWidth() - 
													player.getCollisionRectStairs().x;
							player.setPixelsInWallLeft(inWall);
							return true;
						}

					}
				}
			}			
		}		
		return false;
	}

	public static boolean CollisionDetectionWallInFrontRight()
	{
		for (Floor floor : floors)
		{
			if (player.getCollisionRectStairs().overlaps(floor.getCollisionRectangle()))
			{
				if (player.getCollisionRectStairs().x + 
						player.getCollisionRectStairs().getWidth() >
							floor.getCollisionRectangle().x )
				{
					if ((player.getCollisionRectStairs().x +
							player.getCollisionRectStairs().getWidth()) <
								(floor.getCollisionRectangle().x + floor.getCollisionRectangle().getWidth()))							
					{
						if ((player.getPosition().y + 2 * player.getCollisionRectStairs().getHeight()) >
								(floor.getCollisionRectangle().y + floor.getCollisionRectangle().getHeight()))
						{
							float inWall = floor.getCollisionRectangle().x - (player.getCollisionRectStairs().x + 
													player.getCollisionRectStairs().getWidth());
							player.setPixelsInWallRight(inWall);
							return true;
						}

					}
				}
			}			
		}		
		return false;
	}

	public static boolean CollisionDetectionPlayerJewels()
	{
		for (Jewel jewel : jewels)
		{
			if (jewel.getCollisionRectangle().overlaps(player.getCollisionRectStairs()))
			{
				jewels.remove(jewel);
				Score.setGameScore(Score.getGameScore() + 500);
				Score.setHighScore(Score.getHighScore() + 500);
				Score.AdjustScore(level);
				Score.AdjustHighScore(level);
				return true;
			}
		}
		return false;
	}
}