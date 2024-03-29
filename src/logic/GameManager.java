package logic;

import java.util.ArrayList;

import View.ViewManager;
import gui.PlayerTurn;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import logic.base.*;

public class GameManager {
	private static ChessPiece[][] chessBoard = new ChessPiece[8][10];
	private static int winnerTeam;
	private static ChessPiece selectedChessPiece;
	private static String[] team = new String[2];
	private static int teamTurn = 1;
	private static ChessPiece[] laserTurret = new ChessPiece[2];
	private static int tmpx,tmpy,tmpdir,newdir,tmpurl;
	private static final String SOUND_PATH = "audio/jellyBeam.mp3";
	private static final int[] moveX = {-1,-1,0,1,1,1,0,-1};
	private static final int[] moveY = {0,1,1,1,0,-1,-1,-1};
	private static final int[] laserX = {-1,0,1,0};
	private static final int[] laserY = {0,1,0,-1};
	
	public static void startGame(int boardNumber) {
		teamTurn = 1;
		chessBoard = new ChessPiece[8][10];
		for(int i = 0;i < chessBoard.length;i++) {
			for(int j = 0;j < chessBoard[i].length;j++) {
				if(StartingBoard.getStartingBoard(boardNumber)[i][j] != null)
					try {
						chessBoard[i][j] = (ChessPiece) StartingBoard.getStartingBoard(boardNumber)[i][j].clone();
					} catch (CloneNotSupportedException e) {}
				else chessBoard[i][j] = null;
			}
		}
		winnerTeam = 0;
		laserTurret[0] = chessBoard[0][0];
		laserTurret[1] = chessBoard[7][9];
	}
	
	public static void changeTurn() {
		tmpx = laserTurret[teamTurn-1].getX() + laserX[laserTurret[teamTurn-1].getDirection()];
		tmpy = laserTurret[teamTurn-1].getY() + laserY[laserTurret[teamTurn-1].getDirection()];
		tmpdir = laserTurret[teamTurn-1].getDirection();
		AudioClip laserSound = new AudioClip(ClassLoader.getSystemResource(SOUND_PATH).toString());
		laserSound.play();
		Thread laserThread = new Thread() {
			public void run() {
				Platform.runLater(new Runnable() {public void run() {ViewManager.startLaserPane();}});
				while(tmpx >= 0 && tmpx < 8 && tmpy >= 0 && tmpy < 10) {
					newdir = tmpdir;
					if(chessBoard[tmpx][tmpy] != null) {
//						Platform.runLater(new Runnable() {public void run() {newdir = chessBoard[tmpx][tmpy].interact(tmpdir);}});
						newdir = chessBoard[tmpx][tmpy].interact(tmpdir);
						if(newdir == 4) break;
					}
					if(tmpdir == newdir) {
						if(tmpdir%2 == 0) tmpurl = 1;
						else tmpurl = 2;
					}else {
						if((tmpdir == 2 && newdir == 1) || (tmpdir == 3 && newdir == 0)) tmpurl = 3;
						else if((tmpdir == 3 && newdir == 2) || (tmpdir == 0 && newdir == 1)) tmpurl = 4;
						else if((tmpdir == 1 && newdir == 2) || (tmpdir == 0 && newdir == 3)) tmpurl = 5;
						else tmpurl = 6;
					}
					String url = "/" + "laser" + tmpurl + ".png";
					Platform.runLater(new Runnable() {
						@Override public void run() {
							Image image = new Image(url);
							ImageView imageView = new ImageView(image);
							imageView.setFitHeight(100);
							imageView.setFitWidth(100);
							ViewManager.placeLaser(imageView,tmpy,tmpx);			            		
						}
					});
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					tmpdir = newdir;
					tmpx = tmpx + laserX[tmpdir];
					tmpy = tmpy + laserY[tmpdir];
				}
				Platform.runLater(new Runnable() {
					public void run() {
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						ViewManager.clearLaser();
						ViewManager.swapTurn();
						
					}
				});
			}
		};
		laserThread.start();
		teamTurn = teamTurn == 1? 2:1;
	}
	
	public static void kingIsKilled(int loserTeam) {
		winnerTeam = loserTeam == 1? 2:1;
		ViewManager.showEndScene();
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
				if(selectedChessPiece.getTeam() == 1 && (tmpy == 9 || (tmpy == 1 && (tmpx == 0 || tmpx == 7)))) continue;
				if(selectedChessPiece.getTeam() == 2 && (tmpy == 0 || (tmpy == 8 && (tmpx == 0 || tmpx == 7)))) continue;
				int[] tmpPOS = {tmpx,tmpy};
				movablePOS.add(tmpPOS);
			}
		}
		return movablePOS;
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
	
	public static void chessPieceCaptured(ChessPiece capturedChessPiece) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				chessBoard[capturedChessPiece.getX()][capturedChessPiece.getY()] = null;
				ViewManager.updateBoard();			
			}
		});
	}
	
	public static void setTeamName(String team1,String team2) {
		team[0] = team1;
		team[1] = team2;
	}
	
	public static String[] getTeamName() {
		return team;
	}
	
	public static int getTeamTurn() {
		return teamTurn;
	}
	
	public static ChessPiece getChessPiece(int x,int y) {
		return chessBoard[x][y];
	}
	public static void setSelectedChessPiece(ChessPiece selectedChessPiece) {
		GameManager.selectedChessPiece = selectedChessPiece;
	}

	public static ChessPiece getSelectedChessPiece() {
		return selectedChessPiece;
	}

	public static String getWinnerTeam() {
		return team[winnerTeam-1];
	}
}
