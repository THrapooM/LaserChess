package gui;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import logic.*;

public class BoardCell extends Pane{
	private ChessPiece chessPiece;
	private int x;
	private int y;
	//private Crop;
	public BoardCell(ChessPiece chessPiece,int x,int y) {
		this.chessPiece = chessPiece;
		this.x = x;
		this.y = y;
		this.setPrefWidth(90);
		this.setPrefHeight(90);
		this.setPadding(new Insets(5,5,5,5));
		this.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
		updatePic();
	}
	
	public void updateChessPiece() {
		this.chessPiece = GameManager.getChessPiece(x, y);
	}
	
	public void updatePic() {
		Image image = new Image(chessPiece.getUrl());
		ImageView imageView = new  ImageView(image);
		imageView.setRotate(90*chessPiece.getDirection());
		image = imageView.getImage();
		BackgroundFill bgFill = new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY);
		BackgroundFill[] bgFillA = {bgFill};
		BackgroundSize bgSize = new BackgroundSize(90,90,false,false,false,false);
		BackgroundImage bgImg = new BackgroundImage(image, null, null, null, bgSize);
		BackgroundImage[] bgImgA = {bgImg};
		this.setBackground(new Background(bgFillA,bgImgA));
	}
	
	public void unhighlight() {
		this.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
	}
	
	public void highlight() {
		this.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
	}
}
