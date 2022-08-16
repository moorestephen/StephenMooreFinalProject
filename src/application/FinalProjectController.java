package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
    	// ReviewOrderScene.loadScene();
    }
    
	public static void clearAllTextfields(ArrayList<TextField> textfieldsToClear) {
		for (TextField textfield : textfieldsToClear) {
			textfield.clear();
		}
	}
	
	public static void invalidTextfield(TextField textfield, String textfieldType, String errorMessage) {
		Alert invalidTextfieldAlert = new Alert(AlertType.ERROR);
		invalidTextfieldAlert.setHeaderText("Invalid Input: " + textfieldType);
		invalidTextfieldAlert.setContentText(errorMessage);
		invalidTextfieldAlert.showAndWait();
		textfield.clear();
	}
	
	public static void clearLabels(ArrayList<Label> labelsToClear) {
		for (Label label : labelsToClear) {
			label.setText("");
		}
	}
}

