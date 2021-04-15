package logic.base;

import logic.*;

public class StartingBoard {
	private static final ChessPiece[][][] startingBoard = {
			{{new LaserTower(2,0,0,1), null, null, null, new Defender()
		
	}}};
	public static ChessPiece[][] getStartingBoard(int boardNumber){
		return startingBoard[boardNumber];
	}
}
