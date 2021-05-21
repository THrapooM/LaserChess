package gui;

import View.ViewManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class EndGameButton extends VBox{
	private Button restart,mainMenu;
	private final String FONT_PATH = "/ZenDots-Regular.ttf";
	public EndGameButton() {
		restart = new Button("RESTART");
		mainMenu = new Button("MAIN MENU");
		restart.setFont(Font.loadFont(getClass().getResourceAsStream(FONT_PATH), 23));
		mainMenu.setFont(Font.loadFont(getClass().getResourceAsStream(FONT_PATH), 23));
		this.getChildren().addAll(restart,mainMenu);
		this.setSpacing(25);
		this.setAlignment(Pos.CENTER);
		addEventHandler();
	}
	private void addEventHandler() {
		restart.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ViewManager.initGameScene(CreateBoardPicker.getChoosenBoard().ordinal());
			}
		});
		mainMenu.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ViewManager.initMainScene();
			}
		});
	}
}
