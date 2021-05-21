package gui;

import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import element.Audioloader;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;


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
		this.setOnMousePressed(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				AudioClip mousePressedSound = Audioloader.mousePressedSound;
				mousePressedSound.setVolume(0.5);
				mousePressedSound.play();
			}
		});
	}
	
}
