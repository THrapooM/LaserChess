package logic.base;

import logic.ChessPiece;

public class StartingBoard {
	private static final ChessPiece[][][] startingBoard = {{{}}};
	public static ChessPiece[][] getStartingBoard(int boardNumber){
		return startingBoard[boardNumber];
	}
}
