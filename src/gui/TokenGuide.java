package gui;

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
	private static final String FONT_PATH = "/ZenDots-Regular.ttf";
	public TokenGuide() {
		Label header = new Label("TOKEN GUIDE");
		header.setFont(Font.loadFont(getClass().getResourceAsStream(FONT_PATH), 24));
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
		eachToken.setFont(Font.loadFont(getClass().getResourceAsStream(FONT_PATH), 16));
		eachToken.setTextFill(Color.BLACK);
		tmpHBox.getChildren().addAll(imv , eachToken);
		tmpHBox.setSpacing(10);
		this.getChildren().add(tmpHBox);
	}
}
