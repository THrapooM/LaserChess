package gui;

import java.util.ArrayList;

import View.ViewManager;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
	private boolean ishighlight = false;
	public BoardCell(ChessPiece chessPiece,int x,int y) {
		this.chessPiece = chessPiece;
		setPane(x,y);
		updatePic();
		this.addEventHandler(MouseEvent.MOUSE_CLICKED, 
				new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent  e) {
						
						onClickHandler();
					}
						// TODO fill in this method					}
			});
	}
	public void onClickHandler() {
		if(this.chessPiece!=null) {
			if(ishighlight) {
				GameManager.move(getX(),getY());
				ViewManager.unhighlight();
				GameManager.setSelectedChessPiece(null);
				GameManager.changeTurn();
			}
			else {
				GameManager.setSelectedChessPiece(chessPiece);
				ArrayList<int[]> getMove = GameManager.getMovablePOS();
				ViewManager.unhighlight();
				ViewManager.highlight(getMove);
			}
		}
		else {
			if(ishighlight) {
				GameManager.move(x,y);
				ViewManager.unhighlight();
				GameManager.changeTurn();
				GameManager.setSelectedChessPiece(null);
			}
			else {
				ViewManager.unhighlight();
				GameManager.setSelectedChessPiece(null);
			}
		}
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	private void setPane(int x,int y) {
		this.x = x;
		this.y = y;
		this.setPrefWidth(90);
		this.setPrefHeight(90);
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
			imageView.setFitWidth(90);
			imageView.setFitHeight(90);
			this.getChildren().add(imageView);
		}else {
			this.getChildren().clear();
		}
	}
	
	public void unhighlight() {
		this.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
		ishighlight = false;
	}
	
	public void highlight() {
		this.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		ishighlight = true;
	}
}
