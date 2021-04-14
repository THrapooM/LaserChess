package gui;

import java.util.ArrayList;

import View.ViewManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class PlayerNameScene extends VBox{
	private Label label1,label2,labeltmp1,labeltmp2,tmp1,tmp2;
	private ArrayList<Label>LabelContainers;
	private ArrayList<TextField>TextFieldContainers;
	private TextField p1TextField,p2TextField;
	private GridPane Table;
	private final String FONT_PATH = "/ZenDots-Regular.ttf";
	private Scene GotoBoardScene;
	
	public PlayerNameScene() {
		this.setAlignment(Pos.CENTER);
		LabelContainers = new ArrayList<Label>();
		TextFieldContainers = new ArrayList<TextField>();
		
		Table = new GridPane();
		
		label1 = new Label("PLAYER 1 : ");
		Table.add(label1,0,0);
		LabelContainers.add(label1);
		
		p1TextField = new TextField();
		Table.add(p1TextField, 1, 0);
		TextFieldContainers.add(p1TextField);
		
		labeltmp1 = new Label("PLAYER 1 NAME : ");
		Table.add(labeltmp1,0,1);
		LabelContainers.add(labeltmp1);
		
		tmp1 = new Label();
		Table.add(tmp1,1,1);
		LabelContainers.add(tmp1);
		
		tmp1.textProperty().bind(p1TextField.textProperty());
		Table.setVgap(20);
		Table.setHgap(30);
		this.getChildren().add(Table);
		Table = new GridPane();
		
		label2 = new Label("PLAYER 2 : ");
		Table.add(label2,0,0);
		LabelContainers.add(label2);
		
		p2TextField = new TextField();
		Table.add(p2TextField, 1, 0);
		TextFieldContainers.add(p2TextField);
	
		labeltmp2 = new Label("PLAYER 2 NAME : ");
		Table.add(labeltmp2,0,1);
		LabelContainers.add(labeltmp2);
		
		tmp2 = new Label();
		Table.add(tmp2,1,1);
		LabelContainers.add(tmp2);
		
		tmp2.textProperty().bind(p2TextField.textProperty());
		Table.setVgap(20);
		Table.setHgap(30);
		
		this.getChildren().add(Table);
		setfont();
		setSpacing(50);
		createBackGround();
		createLogo();
		createStartButton();
	}
	private void setfont() {
		for(Label eachLabel : LabelContainers) {
			eachLabel.setFont(Font.loadFont(getClass().getResourceAsStream(FONT_PATH), 30));
			eachLabel.setTextFill(Color.WHITE);
		}
		for(TextField eachTextField : TextFieldContainers) {
			eachTextField.setPrefWidth(500);
			eachTextField.setMaxWidth(500);
			eachTextField.setMinWidth(500);
			eachTextField.setFont(Font.loadFont(getClass().getResourceAsStream(FONT_PATH), 30));
			eachTextField.setStyle("-fx-text-inner-color: Black;");
		}
	}
	private void createBackGround() {
		Image backgroundImage = new Image("/25199.jpg", 1024, 768, false, false);
		BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
		this.setBackground(new Background(background));
	
	}
	private void createLogo() {
		
	}
	private void createStartButton() {
		Button StartButton = new Button("Start");
		this.getChildren().add(StartButton);
		StartButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(p1TextField.getText()!="" && p2TextField.getText()!="") {
					BoardScene AllBoard = new BoardScene();
					GotoBoardScene = new Scene(AllBoard,ViewManager.getWidth(),ViewManager.getHeight());
					ViewManager.getMainStage().setScene(GotoBoardScene);
				}
			}
		});
	}
		
}
