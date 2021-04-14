package logic;

import java.util.ArrayList;
import logic.base.*;

public class ChessBoard {
	private static ChessPiece[][] chessBoard;
	private ArrayList<Rotatable> rotatablePieceList;
	private static boolean isGameOver;
	private static int winnerTeam;
	
	public ChessBoard(int boardNumber) {
		this.chessBoard = StartingBoard.getStartingBoard(boardNumber);
		for(int i = 0;i < chessBoard.length;i++) {
			for(int j = 0;j < chessBoard[i].length;j++) {
				
			}
		}
		isGameOver = false;
		winnerTeam = 0;
	}
	public ChessPiece getPOSXY(int x,int y) {
		return chessBoard[x][y];
	}
	public void rotateBoard(int direction) {
		for(int i = 0;i < rotatablePieceList.size();i++) {
			rotatablePieceList.get(i).rotate(direction);
		}
	}
	public static void kingIsKilled(int loserTeam) {
		isGameOver = true;
		winnerTeam = loserTeam == 1? 2:1;
		
	}
	public static boolean isGameOver() {
		return isGameOver;
	}
	public static int getWinnerTeam() {
		return winnerTeam;
	}
}
