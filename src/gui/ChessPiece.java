package gui;

public abstract class ChessPiece {
	protected int direction;
	private int x,y;
	
	public ChessPiece(int direction,int x,int y) {
		this.direction = direction;
		this.x = x;
		this.y = y;
	}
	
	public int getDirection() {
		return direction;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
}
