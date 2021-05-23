package gui;

import View.ViewManager;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MovementRules extends VBox{
	private static final String MOVEMENT_RULE1 = "/rule1.png";
	private static final String MOVEMENT_RULE2 = "/rule2.png";
	private static final String MOVEMENT_RULE3 = "/rule3.png";
	private static final String MOVEMENT_RULE4 = "/rule4.png";
	public MovementRules() {
		Label header = new Label("MOVEMENT RULES");
		header.setFont(Font.loadFont(ViewManager.class.getResource(ViewManager.getFontPath()).toExternalForm(),24));
		header.setTextFill(Color.BLACK);
		this.getChildren().add(header);
		HBox tmpHbox = new HBox();
		VBox tmpVbox = new VBox();
		tmpVbox = addRules(MOVEMENT_RULE1,1);
		tmpHbox.getChildren().add(tmpVbox);
		tmpVbox = addRules(MOVEMENT_RULE2,2);
		tmpHbox.getChildren().add(tmpVbox);
		tmpHbox.setSpacing(15);
		tmpHbox.setAlignment(Pos.CENTER);
		this.getChildren().add(tmpHbox);
		tmpHbox = new HBox();
		tmpVbox = addRules(MOVEMENT_RULE3,3);
		tmpHbox.getChildren().add(tmpVbox);
		tmpVbox = addRules(MOVEMENT_RULE4,4);
		tmpHbox.getChildren().add(tmpVbox);
		tmpHbox.setSpacing(15);
		tmpHbox.setAlignment(Pos.CENTER);
		this.getChildren().add(tmpHbox);
		this.setPadding(new Insets(10));
		this.setSpacing(10);
	}
	public VBox addRules(String url ,int order) {
		VBox tmpVbox = new VBox();
		Label tmpLabel = new Label();
		ImageView imv = new ImageView(new Image(url));
		imv.setFitWidth(100);
		imv.setFitHeight(100);
		if(order==1) {
			tmpLabel.setText("All token except the" + "\n"
					+ "Turret can move" + "\n"
					+ "in all 8 directions.");
		}
		else if(order==2) {
			tmpLabel.setText("All token can rotate " + "\n"
					+ "left or right.");
		}
		else if(order==3) {
			tmpLabel.setText("The Turret can only " + "\n"
					+ "rotate.");
		}
		else {
			tmpLabel.setText("The Switch can swap" + "\n"
					+ "place with another" + "\n"
					+ "Deflector or Defender.");
		}
		tmpVbox.setSpacing(10);
		tmpVbox.getChildren().addAll(imv , tmpLabel);
		return tmpVbox;
		
	}
}
