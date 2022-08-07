package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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

