package logic;

import gui.PicInformation;
import logic.base.*;

public class Defender extends ChessPiece implements Rotatable{

	public Defender(int direction, int x, int y, int team) {
		super(direction, x, y, team);
		if(team == 1) this.name = "red_defender";
		else this.name = "blue_defender";
		this.url = PicInformation.ChessUrl(name);
	}
	
	@Override
	public void rotate(int rotateDirection) {
		direction = (direction + rotateDirection)%4;
	}

	@Override
	public int interact(int laserDirection) {
		laserDirection = (laserDirection+2)%4;
		if(laserDirection == (direction+2)%4) return 4;
		else {
			GameManager.chessPieceCaptured(this);
			return 4;
		}
	}
}
