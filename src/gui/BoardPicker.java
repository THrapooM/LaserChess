package gui;

import View.ViewManager;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class BoardPicker extends VBox{
	private Label boardLabel;
	private ImageView circleImage;
	private ImageView boardImage;
	private String CircleNotChoosen = "/grey_circle.png";
	private String CircleChoosen = "/red_boxTick.png";
	private BoardPic boardpic;
	private boolean isCircleChoosen;
	public BoardPicker(BoardPic Board) {
		this.setAlignment(Pos.CENTER);
		isCircleChoosen = false;
		boardLabel = new Label(Board.name());
		circleImage = new ImageView(CircleNotChoosen);
		boardImage = new ImageView(Board.getUrlBoard());
		boardImage.setFitWidth(250);
		boardImage.setFitHeight(200);
		this.boardpic = Board;
		this.setSpacing(15);
		this.getChildren().add(boardLabel);
		boardLabel.setFont(Font.loadFont(ViewManager.class.getResource(ViewManager.getFontPath()).toExternalForm(),23));
		this.getChildren().add(boardImage);
		this.getChildren().add(circleImage);
	}
	
	public BoardPic getBoardpic() {
		return boardpic;
	}
	public boolean isCircleChoosen() {
		return isCircleChoosen;
	}
	public void setIsBoardChoosen(boolean isCirCleChoosen) {
		this.isCircleChoosen = isCirCleChoosen;
		String imageToSet = this.isCircleChoosen ? CircleChoosen : CircleNotChoosen;
		circleImage.setImage(new Image(imageToSet));
	}
	
}
