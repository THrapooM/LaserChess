package logic;

import java.util.ArrayList;
import logic.base.*;

public class GameManager {
	private static ChessPiece[][] chessBoard;
	private static ArrayList<Rotatable> rotatablePieceList;
	private static int winnerTeam;
	private static ChessPiece selectedChessPiece;
	private static String[] team = new String[2];
	private static int teamTurn = 1;
	private static ChessPiece[] laserTurret = new ChessPiece[2];
	private static ArrayList<int[]> laserPath;
	private static boolean turnIsPlayed = false;
	private static boolean gameIsOver = false;
	

	private static final int[] moveX = {-1,-1,0,1,1,1,0,-1};
	private static final int[] moveY = {0,1,1,1,0,-1,-1,-1};
	private static final int[] laserX = {-1,0,1,0};
	private static final int[] laserY = {0,1,0,-1};
	private static final String[] laserURL = {};
	
	public static void startGame(int boardNumber) {
		chessBoard = StartingBoard.getStartingBoard(boardNumber);
		for(int i = 0;i < chessBoard.length;i++) {
			for(int j = 0;j < chessBoard[i].length;j++) {
				
			}
		}
		winnerTeam = 0;
		laserTurret[0] = chessBoard[0][0];
		laserTurret[1] = chessBoard[7][9];
	}
	
	public static void setTeamName(String team1,String team2) {
		team[0] = team1;
		team[1] = team2;
	}
	
	public static String[] getTeamName() {
		String[] tmp = {team[0], team[1]};
		return tmp;
	}
	
	public static int getTeamTurn() {
		return teamTurn;
	}
	
	public static ChessPiece getChessPiece(int x,int y) {
		return chessBoard[x][y];
	}

	public static boolean isTurnPlayed() {
		return turnIsPlayed;
	}
	
	public static void changeTurn() {
		teamTurn = teamTurn == 1? 2:1;
		int tmpx = laserTurret[teamTurn].getX() + laserX[laserTurret[teamTurn].getDirection()];
		int tmpy = laserTurret[teamTurn].getY() + laserY[laserTurret[teamTurn].getDirection()];
		int tmpdir = laserTurret[teamTurn].getDirection();
		ArrayList<int[]> laserPath = new ArrayList<int[]>();
		while(tmpx >= 0 && tmpx < 8 && tmpy >= 0 && tmpy < 10) {
			if(chessBoard[tmpx][tmpy] != null) {
				int newdir = chessBoard[tmpx][tmpy].interact(tmpdir);
				if(newdir == 4) break;
				if(tmpdir == newdir) {
					if(tmpdir%2 == 0) {
						int[] tmpArray = {1,tmpx,tmpy};
						laserPath.add(tmpArray);
					}else {
						int[] tmpArray = {2,tmpx,tmpy};
						laserPath.add(tmpArray);
					}
				}else {
					if((tmpdir == 0 && newdir == 1) || (tmpdir == 1 && tmpdir == 0)) {
						int[] tmpArray = {3,tmpx,tmpy};
						laserPath.add(tmpArray);
					}else if((tmpdir == 1 && newdir == 2) || (tmpdir == 2 && newdir == 1)) {
						int[] tmpArray = {4,tmpx,tmpy};
						laserPath.add(tmpArray);
					}else if((tmpdir == 2 && newdir == 3) || (tmpdir == 3 && newdir == 2)) {
						int[] tmpArray = {5,tmpx,tmpy};
						laserPath.add(tmpArray);
					}else{
						int[] tmpArray = {6,tmpx,tmpy};
						laserPath.add(tmpArray);
					}
				}
				tmpdir = newdir;
				tmpx = tmpx + laserX[tmpdir];
				tmpy = tmpy + laserY[tmpdir];
			}
			
		}
	}
	
	public static void kingIsKilled(int loserTeam) {
		winnerTeam = loserTeam == 1? 2:1;
		gameIsOver = true;
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
		turnIsPlayed = true;
	}
	
	public static void rotate(int direction) {
		Rotatable tmp = (Rotatable) selectedChessPiece;
		tmp.rotate(direction);
		turnIsPlayed = true;
	}
	
	public static void rotateBoard(int direction) {
		for(int i = 0;i < rotatablePieceList.size();i++) {
			rotatablePieceList.get(i).rotate(direction);
		}
		turnIsPlayed = true;
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
		return team[winnerTeam-1];
	}
}
