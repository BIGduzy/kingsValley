package Player;

import java.util.ArrayList;

import stairsLeft.StairsLeft;
import stairsRight.StairsRight;

public class PlayerManager {

		//fields
		private static Player player;
		private static ArrayList<StairsRight> stairsRight;
		private static ArrayList<StairsLeft> stairsLeft;
		
		
		//properties
		public static void setPlayer(Player player) {
			PlayerManager.player = player;
		}
		public static void setStairRight(ArrayList<StairsRight> stairRight) {
			PlayerManager.stairsRight = stairRight;
		}
		public static ArrayList<StairsLeft> getStairsLeft() {
			return stairsLeft;
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
					int offset = 10;
					if ((player.getCollisionRectStairs().x
							+ player.getCollisionRectStairs().getWidth()) >
						stairs.getCollisionRectBottom().x + offset - 2 &&
						(player.getCollisionRectStairs().x
							+ player.getCollisionRectStairs().getWidth() <
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
						player.setPosition(player.getPosition().add(
									0f,(stairs.getCollisionRectBottom().y -
												player.getPosition().y)));
						return true;
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
					int offset = 10;
					System.out.print(offset);
					if ((player.getCollisionRectStairs().x
							+ player.getCollisionRectStairs().getWidth()) >
						stairs.getCollisionRectBottom().x + offset - 2 &&
						(player.getCollisionRectStairs().x
							+ player.getCollisionRectStairs().getWidth() <
						stairs.getCollisionRectBottom().x + offset + 2))
					{
						return true;
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
						float diff=(stair.getCollisionRectTop().y-
										(player.getCollisionRectStairs().y + 
											player.getCollisionRectStairs().getHeight()));
						
						if ((player.getCollisionRectStairs().y + 
								player.getCollisionRectStairs().getHeight()) <
										stair.getCollisionRectTop().y + 2f);
						{
							player.setPosition(player.getPosition().add(0f,diff));
							return true;
						}
					}
				}
			}
			return false;
		}
		
}
