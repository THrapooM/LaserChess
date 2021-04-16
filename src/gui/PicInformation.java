package gui;

public class PicInformation {
	public static String ChessUrl(String ChessName) {
		switch(ChessName) {
			case "red_laser_tower": 	return "/red_laser_tower.png";	
			case "red_defender": 		return "/red_defender.png";		
			case "red_deflector": 	return "/red_deflector.png";	
			case "red_king":			return "/red_king.png";			
			case "red_switch":			return "/red_switch.png";			
			case "blue_laser_tower": 	return "/blue_laser_tower.png";	
			case "blue_defender": 		return "/blue_defender.png";	
			case "blue_deflector": 	return "/blue_deflector.png";	
			case "blue_king":			return "/blue_king.png";		
			case "blue_switch":			return "/blue_switch.png";			
		}
		return null;
	}
}
