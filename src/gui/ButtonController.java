package gui;

import View.ViewManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.GameManager;
import logic.Switch;

public class ButtonController extends HBox{
	private static Button rotateLeftButton,rotateRightButton;
	private final String FONT_PATH = "/ZenDots-Regular.ttf";
	private final static String ROTATE_BUTTON_STYLE = "-fx-background-color:lightgreen;";
	public ButtonController() {
		this.setPrefHeight(100);
		this.setPrefWidth(1000);
		this.setAlignment(Pos.CENTER);
		this.setSpacing(200);
		rotateLeftButton = new Button("rotate left");
		rotateRightButton = new Button("rotate right");
		createEventHandler();
		setfont();
		this.getChildren().addAll(rotateLeftButton,rotateRightButton);
	}
	private void setfont() {
		rotateLeftButton.setFont(Font.loadFont(getClass().getResourceAsStream(FONT_PATH), 23));
		rotateRightButton.setFont(Font.loadFont(getClass().getResourceAsStream(FONT_PATH), 23));
	}
	public static void setstyle() {
		rotateLeftButton.setStyle(ROTATE_BUTTON_STYLE);
		rotateRightButton.setStyle(ROTATE_BUTTON_STYLE);
	}
	public static void resetstyle() {
		rotateLeftButton.setStyle(null);
		rotateRightButton.setStyle(null);
	}
	private void createEventHandler() {
		rotateLeftButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				if(GameManager.getSelectedChessPiece()!=null) {
					GameManager.rotate(3);
					GameManager.setSelectedChessPiece(null);
					resetstyle();
					ViewManager.unhighlight();
				}
			}
		});
		
		rotateRightButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				if(GameManager.getSelectedChessPiece()!=null) {
					GameManager.rotate(1);
					GameManager.setSelectedChessPiece(null);
					resetstyle();
					ViewManager.unhighlight();
				}
			}
		});
	}
}
