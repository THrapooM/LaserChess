package gui;

import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;

public class LaserChessSubScene extends SubScene{
	private static final String BACKGROUND_IMAGE = "/subscene.png";
	public LaserChessSubScene() {
		super(new AnchorPane() ,620,440);
		prefWidth(620);
		prefHeight(440);
		Image backgroundImage = new Image(BACKGROUND_IMAGE,620, 440, false, false);
		BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
		AnchorPane root2 = (AnchorPane) this.getRoot();
		root2.setBackground(new Background(background));
		setLayoutX(380);
		setLayoutY(270);
	}
}
