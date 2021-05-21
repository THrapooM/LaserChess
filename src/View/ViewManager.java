package View;

import java.util.ArrayList;

import element.Audioloader;
import gui.BoardPane;
import gui.ButtonController;
import gui.CreateBoardPicker;
import gui.EndGameButton;
import gui.EndGameSubScene;
import gui.LaserChessSubScene;
import gui.LaserPane;
import gui.MenuButton;
import gui.MovementRules;
import gui.PlayerNameScene;
import gui.TokenGuide;
import gui.PlayerTurn;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.GameManager;

public class ViewManager {
	private static final int WIDTH = 1024;
	private static final int HEIGHT = 768;
	private static AnchorPane mainPane;
	private static Stage mainStage;
	private static Scene mainScene,PlayerScene,boardPickerScene;
	private static LaserPane laserPane;
	private static BoardPane boardPane;
	private static StackPane gamePane;
	private static ButtonController buttonController;
	private static PlayerTurn playerTurn;
	private static LaserChessSubScene playerSubScene;
	private static LaserChessSubScene HowToPlaySubScene;
	private static LaserChessSubScene CreditsSubScene;
	private static LaserChessSubScene SceneToHide;
	private static EndGameSubScene endMenuSubScene;
	private static EndGameButton endGameButton;
	private static CreateBoardPicker AllBoard;
	private final static String FONT_PATH = "ZenDots-Regular.ttf";
	public ViewManager() {
		mainStage = new Stage();
		mainStage.setTitle("Laser Chess");
		playSound();
		initMainScene();
	}
	public void playSound() {
		AudioClip backgroundsound = Audioloader.backGroundSound;
		backgroundsound.setCycleCount(AudioClip.INDEFINITE);
		backgroundsound.setVolume(0.05);
		backgroundsound.play();
	}
	public static void initMainScene() {
		mainPane = new AnchorPane();
		mainScene = new Scene(mainPane,WIDTH,HEIGHT);
		MenuButton.setHeight(300);
		createBackground();
		createSubScene();
		createButtons();
		createlogo();
		ViewManager.getMainStage().setWidth(WIDTH);
		ViewManager.getMainStage().setHeight(HEIGHT);
		ViewManager.getMainStage().setScene(mainScene);
	}
	
	public static void initBoardPickerScene() {
		AllBoard = new CreateBoardPicker();
		AllBoard.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY,CornerRadii.EMPTY, Insets.EMPTY)));
		boardPickerScene = new Scene(AllBoard,ViewManager.getWidth(),ViewManager.getHeight());
		ViewManager.getMainStage().setScene(boardPickerScene);
	}
	private static void createSubScene() {
		HowToPlaySubScene = new LaserChessSubScene();
		CreditsSubScene = new LaserChessSubScene();
		playerSubScene = new LaserChessSubScene();
		mainPane.getChildren().addAll(playerSubScene,HowToPlaySubScene,CreditsSubScene);
	}
	public static void showEndScene() {
		endMenuSubScene =  new EndGameSubScene();
		String WinnerName = GameManager.getWinnerTeam();
		Label label = new Label(WinnerName + " win");
		label.setFont(new Font(FONT_PATH,23));
		VBox tmpVBox = new VBox();
		endGameButton = new EndGameButton();
		tmpVBox.getChildren().addAll(label,endGameButton);
		tmpVBox.setLayoutX(50);
		tmpVBox.setLayoutY(250);
		tmpVBox.setSpacing(50);
		tmpVBox.setAlignment(Pos.CENTER);
		endMenuSubScene.getPane().getChildren().addAll(tmpVBox);
		Thread thread = new Thread(() -> {
					Platform.runLater(new Runnable() {
						public void run() {
							gamePane.getChildren().add(endMenuSubScene);
						}
					});
		});
		thread.start();
	}
	public static void initGameScene(int boardNumber) {
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
	private static void showSubScene(LaserChessSubScene subScene) {
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
	private static void createBackground() {
		Image backgroundImage = new Image("/25199.jpg",1024, 768, false, false);
		BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
		mainPane.setBackground(new Background(background));
	}
	private static void createButtons() {
		createPlayButton();
		createHowToPlayButton();
		createCreditsButton();
		createExitButton();
	}
	
	private static void createPlayButton() {
		MenuButton playButton = new MenuButton("/PLAYbutton.png");
		mainPane.getChildren().add(playButton);
		
		playButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				showSubScene(playerSubScene);
				try {
					PlayerNameScene playerNameScene = new PlayerNameScene();
					playerSubScene.getPane().getChildren().add(playerNameScene);					
				}catch(Exception e) {}
			}
		});
	}
	
	private static void createHowToPlayButton() {
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
	
	private static void createCreditsButton(){
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
	
	private static void createExitButton() {
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
	private static void createlogo() {
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
	public static StackPane getGamePane() {
		return gamePane;
	}
	public static Scene getMainScene() {
		return mainScene;
	}
}
