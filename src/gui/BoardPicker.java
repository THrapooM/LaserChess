package gui;

import View.ViewManager;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class BoardPicker extends VBox{
	private Label BoardLabel;
	private ImageView circleImage;
	private ImageView BoardImage;
	private String CircleNotChoosen = "/grey_circle.png";
	private String CircleChoosen = "/red_boxTick.png";
	private final String FONT_PATH = "/ZenDots-Regular.ttf";
	private BoardPic boardpic;
	
	private boolean isCircleChoosen;
	public BoardPicker(BoardPic Board) {
		this.setAlignment(Pos.CENTER);
		isCircleChoosen = false;
		BoardLabel = new Label(Board.name());
		circleImage = new ImageView(CircleNotChoosen);
		BoardImage = new ImageView(Board.getUrlBoard());
		BoardImage.setFitWidth(250);
		BoardImage.setFitHeight(200);
		this.boardpic = Board;
		this.setSpacing(15);
		this.getChildren().add(BoardLabel);
		BoardLabel.setFont(Font.loadFont(getClass().getResourceAsStream(FONT_PATH), 23));
		this.getChildren().add(BoardImage);
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
