package logic;

import logic.base.*;

public class Defender extends ChessPiece implements Rotatable{

	public Defender(int direction, int x, int y, int team) {
		super(direction, x, y, team);
	}
	
	@Override
	public void rotate(int rotateDirection) {
		direction = (direction + rotateDirection)%4;
	}

	@Override
	public int interact(int laserDirection) {
		if(laserDirection == (direction+2)%4) return 4;
		else {
			GameManager.chessPieceCaptured(this);
			return 4;
		}
	}
}
