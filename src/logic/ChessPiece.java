package logic;


public abstract class ChessPiece implements Cloneable{
	protected int direction;
	private int x,y;
	private int team;
	protected String name;
	protected String url;
	
	public ChessPiece(int direction,int x,int y,int team) {
		this.direction = direction;
		this.x = x;
		this.y = y;
		this.team = team;
	}
	public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }

	public void move(int x,int y) {
		this.setX(x);
		this.setY(y);
	}
	public abstract int interact(int lserdirection);
	
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
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
	public int getTeam() {
		return team;
	}
	public String getName() {
		return name;
	}
	public String getUrl() {
		return url;
	}
}
