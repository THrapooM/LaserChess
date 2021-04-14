package logic;

import java.util.ArrayList;
import logic.base.*;

public class GameManager {
	private static ChessPiece[][] chessBoard;
	private static ArrayList<Rotatable> rotatablePieceList;
	private static int winnerTeam;
	private static ChessPiece selectedChessPiece;
	private static String[] team = new String[2];
	private static int teamTurn = 0;
	private static ChessPiece[] laserTurret = new ChessPiece[2];
	private static ArrayList<int[]> laserPath;
	
	private static final int[] moveX = {-1,-1,0,1,1,1,0,-1};
	private static final int[] moveY = {0,1,1,1,0,-1,-1,-1};
	private static final int[] laserX = {-1,0,1,0};
	private static final int[] laserY = {0,1,0,-1};
	private static final String[] laserURL = {};
	
	public static void startGame(int boardNumber,String team1,String team2) {
		chessBoard = StartingBoard.getStartingBoard(boardNumber);
		for(int i = 0;i < chessBoard.length;i++) {
			for(int j = 0;j < chessBoard[i].length;j++) {
				
			}
		}
		team[0] = team1;
		team[1] = team2;
		winnerTeam = 0;
		laserTurret[0] = chessBoard[0][0];
		laserTurret[1] = chessBoard[7][9];
	}
	
	public static int getTeamTurn() {
		return teamTurn;
	}
	
	public static void changeTurn() {
		teamTurn = teamTurn == 0? 1:0;
		int tmpx = laserTurret[teamTurn].getX() + laserX[laserTurret[teamTurn].getDirection()];
		int tmpy = laserTurret[teamTurn].getY() + laserY[laserTurret[teamTurn].getDirection()];
		int tmpdir = laserTurret[teamTurn].getDirection();
		while(tmpx >= 0 && tmpx < 8 && tmpy >= 0 && tmpy < 10) {
			if(chessBoard[tmpx][tmpy] != null) {
				int newdir = chessBoard[tmpx][tmpy].interact(tmpdir);
				if(newdir == 4) break;
				dolaserURL
			}
		}
		doGameOver
	}
	
	public static void kingIsKilled(int loserTeam) {
		winnerTeam = loserTeam == 1? 2:1;
	}
	
	public static void setSelectedChessPiece(ChessPiece selectedChessPiece) {
		GameManager.selectedChessPiece = selectedChessPiece;
	}
	
	public static void chessPieceCaptured(ChessPiece capturedChessPiece) {
		chessBoard[capturedChessPiece.getX()][capturedChessPiece.getY()] = null;
	}
	
	public static void move(int x,int y) {
		ChessPiece tmp = chessBoard[x][y];
		chessBoard[x][y] = selectedChessPiece;
		chessBoard[selectedChessPiece.getX()][selectedChessPiece.getY()] = tmp;
		if(chessBoard[x][y] != null) chessBoard[x][y].move(selectedChessPiece.getX(),selectedChessPiece.getY());
		selectedChessPiece.move(x,y);
		selectedChessPiece = null;
	}
	
	public static void rotate(int direction) {
		Rotatable tmp = (Rotatable) selectedChessPiece;
		tmp.rotate(direction);
	}
	
	public static void rotateBoard(int direction) {
		for(int i = 0;i < rotatablePieceList.size();i++) {
			rotatablePieceList.get(i).rotate(direction);
		}
	}

	public static ArrayList<int[]> getMovablePOS(){
		ArrayList<int[]> movablePOS = new ArrayList<int[]>();
		for(int i = 0;i < 8;i++) {
			int tmpx = selectedChessPiece.getX() + moveX[i];
			int tmpy = selectedChessPiece.getY() + moveY[i];
			if(tmpx >= 0 && tmpx <= 7 && tmpy >= 0 && tmpy <= 9) {
				if(!(selectedChessPiece instanceof Switch) && chessBoard != null) continue;
				if(chessBoard[tmpx][tmpy] instanceof King || chessBoard[tmpx][tmpy] instanceof Switch) continue;
				if(selectedChessPiece.getTeam() == 1 && (tmpy == 9 || (tmpy == 8 && (tmpx == 0 || tmpx == 7)))) continue;
				if(selectedChessPiece.getTeam() == 2 && (tmpy == 0 || (tmpy == 1 && (tmpx == 0 || tmpx == 7)))) continue;
				int[] tmpPOS = {tmpx,tmpy};
				movablePOS.add(tmpPOS);
			}
		}
		return movablePOS;
	}
	
	public static String getWinnerTeam() {
		return team[winnerTeam];
	}
}