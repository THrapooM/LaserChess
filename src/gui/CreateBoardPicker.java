package gui;

import java.util.ArrayList;
import java.util.List;

import View.ViewManager;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import logic.GameManager;

public class CreateBoardPicker extends VBox{
	
	private static int count  = 0;
	private HBox tmpBox;
	private List<BoardPicker>BoardLists;
	private BoardPic ChoosenBoard;
	public CreateBoardPicker() {
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
					for (BoardPicker Board : BoardLists) {
							Board.setIsBoardChoosen(false);
					}
					BoardToPick.setIsBoardChoosen(true);
					ChoosenBoard = BoardToPick.getBoardpic();
					System.out.println(ChoosenBoard);
				}
				
			});
			if(count==3) {
				this.getChildren().add(tmpBox);		
				tmpBox = new HBox();
				tmpBox.setSpacing(60);
			}
		}
		this.getChildren().add(tmpBox);
		createStartButton();
	}
	private void createStartButton() {
		Button Next = new Button();
		this.getChildren().add(Next);
		Next.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				GameManager.startGame(ChoosenBoard.ordinal());
				BoardPane SelectedBoard = new BoardPane();
				Scene BoardScene = new Scene(SelectedBoard,ViewManager.getWidth(),ViewManager.getHeight());
				ViewManager.getMainStage().setScene(BoardScene);
				
			}
		});
	}
}
