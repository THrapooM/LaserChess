package gui;

public class ChessInformation {
	private String ChessName;
	private String urlChess;
	public ChessInformation(String ChessName) {
		switch(ChessName) {
			case "red_laser_tower": 	urlChess = "/red_lase_tower.png";	break;
			case "red_defender": 		urlChess = "/red_defender.png";		break;
			case "read_deflectors": 	urlChess = "/red_deflectors.png";	break;
			case "red_king":			urlChess = "/red_king.png";			break;
			case "red_switch":			urlChess = "/red_switch";			break;
			case "blue_laser_tower": 	urlChess = "/blue_laser_tower.png";	break;
			case "blue_defender": 		urlChess = "/blue_defender.png";	break;
			case "blue_deflectors": 	urlChess = "/blue_deflectors.png";	break;
			case "blue_king":			urlChess = "/blue_king.png";		break;
			case "blue_switch":			urlChess = "/blue_switch";			break;
		}
		this.ChessName = ChessName;
	}
	public String getChessName() {
		return ChessName;
	}
	public String getUrlChess() {
		return urlChess;
	}
	
}
