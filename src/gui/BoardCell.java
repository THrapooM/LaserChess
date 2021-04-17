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
	public BoardCell(ChessPiece chessPiece,int x,int y) {
		this.chessPiece = chessPiece;
		setPane(x,y);
		updatePic();
	}
	private void setPane(int x,int y) {
		this.x = x;
		this.y = y;
		this.setPrefWidth(95);
		this.setPrefHeight(95);
		this.setPadding(new Insets(0));
		this.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
	}
	public void updateChessPiece() {
		this.chessPiece = GameManager.getChessPiece(x, y);
	}
	
	public void updatePic() {
		if(chessPiece != null) {
			Image image = new Image(chessPiece.getUrl());
			ImageView imageView = new  ImageView(image);
			imageView.setRotate(imageView.getRotate() + 90*chessPiece.getDirection());
			imageView.setFitWidth(95);
			imageView.setFitHeight(95);
			this.getChildren().add(imageView);
		}else {
			this.getChildren().clear();
		}
	}
	
	public void unhighlight() {
		this.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
	}
	
	public void highlight() {
		this.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
	}
}
