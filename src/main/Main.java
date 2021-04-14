package main;

import gui.ViewManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{

	public void start(Stage primaryStage) {
		ViewManager manager = new ViewManager();
		primaryStage = manager.getMainStage();
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
