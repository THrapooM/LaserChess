package logic;
import logic.base.*;

public class LaserTurret extends ChessPiece implements Rotatable{
	
	public LaserTurret(int direction, int x, int y, int team) {
		super(direction, x, y, team);
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
