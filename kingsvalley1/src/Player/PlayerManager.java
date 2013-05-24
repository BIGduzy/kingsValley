package Player;

import java.util.ArrayList;

import stairsRight.StairsRight;

public class PlayerManager {

		//fields
		private static Player player;
		private static ArrayList<StairsRight> stairsRight;
		
		
		//properties
		public static void setPlayer(Player player) {
			PlayerManager.player = player;
		}
		public static void setStairRight(ArrayList<StairsRight> stairRight) {
			PlayerManager.stairsRight = stairRight;
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
			}
			
			return false;
		}
		
}
