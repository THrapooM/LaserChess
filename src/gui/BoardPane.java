package gui;


import javafx.scene.layout.GridPane;
import logic.base.StartingBoard;

public class BoardPane extends GridPane{
	
	private BoardCell[][] boardCells = new BoardCell[8][10];
	public BoardPane() {
		this.setPrefWidth(1000);
		this.setPrefHeight(800);
		this.setVgap(5);
		this.setHgap(5);
		for(int i = 0;i < 8;i++) {
			for(int j = 0;j < 10;j++) {
				BoardCell boardcell = new BoardCell(StartingBoard.startingBoard[0][i][j],i,j);
				this.add(boardcell, j, i);
			}
		}
	}
}

