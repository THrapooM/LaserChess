package logic;

import logic.base.*;

public class Defender extends ChessPiece implements Rotatable,Interactable {

	public Defender(int direction, int x, int y, int team) {
		super(direction, x, y, team);
	}
	
	@Override
	public void rotate(int rotateDirection) {
		direction = (direction + rotateDirection)%4;
	}

	@Override
	public int interact() {
		// TODO Auto-generated method stub
		return 0;
	}
}
