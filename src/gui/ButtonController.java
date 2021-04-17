package gui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class ButtonController extends HBox{
	private Button rotateLeftButton,rotateRightButton;
	private final String FONT_PATH = "/ZenDots-Regular.ttf";
	public ButtonController() {
		this.setPrefHeight(100);
		this.setPrefWidth(1000);
		this.setAlignment(Pos.CENTER);
		this.setSpacing(200);
		rotateLeftButton = new Button("rotate left");
		rotateRightButton = new Button("rotate right");
		setfont();
		this.getChildren().addAll(rotateLeftButton,rotateRightButton);
	}
	private void setfont() {
		rotateLeftButton.setFont(Font.loadFont(getClass().getResourceAsStream(FONT_PATH), 23));
		rotateRightButton.setFont(Font.loadFont(getClass().getResourceAsStream(FONT_PATH), 23));
	}
}
