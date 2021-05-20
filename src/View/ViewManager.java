package View;

import java.util.ArrayList;

import gui.BoardPane;
import gui.ButtonController;
import gui.CreateBoardPicker;
import gui.LaserChessSubScene;
import gui.LaserPane;
import gui.MenuButton;
import gui.MovementRules;
import gui.PlayerNameScene;
import gui.TokenGuide;
import gui.PlayerTurn;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import logic.GameManager;

public class ViewManager {
	private static final int WIDTH = 1024;
	private static final int HEIGHT = 768;
	private AnchorPane mainPane;
	private static Stage mainStage;
	private static Scene mainScene,PlayerScene,boardPickerScene;
	private static LaserPane laserPane;
	private static BoardPane boardPane;
	private static StackPane gamePane;
	private static ButtonController buttonController;
	private static PlayerTurn playerTurn;
	private LaserChessSubScene playerSubscene,HowToPlaySubScene,CreditsSubScene,SceneToHide;
	public ViewManager() {
		initScene1();
		mainStage = new Stage();
		mainStage.setScene(mainScene);
		mainStage.setTitle("Laser Chess");
		createBackground();
		createSubScene();
		createButtons();
		createlogo();playSound();
	}
	public void playSound() {
		AudioClip backgroundsound = new AudioClip(getClass().getResource("/audio/backgroundsound.wav").toExternalForm());
		backgroundsound.setCycleCount(AudioClip.INDEFINITE);
		backgroundsound.setVolume(0.05);
		backgroundsound.play();
	}
	private void initScene1() {
		mainPane = new AnchorPane();
		mainScene = new Scene(mainPane,WIDTH,HEIGHT);
	}
	
	public static void initScene3() {
		CreateBoardPicker AllBoard = new CreateBoardPicker();
		AllBoard.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY,CornerRadii.EMPTY, Insets.EMPTY)));
		boardPickerScene = new Scene(AllBoard,ViewManager.getWidth(),ViewManager.getHeight());
		ViewManager.getMainStage().setScene(boardPickerScene);
	}
	public static void initScene4(int boardNumber) {
		GameManager.startGame(boardNumber);
		VBox vBox = new VBox();
		playerTurn = new PlayerTurn();
		buttonController = new ButtonController();
		gamePane = new StackPane();
		gamePane.setPrefSize(800, 1000);
		gamePane.setAlignment(Pos.CENTER);
		boardPane = new BoardPane();
		gamePane.getChildren().addAll(boardPane);
		vBox.getChildren().addAll(playerTurn,gamePane,buttonController);
		Scene BoardScene = new Scene(vBox,ViewManager.getWidth(),ViewManager.getHeight());
		ViewManager.getMainStage().setScene(BoardScene);
		mainStage.setHeight(930);
		mainStage.setWidth(1100);
		mainStage.setResizable(false);
	}
	private void createSubScene() {
		HowToPlaySubScene = new LaserChessSubScene();
		CreditsSubScene = new LaserChessSubScene();
		playerSubscene = new LaserChessSubScene();
		mainPane.getChildren().addAll(playerSubscene,HowToPlaySubScene,CreditsSubScene);
	}
	private void showSubScene(LaserChessSubScene subScene) {
		if(SceneToHide!=null) {
			SceneToHide.moveSubScene();
		}
		subScene.moveSubScene();
		SceneToHide = subScene;
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
	public static void startLaserPane() {
		laserPane = new LaserPane();
		gamePane.getChildren().add(laserPane);
	}
	public static void placeLaser(ImageView image,int x,int y) {
		laserPane.add(image,x,y);
	}
	public static void clearLaser() {
		gamePane.getChildren().remove(1);
	}
	public static void swapTurn() {
		playerTurn.swapTurn();
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
		MenuButton playButton = new MenuButton("/PLAYbutton.png");
		mainPane.getChildren().add(playButton);
		
		playButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				showSubScene(playerSubscene);
				try {
					PlayerNameScene playerNameScene = new PlayerNameScene();
					playerSubscene.getPane().getChildren().add(playerNameScene);					
				}catch(Exception e) {}
			}
		});
	}
	
	private void createHowToPlayButton() {
		MenuButton HowToPlayButton = new MenuButton("/HOWTOPLAYbutton.png");
		mainPane.getChildren().add(HowToPlayButton);
		HowToPlayButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				showSubScene(HowToPlaySubScene);
				TokenGuide tokenguide = new TokenGuide();
				tokenguide.setLayoutX(15);
				tokenguide.setLayoutY(5);
				HowToPlaySubScene.getPane().getChildren().add(tokenguide);
				MovementRules movementRules = new MovementRules();
				movementRules.setLayoutX(290);
				movementRules.setLayoutY(5);
				HowToPlaySubScene.getPane().getChildren().add(movementRules);
			}
		});
	}
	
	private void createCreditsButton(){
		MenuButton CreditsButton = new MenuButton("/CREDITSbutton.png");
		mainPane.getChildren().add(CreditsButton);
		CreditsButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				showSubScene(CreditsSubScene);
			}
		});
	}
	
	private void createExitButton() {
		MenuButton ExitButton = new MenuButton("/EXITbutton.png");
		mainPane.getChildren().add(ExitButton);
		ExitButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				mainStage.close();
			}
		});
	}
	private void createlogo() {
		ImageView logo= new ImageView("/LASER_CHESS_logo.png");
		logo.setOnMouseEntered(new EventHandler<MouseEvent>() {
			
			public void handle(MouseEvent arg0) {
				logo.setEffect(new Glow(0.4));
			}
		});
		logo.setOnMouseExited(new EventHandler<MouseEvent>() {
			
			public void handle(MouseEvent arg0) {
				logo.setEffect(null);
			}
		});
		mainPane.getChildren().add(logo);
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
