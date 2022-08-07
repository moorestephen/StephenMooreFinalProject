package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FinalProjectController {
	static Stage applicationStage;

    @FXML
    private Button createOrderButton;

    @FXML
    private Button manageInventoryButton;

    @FXML
    private Button reviewOrdersButton;

    @FXML
    void goToManageInventory(ActionEvent goToManageInventory) {
    	ManageInventoryScene.loadScene();
    }

    @FXML
    void goToCreateOrder(ActionEvent goToCreateOrder) {
    	CreateOrderScene.loadScene();
    }

    @FXML
    void goToReviewOrder(ActionEvent goToReviewOrder) {
    	ReviewOrderScene.loadScene();
    }

}

