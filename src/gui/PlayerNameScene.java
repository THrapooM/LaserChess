package gui;

import Exception.NoNameException;
import View.ViewManager;
import element.Audioloader;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Font;
import logic.GameManager;

public class PlayerNameScene extends VBox{
	private TextField p1TextField,p2TextField;
	private final String TEAM_RED = "TEAM_RED.png";
	private final String TEAM_BLUE = "TEAM_BLUE.png";
	public PlayerNameScene() {
		this.setLayoutX(15);
		this.setLayoutY(83);
		this.setSpacing(30);
		createRedTeam();
		createBlueTeam();
		createStartButton();
	}
	private void createRedTeam() {
		Image image = new Image(TEAM_RED);
		ImageView imv = new ImageView(image);
		Label label = new Label("ENTER TEAM RED NAME :");
		p1TextField = new TextField();
		p1TextField.textProperty().addListener((ChangeListener<? super String>) new ChangeListener<String>() {
	        public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
	            if (p1TextField.getText().length() > 11) {
	                String s = p1TextField.getText().substring(0, 11);
	                p1TextField.setText(s);
	            }
	        }
	    });
		p1TextField.setPrefWidth(160);
		p1TextField.setMaxWidth(160);
		HBox tmpHBox = new HBox();
		tmpHBox.getChildren().addAll(label,p1TextField);
		tmpHBox.setSpacing(40);
		this.getChildren().addAll(imv,tmpHBox);
		setfont(label,p1TextField);
		
	}
	private void createBlueTeam() {
		Image image = new Image(TEAM_BLUE);
		ImageView imv = new ImageView(image);
		Label label = new Label("ENTER TEAM BLUE NAME :");
		p2TextField = new TextField();
		p2TextField.textProperty().addListener((ChangeListener<? super String>) new ChangeListener<String>() {
	        public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
	            if (p2TextField.getText().length() > 11) {
	                String s = p2TextField.getText().substring(0, 11);
	                p2TextField.setText(s);
	            }
	        }
	    });
		p2TextField.setPrefWidth(160);
		p2TextField.setMaxWidth(160);
		HBox tmpHBox = new HBox();
		tmpHBox.getChildren().addAll(label,p2TextField);
		tmpHBox.setSpacing(30);
		this.getChildren().addAll(imv,tmpHBox);
		setfont(label, p2TextField);
	}
	private void setfont(Label label , TextField textField) {
		label.setFont(Font.loadFont(ViewManager.class.getResource(ViewManager.getFontPath()).toExternalForm(),15));
		textField.setFont(Font.loadFont(ViewManager.class.getResource(ViewManager.getFontPath()).toExternalForm(),15));
	}
	private void createStartButton() {
		Button NEXTButton = new Button("NEXT");
		NEXTButton.setFont(Font.loadFont(ViewManager.class.getResource(ViewManager.getFontPath()).toExternalForm(),15));
		HBox tmpHBox = new HBox();
		tmpHBox.setAlignment(Pos.CENTER);
		tmpHBox.getChildren().add(NEXTButton);
		this.getChildren().add(tmpHBox);
		NEXTButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				try {
					if(p1TextField.getText()!="" && p2TextField.getText()!="") {
						AudioClip mousePressedSound = Audioloader.mousePressedSound;
						mousePressedSound.setVolume(0.5);
						mousePressedSound.play();
						GameManager.setTeamName(p1TextField.getText(), p2TextField.getText());
						ViewManager.initBoardPickerScene();
					}else {
						throw new NoNameException("Plaese enter team's name");
					}					
				}catch(NoNameException e) {
//					e.printStackTrace();
					System.out.println(e.getMessage());
				}
			}
		});
	}
		
}
