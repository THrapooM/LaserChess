package gui;

import java.util.ArrayList;

import javafx.scene.layout.GridPane;
import logic.ChessPiece;

public class BoardPane extends GridPane{
	
	private ArrayList<BoardCell>BoardCells;
	private ChessInformation Area;
	public BoardPane(String Board) {
		BoardCells = new ArrayList<BoardCell>();
		this.setPrefWidth(1000);
		this.setPrefHeight(800);
		CreateBoard(Board);	
	}
	private void CreateBoard(String Board) {
		if(Board=="Ace")
			CreateBoardACE();
	}
	private void CreateBoardACE() {
			for(int row = 0 ; row < 8 ; row++) {
				for(int col = 0 ; col < 10 ; col++) {
					BoardCell boardcell = new BoardCell();
					if(row==0) {
						if(col==0) {this.add(boardcell, col, row);}
						else if(col==4) {}
						else if(col==5) {}
						else if(col==6) {}
						else if(col==7) {}
						else {}
					}
					else if(row==1) {
						if(col==2) {}
						else {}
					}
					else if(row==2) {
						if(col==3) {}
						else {}
					}
					else if(row==3) {
						if(col==0) {}
						else if(col==2) {}
						else if(col==4) {}
						else if(col==5) {}
						else if(col==7) {}
						else if(col==9) {}
						else {}
					}
					else if(row==4) {
						if(col==0) {}
						else if(col==2) {}
						else if(col==4) {}
						else if(col==5) {}
						else if(col==7) {}
						else if(col==9) {}
						else {}
					}
					else if(row==5) {
						if(col==6) {}
						else {}
					}
					else if(row==6){
						if(col==7) {}
						else {}
					}
					else {
						if(col==2) {}
						else if(col==3) {}
						else if(col==4) {}
						else if(col==5) {}
						else if(col==9) {}
						else {}
					}
				}
			}
	}
}

