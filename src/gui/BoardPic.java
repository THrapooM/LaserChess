package gui;

public enum BoardPic {
	Ace("/Ace.png"),
	Curiosty("/Curiosty.png"),
	Grail("/Grail.png"),
	Mercury("/Mercury.png"),
	Sophie("/Sophie.png");
	String urlBoard;
	
	private BoardPic(String urlBoard) {
		this.urlBoard = urlBoard;
	}
	public String getUrlBoard() {
		return urlBoard;
	}
}
