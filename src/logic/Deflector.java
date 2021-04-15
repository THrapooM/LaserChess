package logic;

import gui.PicInformation;
import logic.base.*;

public class Deflector extends ChessPiece implements Rotatable {
	
	public Deflector(int direction, int x, int y, int team) {
		super(direction, x, y, team);
		if(team == 1) this.name = "red_deflectors";
		else this.name = "blue_deflectors";
		this.url = PicInformation.ChessUrl(name);
	}
	
	@Override
	public void rotate(int rotateDirection) {
		direction = (direction + rotateDirection)%4;
	}

	@Override
	public int interact(int laserDirection) {
		int[] mirror = {direction,(direction+3)%4};
		if(laserDirection == mirror[0]) return mirror[1];
		else if(laserDirection == mirror[1]) return mirror[0];
		else{
			GameManager.chessPieceCaptured(this);
			return 4;
		}
		
	}
}
