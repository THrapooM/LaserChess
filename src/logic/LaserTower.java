package logic;
import gui.PicInformation;
import logic.base.*;

public class LaserTower extends ChessPiece implements Rotatable{
	
	public LaserTower(int direction, int x, int y, int team) {
		super(direction, x, y, team);
		if(team == 1) this.name = "red_laser_tower";
		else this.name = "blue_laser_tower";
		this.url = PicInformation.ChessUrl(name);
	}
	
	@Override
	public void rotate(int rotateDirection) {
		direction = (direction + rotateDirection)%4;
	}

	@Override
	public int interact(int laserDirection) {
		return 4;
	}

}
