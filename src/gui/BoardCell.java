package gui;

import javafx.geometry.Insets;
import javafx.scene.layout.Pane;

public class BoardCell extends Pane{
	
	public BoardCell() {
		
		this.setPrefWidth(100);
		this.setPrefHeight(100);
		this.setPadding(new Insets(8,8,8,8));
		
		
	}
}
