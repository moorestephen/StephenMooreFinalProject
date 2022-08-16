package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class ReviewOrderScene extends FinalProjectController {

	public static void loadScene() {
		Scene menuScene = applicationStage.getScene();
    	// Review Order Scene
    	// Scene Features
    	BorderPane reviewOrderContainer = new BorderPane();
    	HBox bottomOfPane = new HBox();
    	Button returnToMenu = new Button("Return to Menu");
    	// Adds returnToMenu centered right in the bottom of the createOrder Container
    	bottomOfPane.getChildren().addAll(returnToMenu);
    	bottomOfPane.setAlignment(Pos.CENTER_LEFT);
    	
    	// Feature Actions
    	returnToMenu.setOnAction(pressed -> applicationStage.setScene(menuScene));
    	
    	reviewOrderContainer.setPadding(new Insets(20));
    	reviewOrderContainer.setBottom(bottomOfPane);
    	Scene reviewOrderScene = new Scene(reviewOrderContainer, 800, 600);
    	applicationStage.setScene(reviewOrderScene);
	}

}
