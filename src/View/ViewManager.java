package View;

import java.util.ArrayList;

import gui.BoardPane;
import gui.ButtonController;
import gui.CreateBoardPicker;
import gui.LaserChessSubScene;
import gui.LaserPane;
import gui.MenuButton;
import gui.PlayerNameScene;
import gui.TokenGuide;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.GridPane;
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
	private static Scene mainScene,PlayerScene,boardPickerScene;
	private static LaserPane laserPane;
	private static BoardPane boardPane;
	private static StackPane gamePane;
	private static ButtonController buttonController;
	private LaserChessSubScene HowToPlaySubScene,CreditsSubScene,SceneToHide;
	private int i;
	public ViewManager() {
		initScene1();
		mainStage = new Stage();
		mainStage.setScene(mainScene);
		mainStage.setTitle("Laser Chess");
		createBackground();
		createSubScene();
		createButtons();
		createlogo();
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
		gamePane.getChildren().addAll(boardPane);
		vBox.getChildren().addAll(gamePane,buttonController);
		Scene BoardScene = new Scene(vBox,ViewManager.getWidth(),ViewManager.getHeight());
		ViewManager.getMainStage().setScene(BoardScene);
		mainStage.setHeight(900);
		mainStage.setWidth(1100);
	}
	private void createSubScene() {
		HowToPlaySubScene = new LaserChessSubScene();
		CreditsSubScene = new LaserChessSubScene();
		mainPane.getChildren().addAll(HowToPlaySubScene,CreditsSubScene);
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
	public static void shootLaser(ArrayList<int[]> laserPath){
		laserPane = new LaserPane();
		gamePane.getChildren().add(laserPane);
		Thread tmp = new Thread(){
			public void run() {
				try {
					for(int i = 0 ; i < laserPath.size() ; i++) {
						sleep(100);
						int laserIndex = i;
						String url = "/" + "laser" + laserPath.get(i)[0] + ".png";
						Platform.runLater(new Runnable() {
							@Override public void run() {
								Image image = new Image(url);
								ImageView imageView = new ImageView(image);
								imageView.setFitHeight(100);
								imageView.setFitWidth(100);
								placeLaser(imageView,laserPath.get(laserIndex)[2],laserPath.get(laserIndex)[1]);			            		
							}
						});
					}
					sleep(300);
					Platform.runLater(new Runnable() {
						public void run() {
							clearLaser();						
						}
					});
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		tmp.start();
	}
	private static void placeLaser(ImageView image,int x,int y) {
		laserPane.add(image,x,y);
	}
	private static void clearLaser() {
		gamePane.getChildren().remove(1);
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
				initScene2();
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
				HowToPlaySubScene.getPane().getChildren().add(tokenguide);
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
