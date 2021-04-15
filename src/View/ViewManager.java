package View;

import gui.MenuButton;
import gui.PlayerNameScene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.stage.Stage;

public class ViewManager {
	private static final int WIDTH = 1024;
	private static final int HEIGHT = 768;
	private AnchorPane mainPane;
	private static Stage mainStage;
	private Scene mainScene,PlayerScene;
	public ViewManager() {
		initScene1();
		initScene2();
		mainStage = new Stage();
		mainStage.setScene(mainScene);
		mainStage.setTitle("Laser Chess");
		createBackground();
		createButtons();
		createLogo();
	}
	private void initScene1() {
		mainPane = new AnchorPane();
		mainScene = new Scene(mainPane,WIDTH,HEIGHT);
	}
	private void initScene2() {
		PlayerNameScene mainPane2 = new PlayerNameScene();
		PlayerScene = new Scene(mainPane2,WIDTH,HEIGHT);		
	}
	public static void createLogo() {
	}
	private void createBackground() {
		Image backgroundImage = new Image("/25199.jpg",1024, 768, false, false);
		BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
		mainPane.setBackground(new Background(background));
	}
	private void createButtons() {
		createPlayButton();
		createHowToPlayButton();
		createCreditsButton();
		createExitButton();
	}
	
	private void createPlayButton() {
		MenuButton playButton = new MenuButton("PLAY");
		mainPane.getChildren().add(playButton);
		
		playButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
					mainStage.setScene(PlayerScene);
			}
		});
	}
	
	private void createHowToPlayButton() {
		MenuButton HowToPlayButton = new MenuButton("HOW TO PLAY");
		mainPane.getChildren().add(HowToPlayButton);
	}
	
	private void createCreditsButton(){
		MenuButton CreditsButton = new MenuButton("CREDITS");
		mainPane.getChildren().add(CreditsButton);
	}
	
	private void createExitButton() {
		MenuButton ExitButton = new MenuButton("EXIT");
		mainPane.getChildren().add(ExitButton);
	}
	
	public static int getWidth() {
		return WIDTH;
	}
	public static int getHeight() {
		return HEIGHT;
	}
	public static Stage getMainStage() {
		return mainStage;
	}
	
}
