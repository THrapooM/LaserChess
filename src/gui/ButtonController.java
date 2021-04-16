package gui;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class ButtonController extends VBox{
	private Button rotateLeftButton,rotateRightButton;
	private final String FONT_PATH = "/ZenDots-Regular.ttf";
	public ButtonController() {
		rotateLeftButton = new Button("rotate left");
		rotateRightButton = new Button("rotata right");
		setfont();
		this.getChildren().addAll(rotateLeftButton,rotateRightButton);
	}
	private void setfont() {
		rotateLeftButton.setFont(Font.loadFont(getClass().getResourceAsStream(FONT_PATH), 23));
		rotateRightButton.setFont(Font.loadFont(getClass().getResourceAsStream(FONT_PATH), 23));
	}
}
