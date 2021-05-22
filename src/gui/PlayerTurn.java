package gui;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.GameManager;

public class PlayerTurn extends HBox{
	private String redTurn,blueTurn;
	private static Boolean turn = true;
	private static final String FONT_PATH = "/ZenDots-Regular.ttf";
	public PlayerTurn() {
		redTurn = GameManager.getTeamName()[0] + "'s Turn";
		blueTurn = GameManager.getTeamName()[1] + "'s Turn ";
		swapTurn();
	}
	public void swapTurn() {
		this.getChildren().clear();
		Label redLabel = new Label(redTurn);
		redLabel.setFont(Font.loadFont(getClass().getResourceAsStream(FONT_PATH), 30));
		redLabel.setTextFill(Color.web("#ff1458"));
		Label blueLabel = new Label(blueTurn);
		blueLabel.setFont(Font.loadFont(getClass().getResourceAsStream(FONT_PATH), 30));
		blueLabel.setTextFill(Color.web("121c5e"));
		if(turn) {
			redLabel.setEffect(new Glow(0.8));
			blueLabel.setEffect(null);
		}
		else {
			redLabel.setEffect(null);
			blueLabel.setEffect(new Glow(0.8));
		}
		turn = !turn;
		HBox tmpHBox = new HBox();
		tmpHBox.getChildren().add(redLabel);
		this.getChildren().add(tmpHBox);
		HBox tmpHBox2 = new HBox();
		tmpHBox2.getChildren().add(blueLabel);
		this.getChildren().add(tmpHBox2);
		this.setAlignment(Pos.CENTER);
		this.setSpacing(50);
	}
		
}
