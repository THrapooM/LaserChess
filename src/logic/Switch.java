package logic;

import gui.PicInformation;
import logic.base.*;

public class Switch extends ChessPiece implements Rotatable{

	public Switch(int direction, int x, int y, int team) {
		super(direction, x, y, team);
		if(team == 1) this.name = "red_switch";
		else this.name = "blue_switch";
		this.url = PicInformation.ChessUrl(name);
	}
	
	@Override
	public void rotate(int rotateDirection) {
		direction = (direction + rotateDirection)%4;
	}

	@Override
	public int interact(int laserDirection) {
		int[] mirror1 = {direction,(direction+1)%4};
		int[] mirror2 = {(direction+2)%4,(direction+3)%4};
		if(laserDirection == mirror1[0]) return mirror1[1];
		else if(laserDirection == mirror1[1]) return mirror1[0];
		else if(laserDirection == mirror2[0]) return mirror2[1];
		else return mirror2[0];
	}
}
