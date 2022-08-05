package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FinalProjectController {
	Stage applicationStage;

    @FXML
    private Button createOrderButton;

    @FXML
    private Button manageInventoryButton;

    @FXML
    private Button reviewOrdersButton;

    @FXML
    void goToManageInventory(ActionEvent goToManageInventory) {
    	Scene menuScene = applicationStage.getScene();
    	// Manage Inventory Scene
    	// Scene Features
    	BorderPane manageInventoryContainer = new BorderPane();
    	HBox bottomOfPane = new HBox();
    	Button returnToMenu = new Button("Return to Menu");
    	// Adds returnToMenu centered right in the bottom of the createOrder Container
    	bottomOfPane.getChildren().addAll(returnToMenu);
    	bottomOfPane.setAlignment(Pos.CENTER_RIGHT);
    	
    	// Feature Actions
    	returnToMenu.setOnAction(pressed -> applicationStage.setScene(menuScene));
    	
    	manageInventoryContainer.setPadding(new Insets(20));
    	manageInventoryContainer.setBottom(bottomOfPane);
    	Scene InventoryScene = new Scene(manageInventoryContainer, 800, 600);
    	applicationStage.setScene(InventoryScene);
    }

    @FXML
    void goToCreateOrder(ActionEvent goToCreateOrder) {
    	Scene menuScene = applicationStage.getScene();
    	// Create Order Scene
    	// Scene Features
    	BorderPane createOrderContainer = new BorderPane();
    	HBox bottomOfPane = new HBox();
    	Button returnToMenu = new Button("Return to Menu");
    	// Adds returnToMenu centered right in the bottom of the createOrder Container
    	bottomOfPane.getChildren().addAll(returnToMenu);
    	bottomOfPane.setAlignment(Pos.CENTER_RIGHT);
    	
    	// Feature Actions
    	returnToMenu.setOnAction(pressed -> applicationStage.setScene(menuScene));
    	
    	createOrderContainer.setPadding(new Insets(20));
    	createOrderContainer.setBottom(bottomOfPane);
    	Scene createOrderScene = new Scene(createOrderContainer, 800, 600);
    	applicationStage.setScene(createOrderScene);
    }

    @FXML
    void goToReviewOrder(ActionEvent goToReviewOrder) {
    	Scene menuScene = applicationStage.getScene();
    	// Review Order Scene
    	// Scene Features
    	BorderPane reviewOrderContainer = new BorderPane();
    	HBox bottomOfPane = new HBox();
    	Button returnToMenu = new Button("Return to Menu");
    	// Adds returnToMenu centered right in the bottom of the createOrder Container
    	bottomOfPane.getChildren().addAll(returnToMenu);
    	bottomOfPane.setAlignment(Pos.CENTER_RIGHT);
    	
    	// Feature Actions
    	returnToMenu.setOnAction(pressed -> applicationStage.setScene(menuScene));
    	
    	reviewOrderContainer.setPadding(new Insets(20));
    	reviewOrderContainer.setBottom(bottomOfPane);
    	Scene reviewOrderScene = new Scene(reviewOrderContainer, 800, 600);
    	applicationStage.setScene(reviewOrderScene);
    }

}

