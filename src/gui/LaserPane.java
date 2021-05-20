package gui;


import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class LaserPane extends GridPane{
	
	public LaserPane() {
		this.setPrefWidth(1000);
		this.setPrefHeight(800);
		this.setAlignment(Pos.CENTER);
		this.setHgap(0);
		this.setVgap(0);
		for(int i = 0 ; i < 8 ; i++) {
			for(int j = 0 ; j < 10 ; j++) {
				StackPane laserPath = new StackPane();
				laserPath.setAlignment(Pos.CENTER);
				laserPath.setPrefWidth(100);
				laserPath.setPrefHeight(100);
				this.add(laserPath, j, i);
			}
		}
	}
}
