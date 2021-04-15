package gui;

public enum BoardPic {
	Ace("/AceBoard.png"),
	Curiosty("/AceBoard.png"),
	Grail("/AceBoard.png"),
	Mercury("/AceBoard.png"),
	Sophie("/AceBoard.png");
	String urlBoard;
	
	private BoardPic(String urlBoard) {
		this.urlBoard = urlBoard;
	}
	public String getUrlBoard() {
		return urlBoard;
	}
}
