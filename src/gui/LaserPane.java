package gui;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class LaserPane extends GridPane{
	
	public LaserPane() {
		this.setPrefWidth(1000);
		this.setPrefHeight(800);	
		for(int i = 0 ; i < 8 ; i++) {
			for(int j = 0 ; j < 10 ; j++) {
				StackPane laserPath = new StackPane();
				laserPath.setPrefWidth(90);
				laserPath.setPrefHeight(90);
				this.add(laserPath, j, i);
			}
		}
	}
	public void shootLaser(ArrayList<int[]>laserPath){
		for(int i = 0 ; i < laserPath.size() ; i++) {
				String url = "/" + "laser" + laserPath.get(i)[0] + ".png";
				Image image = new Image(url);
				ImageView imageView = new ImageView(image);
				this.add(imageView,laserPath.get(i)[1],laserPath.get(i)[2]);
		}
	}
}
