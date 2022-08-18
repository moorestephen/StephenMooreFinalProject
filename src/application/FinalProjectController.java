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
    
    /** 
     * The clearAllTextfields method takes an input JavaFX TextField ArrayList and clears any an all text they hold at the time of method calling
     * @param textfieldsToClear is an ArrayList of JavaFX TextField
     */
	public static void clearAllTextfields(ArrayList<TextField> textfieldsToClear) {
		for (TextField textfield : textfieldsToClear) {
			textfield.clear();
		}
	}
	
	/**
	 * The invalidTextfield method is called when a TextField has an invalid entry for another method requiring its input. It creates an alert pop-up
	 * with a custom header and description dependent on the passed parameters, and clears the TextField of its invalid entry
	 * @param textfield is the TextField carrying the invalid entry and is to be cleared
	 * @param textfieldType is set as the alert header, and generally describes the TextField's purpose
	 * @param errorMessage is set as the alert body, and details what exact format should have been inserted in the TextField
	 */
	public static void invalidTextfield(TextField textfield, String textfieldType, String errorMessage) {
		Alert invalidTextfieldAlert = new Alert(AlertType.ERROR);
		invalidTextfieldAlert.setHeaderText("Invalid Input: " + textfieldType);
		invalidTextfieldAlert.setContentText(errorMessage);
		invalidTextfieldAlert.showAndWait();
		textfield.clear();
	}
	
	/**
	 * The clearLabels method clears all JavaFX Labels inputed in an ArrayList
	 * @param labelsToClear is the ArrayList containing the JavaFX labels to be cleared
	 */
	public static void clearLabels(ArrayList<Label> labelsToClear) {
		for (Label label : labelsToClear) {
			label.setText("");
		}
	}
}

