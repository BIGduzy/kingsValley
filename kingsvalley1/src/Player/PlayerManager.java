package Player;

import java.util.ArrayList;

import stairsLeft.StairsLeft;
import stairsRight.StairsRight;

public class PlayerManager
{
	private static Player player;
	private static ArrayList<StairsRight> stairsRight;
	private static ArrayList<StairsLeft> stairsLeft;


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


	public static boolean CollisionDetectionBottomStairsRight()
	{
		for (StairsRight stairs : stairsRight)
		{
			if (player.getCollisionRectStairs().overlaps(stairs.getCollisionRectBottom()))
			{
				if (player.getState() == player.getRight())
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
				else if (player.getState() == player.getWalkDownStairsRight())
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
				if (player.getState() == player.getLeft())
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
				else if (player.getState() == player.getWalkDownStairsRight())
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

	public static boolean CollisionDetectionTopStairsRight()
	{
		for (StairsRight stair : stairsRight)
		{
			if (player.getCollisionRectStairs().overlaps(stair.getCollisionRectTop()))
			{
				if (player.getState() == player.getWalkUpStairsRight())
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
				else if (player.getState() == player.getLeft() )
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

}