package logic;

import java.util.ArrayList;

import View.ViewManager;
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

	public static void changeTurn() {
		int tmpx = laserTurret[teamTurn-1].getX() + laserX[laserTurret[teamTurn-1].getDirection()];
		int tmpy = laserTurret[teamTurn-1].getY() + laserY[laserTurret[teamTurn-1].getDirection()];
		int tmpdir = laserTurret[teamTurn-1].getDirection();
		ArrayList<int[]> laserPath = new ArrayList<int[]>();
		while(tmpx >= 0 && tmpx < 8 && tmpy >= 0 && tmpy < 10) {
			int newdir = tmpdir;
			if(chessBoard[tmpx][tmpy] != null) {
				newdir = chessBoard[tmpx][tmpy].interact(tmpdir);
				if(newdir == 4) break;
			}
			if(tmpdir == newdir) {
				if(tmpdir%2 == 0) {
					int[] tmpArray = {1,tmpx,tmpy};
					laserPath.add(tmpArray);
				}else {
					int[] tmpArray = {2,tmpx,tmpy};
					laserPath.add(tmpArray);
				}
			}else {
				if((tmpdir == 2 && newdir == 1) || (tmpdir == 3 && newdir == 0)) {
					int[] tmpArray = {3,tmpx,tmpy};
					laserPath.add(tmpArray);
				}else if((tmpdir == 3 && newdir == 2) || (tmpdir == 0 && newdir == 1)) {
					int[] tmpArray = {4,tmpx,tmpy};
					laserPath.add(tmpArray);
				}else if((tmpdir == 1 && newdir == 2) || (tmpdir == 0 && newdir == 3)) {
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
		ViewManager.shootLaser(laserPath);
		teamTurn = teamTurn == 1? 2:1;
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
	
	public static void move(int x1,int y1) {
		ChessPiece tmp = null;
		int x2 = selectedChessPiece.getX();
		int y2 = selectedChessPiece.getY();
		if(chessBoard[x1][y1] != null) {
			try {
				tmp = (ChessPiece) chessBoard[x1][y1].clone();
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		if(tmp != null) tmp.move(x2,y2);
		selectedChessPiece.move(x1,y1);
		chessBoard[x1][y1] = selectedChessPiece;
		chessBoard[x2][y2] = tmp;
		ViewManager.updateBoard();
		changeTurn();
	}
	
	public static void rotate(int direction) {
		Rotatable tmp = (Rotatable) selectedChessPiece;
		tmp.rotate(direction);
		ViewManager.updateBoard();
		changeTurn();
	}
	
	public static void rotateBoard(int direction) {
		for(int i = 0;i < rotatablePieceList.size();i++) {
			rotatablePieceList.get(i).rotate(direction);
		}
		ViewManager.updateBoard();
		changeTurn();
	}

	public static ArrayList<int[]> getMovablePOS(){
		ArrayList<int[]> movablePOS = new ArrayList<int[]>();
		for(int i = 0;i < 8;i++) {
			if(selectedChessPiece instanceof LaserTower) break;
			int tmpx = selectedChessPiece.getX() + moveX[i];
			int tmpy = selectedChessPiece.getY() + moveY[i];
			if(tmpx >= 0 && tmpx <= 7 && tmpy >= 0 && tmpy <= 9) {
				if(!(selectedChessPiece instanceof Switch) && chessBoard[tmpx][tmpy] != null) continue;
				if(chessBoard[tmpx][tmpy] instanceof King || chessBoard[tmpx][tmpy] instanceof Switch || chessBoard[tmpx][tmpy] instanceof LaserTower) continue;
				if(selectedChessPiece.getTeam() == 1 && (tmpy == 9 || (tmpy == 8 && (tmpx == 0 || tmpx == 7)))) continue;
				if(selectedChessPiece.getTeam() == 2 && (tmpy == 0 || (tmpy == 1 && (tmpx == 0 || tmpx == 7)))) continue;
				int[] tmpPOS = {tmpx,tmpy};
				movablePOS.add(tmpPOS);
			}
		}
		return movablePOS;
	}
	
	public static ChessPiece[][] getChessBoard() {
		return chessBoard;
	}

	public static ArrayList<Rotatable> getRotatablePieceList() {
		return rotatablePieceList;
	}

	public static ChessPiece getSelectedChessPiece() {
		return selectedChessPiece;
	}

	public static String[] getTeam() {
		return team;
	}

	public static ChessPiece[] getLaserTurret() {
		return laserTurret;
	}

	public static ArrayList<int[]> getLaserPath() {
		return laserPath;
	}

	public static boolean isGameIsOver() {
		return gameIsOver;
	}

	public static int[] getMovex() {
		return moveX;
	}

	public static int[] getMovey() {
		return moveY;
	}

	public static int[] getLaserx() {
		return laserX;
	}

	public static int[] getLasery() {
		return laserY;
	}

	public static String[] getLaserurl() {
		return laserURL;
	}

	public static String getWinnerTeam() {
		return team[winnerTeam-1];
	}
}
