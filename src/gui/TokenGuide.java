package gui;

import View.ViewManager;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class TokenGuide extends VBox{
	private static final String GuideLaserTower = "/GuideLaserTower.png";
	private static final String GuideDeflector = "GuideDeflector.png";
	private static final String GuideDefender = "/GuideDefender.png";
	private static final String GuideSwitch = "/GuideSwitch.png";
	private static final String GuideKing = "/GuideKing.png";
	public TokenGuide() {
		Label header = new Label("TOKEN GUIDE");
		header.setFont(Font.loadFont(ViewManager.class.getResource(ViewManager.getFontPath()).toExternalForm(),24));
		header.setTextFill(Color.BLACK);
		this.getChildren().add(header);
		addToken(GuideLaserTower ,"Laser Tower");
		addToken(GuideDeflector ,"Deflector");
		addToken(GuideDefender ,"Defender");
		addToken(GuideSwitch ,"Switch");
		addToken(GuideKing,"King");
		this.setSpacing(10);
		this.setPadding(new Insets(10));
	}
	public void addToken(String url ,String name) {
		HBox tmpHBox = new HBox();
		VBox tmpVBox = new VBox();
		ImageView imv = new ImageView(new Image(url));
		Label eachToken = new Label(name);
		Label tokenTip = new Label();
		eachToken.setFont(Font.loadFont(ViewManager.class.getResource(ViewManager.getFontPath()).toExternalForm(),16));
		eachToken.setTextFill(Color.BLACK);
		if(name=="Laser Tower") {
			tokenTip.setText("Shoot a beam of laser in the direction of" + "\n"
					+ "the turret. The laser can deflect" + "\n" 
					+ "or captured a token depends on its ability" + "\n"
					+ "and direction. The turret shoot at the end " + "\n"
					+ "of each turn.");
		}
		else if(name=="Deflector") {
			tokenTip.setText("The Deflector can deflector the laser beam" + "\n"
					+ "on to change the direction " + "\n"
					+ "the beam is going.");
		}
		else if(name=="Defender") {
			tokenTip.setText("The Defender can stop the laser beam if" + "\n"
					+ "it is hit in the direction it's facing.");
		}
		else if(name=="Switch") {
			tokenTip.setText("The Switch can deflector laser on all of " + "\n"
					+ "its sides. The Switch can swap place with" + "\n"
					+ "another Deflecter or Defender.");
		}
		else {
			tokenTip.setText("The King is the most important token." + "\n"
					+ "If it's captured you  will lose.");
		}
		tmpVBox.getChildren().addAll(eachToken,tokenTip);
		tmpHBox.getChildren().addAll(imv , tmpVBox);
		tmpHBox.setSpacing(10);
		this.getChildren().add(tmpHBox);
	}
}
