package gui;

import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;


public class MenuButton extends Button{
	private static int height = 300;
	public MenuButton(String url) {
		Image image = new Image(url);
		ImageView view = new ImageView(image);
	    this.setGraphic(view);
	    this.setStyle("-fx-background-color: transparent;");
		setLayoutX(50);
		setPrefWidth(289);
		setPrefHeight(64);
		setLayoutY(height);
		height += 95;
		setFunctionMenu();
	}		
	private void setFunctionMenu() {
		
		this.setOnMouseEntered(new EventHandler<MouseEvent>() {
			
			public void handle(MouseEvent arg0) {
				setEffect(new Glow(0.8));
			}
		});
		this.setOnMouseExited(new EventHandler<MouseEvent>() {
			
			public void handle(MouseEvent arg0) {
				setEffect(null);
			}
		});
	}
	
}
