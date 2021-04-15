package gui;

public class PicInformation {
	public static String ChessUrl(String ChessName) {
		switch(ChessName) {
			case "red_laser_tower": 	return "/red_lase_tower.png";	
			case "red_defender": 		return "/red_defender.png";		
			case "read_deflectors": 	return "/red_deflectors.png";	
			case "red_king":			return "/red_king.png";			
			case "red_switch":			return "/red_switch";			
			case "blue_laser_tower": 	return "/blue_laser_tower.png";	
			case "blue_defender": 		return "/blue_defender.png";	
			case "blue_deflectors": 	return "/blue_deflectors.png";	
			case "blue_king":			return "/blue_king.png";		
			case "blue_switch":			return "/blue_switch";			
		}
		return null;
	}
}
