package main;

import View.ViewManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{

	public void start(Stage primaryStage) {
		ViewManager manager = new ViewManager();
		primaryStage = ViewManager.getMainStage();
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
