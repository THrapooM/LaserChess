package gui;

import java.util.ArrayList;

import javafx.scene.layout.GridPane;
import logic.ChessPiece;

public class BoardPane extends GridPane{
	
	private BoardCell[][] boardCells = new BoardCell[8][10];
	public BoardPane() {
		this.setPrefWidth(1000);
		this.setPrefHeight(800);
		for(int i = 0;i < 8;i++) {
			for(int j = 0;j < 10;j++) {
				BoardCell boardcell = new BoardCell(null,i,j);
			}
		}
	}
	
}

