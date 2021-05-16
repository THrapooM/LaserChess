package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MovementRules extends VBox{
	private static final String MOVEMENT_RULE1 = "/rule1.png";
	private static final String MOVEMENT_RULE2 = "/rule2.png";
	private static final String MOVEMENT_RULE3 = "/rule3.png";
	private static final String MOVEMENT_RULE4 = "/rule4.png";
	private static final String FONT_PATH = "/ZenDots-Regular.ttf";
	public MovementRules() {
		Label header = new Label("MOVEMENT RULES");
		header.setFont(Font.loadFont(getClass().getResourceAsStream(FONT_PATH), 24));
		header.setTextFill(Color.BLACK);
		this.getChildren().add(header);
		HBox tmpHbox = new HBox();
		VBox tmpVbox = new VBox();
		tmpVbox = addRules(MOVEMENT_RULE1,"");
		tmpHbox.getChildren().add(tmpVbox);
		tmpVbox = addRules(MOVEMENT_RULE2,"");
		tmpHbox.getChildren().add(tmpVbox);
		tmpHbox.setSpacing(15);
		tmpHbox.setAlignment(Pos.CENTER);
		this.getChildren().add(tmpHbox);
		tmpHbox = new HBox();
		tmpVbox = addRules(MOVEMENT_RULE3,"");
		tmpHbox.getChildren().add(tmpVbox);
		tmpVbox = addRules(MOVEMENT_RULE4,"");
		tmpHbox.getChildren().add(tmpVbox);
		tmpHbox.setSpacing(15);
		tmpHbox.setAlignment(Pos.CENTER);
		this.getChildren().add(tmpHbox);
		this.setPadding(new Insets(10));
		this.setSpacing(50);
	}
	public VBox addRules(String url ,String text) {
		VBox tmpVbox = new VBox();
		Label tmpLabel = new Label(text);
		ImageView imv = new ImageView(new Image(url));
		imv.setFitWidth(100);
		imv.setFitHeight(100);
		tmpLabel.setFont(Font.loadFont(getClass().getResourceAsStream(FONT_PATH), 16));
		tmpLabel.setTextFill(Color.BLACK);
		tmpLabel.setMaxWidth(20);
		tmpVbox.getChildren().addAll(imv , tmpLabel);
		return tmpVbox;
		
	}
}
