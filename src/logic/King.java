package logic;

import gui.PicInformation;
import logic.base.*;

public class King extends ChessPiece {

	public King(int direction, int x, int y, int team) {
		super(direction, x, y, team);
		if(team == 1) this.name = "red_king";
		else this.name = "blue_king";
		this.url = PicInformation.ChessUrl(name);
	}
	
	@Override
	public int interact(int laserDirection) {
		GameManager.kingIsKilled(getTeam());
		return 4;
	}
}
