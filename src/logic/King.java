package logic;

import logic.base.*;

public class King extends ChessPiece {

	public King(int direction, int x, int y, int team) {
		super(direction, x, y, team);
	}
	
	@Override
	public int interact(int laserDirection) {
		GameManager.kingIsKilled(getTeam());
		return 4;
	}
}
