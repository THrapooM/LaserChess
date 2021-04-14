package gui;


import javafx.scene.effect.DropShadow;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class MenuButton extends Button{
	private static int height = 158;
	private final String FONT_PATH = "/ZenDots-Regular.ttf";
	private final String INIT_BUTTON_STYLE = "-fx-background-color:linear-gradient(#0d1b3e,#27bba8);";
	private final String BUTTON_PRESSED_STYLE = "-fx-background-color:linear-gradient(#27bba8, #0d1b3e);";
	private boolean Clicked = false;
	public MenuButton(String text) {
		setText(text); 
		setLayoutX(100);
		setPrefWidth(250);
		setPrefHeight(40);
		height += 100;
		setLayoutY(height);
		setfont();
		setInitialMenu();
		setFunctionMenu();
	}
	
	private void setfont() {
		setFont(Font.loadFont(getClass().getResourceAsStream(FONT_PATH), 23));
		setTextFill(Color.WHITE);
	}
	
	private void setInitialMenu() {
		setStyle(INIT_BUTTON_STYLE);
		setPrefHeight(40);
	}
	
	private void setButtonPressedStyle() {
		setStyle(BUTTON_PRESSED_STYLE);
		setPrefHeight(40);
		setLayoutY(getLayoutY());
	}
	private void setFunctionMenu() {
		
		this.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				setButtonPressedStyle();
			}
		});
		this.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				if(Clicked) {
					setInitialMenu();
				}
				else setButtonPressedStyle();
				Clicked = !Clicked;
			}
			
		});
		this.setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				setInitialMenu();
			}
		});
		this.setOnMouseEntered(new EventHandler<MouseEvent>() {
			
			public void handle(MouseEvent arg0) {
				setEffect(new DropShadow());
			}
		});
		this.setOnMouseExited(new EventHandler<MouseEvent>() {
			
			public void handle(MouseEvent arg0) {
				setEffect(null);
			}
		});
	}
	
}
