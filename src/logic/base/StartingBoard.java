package logic.base;

import logic.*;

public class StartingBoard {
	
	public static final ChessPiece[][][] startingBoard = 
		{
				{{new LaserTower(2,0,0,1), null, null, null, new Defender(2,0,4,1), new King(0,0,5,1), new Defender(2, 0, 6, 1), new Deflector(1, 0, 7, 1), null, null},
				 {null, null, new Deflector(2,1,2,1), null, null, null, null, null, null, null},
				 {null, null, null, new Deflector(3,2,3,2), null, null, null, null, null, null},
				 {new Deflector(0,3,0,1), null, new Deflector(2,3,2,2), null, new Switch(0, 3, 4, 1), new Switch(1,3,5,1), null, new Deflector(1,3,7,1), null, new Deflector(3,3,9,2)},
				 {new Deflector(1,4,0,1), null, new Deflector(3,4,2,2), null, new Switch(1,4,4,2), new Switch(0,4,5,2), null, new Deflector(0,4,7,1), null, new Deflector(2,4,9,2)},
				 {null, null, null, null, null, null, new Deflector(1,5,6,1), null, null, null},
				 {null, null, null, null, null, null, null, new Deflector(0,6,7,2), null, null},
				 {null, null, new Deflector(3,7,2,2), new Defender(0, 7, 3, 2), new King(0,7,4,2), new Defender(0,7,5,2), null, null, null, new LaserTower(0, 7, 9, 2)}},
				
				{{new LaserTower(2,0,0,1), null, null, null, new Defender(2,0,4,1), new King(0,0,5,1), new Defender(2, 0, 6, 1), new Switch(1, 0, 7, 1), null, null},
			     {null, null, null, null, null, null, null, null, null, null},
			     {null, null, null, new Deflector(3,2,3,2), null, null, new Deflector(0,2,6,1), null, null, null},
			     {new Deflector(0,3,0,1), new Deflector(2,3,1,2), null, null, new Deflector(1,3,4,2), new Switch(1,3,5,1), null, null, new Deflector(1,3,8,1), new Deflector(3,3,9,2)},
			     {new Deflector(1,4,0,1), new Deflector(3,4,1,2), null, null, new Switch(1,4,4,2), new Deflector(3,4,5,1), null, null, new Deflector(0,4,8,1), new Deflector(2,4,9,2)},
			     {null, null, null, new Deflector(2,5,3,2), null, null, new Deflector(1,5,5,1), null, null, null},
			     {null, null, null, null, null, null, null, null, null, null},
			     {null, null, new Switch(3,7,2,2), new Defender(0, 7, 3, 2), new King(0,7,4,2), new Defender(0,7,5,2), null, null, null, new LaserTower(0, 7, 9, 2)}},
				
				{{new LaserTower(2,0,0,1), null, null, null, new Deflector(2,0,4,1), new Defender(2,0,5,1), new Deflector(1,0,6,1), null, null, null},
			     {null, null, null, null, null, new King(0,1,5,1), null, null, null, null},
			     {new Deflector(0,2,0,1), null, null, null, new Deflector(2,2,5,1), new Defender(2,2,5,1), new Switch(1,2,6,1), null, null, null},
			     {new Deflector(1,3,0,1), null, new Switch(0,3,2,1), null, new Deflector(3,3,4,2), null, new Deflector(1,3,6,2), null, null, null},
			     {null, null, null, new Deflector(3,4,3,1), null, new Deflector(1,4,5,1), null, new Switch(0,4,7,2), null, new Deflector(3,4,9,2)},
			     {null, null, null, new Switch(1,5,3,2), new Defender(0,5,4,2), new Deflector(0,5,5,2), null, null, null, new Deflector(2,5,9,2)},
			     {null, null, null, null, new King(0,6,4,2), null, null, null, null, null},
			     {null, null, null, new Deflector(3,7,3,2), new Defender(0,7,4,2), new Deflector(0,7,5,2), null, null, null, new LaserTower(0, 7, 9, 2)}},
				
				{{new LaserTower(1,0,0,1), null, null, null, new Deflector(2,0,4,1), new King(0,0,5,1), new Deflector(1,0,6,1), null, null, new Switch(1,0,9,2)},
			     {null, null, null, null, null, new Defender(2,1,5,1), new Deflector(1,1,6,1), null, null, null},
			     {new Deflector(1,2,0,1), null, null, new Switch(1,2,3,1), null, new Defender(2,2,5,1), null, null, null, null},
			     {new Deflector(0,3,0,1), null, null, null, new Deflector(3,3,4,2), null, null, null, new Deflector(2,3,8,2), null},
			     {null, new Deflector(0,4,1,1), null, null, null, new Deflector(1,4,5,1), null, null, null, new Deflector(2,4,9,2)},
			     {null, null, null, null, new Defender(0,5,4,2), null, new Switch(1,5,6,2), null, null, new Deflector(3,5,6,2)},
			     {null, null, null, new Deflector(3,6,3,2), new Defender(0,6,4,2), null, null, null, null, null},
			     {new Switch(1,7,0,1), null, null, new Deflector(3,7,3,2), new King(0,7,4,2), new Deflector(0,7,5,2), null, null, null, new LaserTower(3, 7, 9, 2)}},
				
				{{new LaserTower(2,0,0,1), null, null, null, new King(0,0,4,1), new Deflector(3,0,5,2), new Deflector(1,0,6,1), null, null, null},
			     {null, null, null, new Defender(2,1,3,1), null, new Defender(1,1,5,1), null, null, null, new Deflector(2,1,9,2)},
			     {new  Deflector(0,2,0,1), null, null, null, new Deflector(2,2,4,1), new Deflector(1,2,5,1), null, new Switch(1,2,7,2), null, new Deflector(3,2,9,2)},
			     {null, null, null, null, null, null, null, new Switch(0,3,7,1), null, null},
			     {null, null, new Switch(0,4,2,2), null, null, null, null, null, null, null},
			     {new Deflector(1,5,0,1), null, new Switch(1,5,2,1), null, new Deflector(3,5,4,2), new Deflector(0,5,5,2), null, null, null, new Deflector(2,5,9,2)},
			     {new Deflector(0,6,0,1), null, null, null, new Defender(3,6,4,2), null, new Defender(0,6,6,2), null, null, null},
			     {null, null, null, new Deflector(3,7,3,2), new Deflector(1,7,4,1), new King(0,7,5,2), null, null, null, new LaserTower(0, 7, 9, 2)}}
				
		};
	
	public static ChessPiece[][] getStartingBoard(int boardNumber){
		return startingBoard[boardNumber];
	}
}
