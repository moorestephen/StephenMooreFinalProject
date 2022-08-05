package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    void goToManageInventory(ActionEvent event) {
    	System.out.println("Manage Inventory was clicked");
    	VBox manageInventoryContainer = new VBox();
    	Scene InventoryScene = new Scene(manageInventoryContainer, 800, 600);
    	applicationStage.setScene(InventoryScene);
    }

    @FXML
    void goToCreateOrder(ActionEvent event) {
    	System.out.println("Create Order was clicked");
    	VBox createOrderContainer = new VBox();
    	Scene createOrderScene = new Scene(createOrderContainer, 800, 600);
    	applicationStage.setScene(createOrderScene);
    }

    @FXML
    void goToReviewOrder(ActionEvent event) {
    	System.out.println("Review Order was clicked");
    	VBox reviewOrderContainer = new VBox();
    	Scene reviewOrderScene = new Scene(reviewOrderContainer, 800, 600);
    	applicationStage.setScene(reviewOrderScene);
    }

}

