package View;

import java.util.ArrayList;

import gui.BoardPane;
import gui.ButtonController;
import gui.CreateBoardPicker;
import gui.LaserPane;
import gui.MenuButton;
import gui.PlayerNameScene;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import logic.GameManager;

public class ViewManager {
	private static final int WIDTH = 1024;
	private static final int HEIGHT = 768;
	private AnchorPane mainPane;
	private static Stage mainStage;
	private static Scene mainScene,PlayerScene,boardPickerScene,gameScene;
	private static LaserPane laserPane;
	private static BoardPane boardPane;
	private static StackPane gamePane;
	private static ButtonController buttonController;
	public ViewManager() {
		initScene1();
		mainStage = new Stage();
		mainStage.setScene(mainScene);
		mainStage.setTitle("Laser Chess");
		createBackground();
		createButtons();
	}
	private void initScene1() {
		mainPane = new AnchorPane();
		mainScene = new Scene(mainPane,WIDTH,HEIGHT);
	}
	public static void initScene2() {
		PlayerNameScene mainPane2 = new PlayerNameScene();
		PlayerScene = new Scene(mainPane2,WIDTH,HEIGHT);
		mainStage.setScene(PlayerScene);
	}
	public static void initScene3() {
		CreateBoardPicker AllBoard = new CreateBoardPicker();
		boardPickerScene = new Scene(AllBoard,ViewManager.getWidth(),ViewManager.getHeight());
		ViewManager.getMainStage().setScene(boardPickerScene);
	}
	public static void initScene4(int boardNumber) {
		GameManager.startGame(boardNumber);
		VBox vBox = new VBox();
		buttonController = new ButtonController();
		gamePane = new StackPane();
		gamePane.setPrefSize(800, 1000);
		gamePane.setAlignment(Pos.CENTER);
		boardPane = new BoardPane();
		laserPane = new LaserPane();
		gamePane.getChildren().addAll(boardPane);
		//addEventHandler();
		vBox.getChildren().addAll(gamePane,buttonController);
		Scene BoardScene = new Scene(vBox,ViewManager.getWidth(),ViewManager.getHeight());
		ViewManager.getMainStage().setScene(BoardScene);
		mainStage.setHeight(900);
		mainStage.setWidth(1100);
	}
	public static void highlight(ArrayList<int[]>cell) {
		for(int i = 0 ; i < cell.size(); i++) {
			boardPane.getBoardCell(cell.get(i)[0],cell.get(i)[1]).highlight();
		}
	}
	public static void unhighlight() {
		for(int i = 0 ; i < 8 ;i++) {
			for(int j = 0 ; j < 10 ; j++) {
				boardPane.getBoardCell(i,j).unhighlight();
			}		
		}
	}
	public static void updateBoard() {
		for(int i = 0 ; i < 8 ;i++) {
			for(int j = 0 ; j < 10 ; j++) {
				boardPane.getBoardCell(i,j).updateChessPiece();
				boardPane.getBoardCell(i,j).updatePic();
			}		
		}
	}
	public static void shootLaser(ArrayList<int[]> laserPath){
		System.out.println("shootLaser");
		for(int i = 0 ; i < laserPath.size() ; i++) {
			String url = "/" + "laser" + laserPath.get(i)[0] + ".png";
			Image image = new Image(url);
			ImageView imageView = new ImageView(image);
			imageView.setFitHeight(100);
			imageView.setFitWidth(100);
			laserPane.add(imageView,laserPath.get(i)[2],laserPath.get(i)[1]);
			PauseTransition pause = new PauseTransition(Duration.seconds(1));
			pause.pause();
		}
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
				initScene2();
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
