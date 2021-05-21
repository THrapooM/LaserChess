package gui;

import javafx.geometry.Insets;
import javafx.scene.SubScene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class EndGameSubScene extends SubScene{
	public EndGameSubScene() {
		super(new AnchorPane() ,300,500);
		prefWidth(300);
		prefHeight(500);
		AnchorPane root2 = (AnchorPane) this.getRoot();
		root2.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		root2.setBorder(new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, 
				CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	}
	public AnchorPane getPane() {
		return (AnchorPane) this.getRoot();
	}
}
