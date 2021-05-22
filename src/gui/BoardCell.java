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
			});
	}
	public void onClickHandler() {
		if(this.chessPiece!=null && GameManager.getTeamTurn() == chessPiece.getTeam()) {
			if(ishighlight) {
				GameManager.move(getX(),getY());
				ViewManager.unhighlight();
				ButtonController.resetstyle();
				GameManager.setSelectedChessPiece(null);
			}
			else {
				GameManager.setSelectedChessPiece(chessPiece);
				if(!(GameManager.getSelectedChessPiece() instanceof King))
					ButtonController.setstyle();
				ArrayList<int[]> getMove = GameManager.getMovablePOS();
				ViewManager.unhighlight();
				ViewManager.highlight(getMove);
			}
		}
		else {
			ButtonController.resetstyle();
			if(ishighlight) {
				GameManager.move(x,y);
				GameManager.setSelectedChessPiece(null);
				ViewManager.unhighlight();
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
		if ((x == 0 || x == 7) && y == 1) this.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		else if ((x == 0 || x == 7) && y == 8) this.setBackground(new Background(new BackgroundFill(Color.LIGHTPINK, CornerRadii.EMPTY, Insets.EMPTY)));
		else if(y == 0) this.setBackground(new Background(new BackgroundFill(Color.LIGHTPINK, CornerRadii.EMPTY, Insets.EMPTY)));
		else if (y == 9) this.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		else this.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
	}
	public void updateChessPiece() {
		this.chessPiece = GameManager.getChessPiece(x, y);
	}
	
	public void updatePic() {
		this.getChildren().clear();
		if(chessPiece != null) {
			Image image = new Image(chessPiece.getUrl());
			ImageView imageView = new  ImageView(image);
			imageView.setRotate(90*chessPiece.getDirection());
			imageView.setFitWidth(90);
			imageView.setFitHeight(90);
			this.getChildren().add(imageView);
		}
	}
	
	public void unhighlight() {
		setPane(x,y);
		ishighlight = false;
	}
	
	public void highlight() {
		this.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
		ishighlight = true;
	}
}
