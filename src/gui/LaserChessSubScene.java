package gui;

import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.util.Duration;

public class LaserChessSubScene extends SubScene{
	private static final String BACKGROUND_IMAGE = "/subscene.png";
	private boolean isHidden;
	public LaserChessSubScene() {
		super(new AnchorPane() ,620,440);
		isHidden = true;
		prefWidth(620);
		prefHeight(440);
		Image backgroundImage = new Image(BACKGROUND_IMAGE,620, 440, false, false);
		BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
		AnchorPane root2 = (AnchorPane) this.getRoot();
		root2.setBackground(new Background(background));
		setLayoutY(1070);
		setLayoutX(1200);
	}
	public void moveSubScene() {
		TranslateTransition trans = new TranslateTransition(Duration.seconds(1));
		if(isHidden) {
			trans.setToX(-820);
			trans.setToY(-800);
			isHidden = false;
		}
		else {
			trans.setToX(0);
			trans.setToY(0);
			isHidden = true;
		}
		trans.setNode(this);
		trans.play();
	}
	public AnchorPane getPane() {
		return (AnchorPane) this.getRoot();
	}
}
