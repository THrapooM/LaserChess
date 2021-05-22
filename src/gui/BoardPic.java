package gui;

public enum BoardPic {
	Ace("/Ace.png"),
	Curiosity("/Curiosity.png"),
	Grail("/Grail.png"),
	Mercury("/Mercury.png"),
	Sophie("/Sophie.png");
	private String urlBoard;
	
	private BoardPic(String urlBoard) {
		this.urlBoard = urlBoard;
	}
	public String getUrlBoard() {
		return urlBoard;
	}
}
