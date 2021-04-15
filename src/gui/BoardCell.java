package gui;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class BoardCell extends Pane{
	
	//private Crop;
	public BoardCell() {
		
		this.setPrefWidth(70);
		this.setPrefHeight(70);
		this.setPadding(new Insets(8,8,8,8));
		setBackGround();
	}
	private void setBackGround() {
		this.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
	}
	
}
