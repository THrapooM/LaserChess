package gui;



import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import logic.GameManager;

public class BoardPane extends GridPane{
	private BoardCell[][] boardCellList = new BoardCell[8][10];
	public BoardPane() {
		this.setPrefWidth(1000);
		this.setPrefHeight(800);
		this.setVgap(10);
		this.setHgap(10);
		this.setPadding(new Insets(5));
		this.setAlignment(Pos.CENTER);
		for(int i = 0;i < 8;i++) {
			for(int j = 0;j < 10;j++) {
				BoardCell boardcell = new BoardCell(GameManager.getChessPiece(i, j),i,j);
				boardCellList[i][j] = boardcell;
				this.add(boardcell, j, i);
			}
		}
	}
	public BoardCell getBoardCell(int x,int y) {
		return boardCellList[x][y];
	}
}

