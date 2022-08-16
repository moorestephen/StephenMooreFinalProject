package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CreateOrderScene extends FinalProjectController {

	public static void loadScene() {
		Scene menuScene = applicationStage.getScene();
    	
		// Create Order Scene
    	// Scene Features
    	BorderPane createOrderContainer = new BorderPane();
    	HBox bottomOfPane = new HBox();
    	Button returnToMenu = new Button("Return to Menu");
    	// Adds returnToMenu centered right in the bottom of the createOrder Container
    	bottomOfPane.getChildren().addAll(returnToMenu);
    	bottomOfPane.setAlignment(Pos.CENTER_RIGHT);
    	
    	// Middle of BorderPane - contains table and place to enter new values
    	VBox leftOfPane = new VBox();
    	
    	VBox searchItem = new VBox();
    	VBox itemInfo = new VBox();
    	VBox addItemInfo = new VBox();
    	
    	leftOfPane.getChildren().addAll(searchItem, itemInfo, addItemInfo);
    	// baselineLeftOfPane.setAlignment(Pos.BASELINE_LEFT);
    	
    	
    	// Feature Actions
    	returnToMenu.setOnAction(pressed -> applicationStage.setScene(menuScene));
    	
    	// Build Scene
    	createOrderContainer.setPadding(new Insets(20));
    	createOrderContainer.setBottom(bottomOfPane);
    	createOrderContainer.setLeft(leftOfPane);
    	Scene createOrderScene = new Scene(createOrderContainer, 800, 600);
    	applicationStage.setScene(createOrderScene);
	}
	
}
