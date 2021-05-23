package gui;


import java.util.ArrayList;
import java.util.List;
import View.ViewManager;
import element.Audioloader;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Font;

public class CreateBoardPicker extends VBox{
	
	private int count  = 0;
	private HBox tmpBox;
	private List<BoardPicker>BoardLists;
	private static BoardPic ChoosenBoard;
	public CreateBoardPicker() {
		setHeader();
		tmpBox = new HBox();
		tmpBox.setSpacing(60);
		BoardLists = new ArrayList<BoardPicker>();
		
		for(BoardPic pic : BoardPic.values()) {
			count++;
			BoardPicker BoardToPick = new BoardPicker(pic);
			BoardLists.add(BoardToPick);
			tmpBox.getChildren().add(BoardToPick);
			BoardToPick.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent arg0) {
					// TODO Auto-generated method stub
					AudioClip mousePressedSound = Audioloader.mousePressedSound;
					mousePressedSound.setVolume(0.5);
					mousePressedSound.play();
					for (BoardPicker Board : BoardLists) {
							Board.setIsBoardChoosen(false);
							
					}
					BoardToPick.setIsBoardChoosen(true);
					ChoosenBoard = BoardToPick.getBoardpic();
				}
			});
			if(count==3) {
				tmpBox.setAlignment(Pos.CENTER);
				this.getChildren().add(tmpBox);		
				tmpBox = new HBox();
				tmpBox.setSpacing(60);
				tmpBox.setAlignment(Pos.CENTER);
			}
		}
		this.setAlignment(Pos.CENTER);
		this.getChildren().add(tmpBox);
		createStartButton();
	}
	private void setHeader() {
		Label label = new Label("SELECT BOARD");
		label.setFont(Font.loadFont(ViewManager.class.getResource(ViewManager.getFontPath()).toExternalForm(),50));
//		label.setFont(Font.loadFont(getClass().getResourceAsStream(FONT_PATH), 50));
		this.setAlignment(Pos.CENTER);
		this.getChildren().add(label);
	}
	private void createStartButton() {
		Button Next = new Button("Start");
		Next.setFont(Font.loadFont(ViewManager.class.getResource(ViewManager.getFontPath()).toExternalForm(),20));
		this.getChildren().add(Next);
		Next.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				try {
					AudioClip mousePressedSound = Audioloader.mousePressedSound;
					mousePressedSound.setVolume(0.5);
					mousePressedSound.play();
					ViewManager.initGameScene(ChoosenBoard.ordinal());
				}catch(NullPointerException e) {
					e.printStackTrace();
					System.out.println("Plaese select a board");
				}
			}
		});
	}
	public static BoardPic getChoosenBoard() {
		return ChoosenBoard;
	}
}
