package application;

import java.util.ArrayList;
import java.util.Collections;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
/**
 * ManageInventoryScene extends FinalProjectController 
 * @author steph
 *
 */
public abstract class ManageInventoryScene extends FinalProjectController {
	
	public static void loadScene() {
		// Set menuScene to current scene (so that the user can return to the menuScene)
		Scene menuScene = applicationStage.getScene();
		

    	// Building the Manage Inventory scene in JavaFX out of a root BorderPane (for this scene)
    	BorderPane manageInventoryContainer = new BorderPane();
    	manageInventoryContainer.setPadding(new Insets(20));
    	
    	// Return to menu button placed in bottom of pane
    	HBox bottomOfPane = new HBox();
    	Button returnToMenu = new Button("Return to Menu");
    	bottomOfPane.getChildren().addAll(returnToMenu);
    	bottomOfPane.setAlignment(Pos.CENTER_LEFT);
    	
    	// Return to the main menu when menu button is pressed
    	returnToMenu.setOnAction(pressed -> applicationStage.setScene(menuScene));
    	
    	// Inventory table (set of columns inside a table that list all items currently in inventory along with their respective details)
    	TableView<Item> inventoryTable = new TableView<Item>();
    	inventoryTable.setMaxSize(500, 300);
    	inventoryTable.setPlaceholder(new Label("No inventory to display"));  	
    	TableColumn<Item, String> itemCol = new TableColumn<Item, String>("Item");
    	itemCol.setCellValueFactory(new PropertyValueFactory<Item, String>("item"));
    	itemCol.setPrefWidth(150);
    	TableColumn<Item, Integer> tagCol = new TableColumn<Item, Integer>("Tag");
    	tagCol.setCellValueFactory(new PropertyValueFactory<Item, Integer>("tag"));
    	tagCol.setPrefWidth(50);
    	TableColumn<Item, Double> wholesalePriceCol = new TableColumn<Item, Double>("Wholesale Price");
    	wholesalePriceCol.setCellValueFactory(new PropertyValueFactory<Item, Double>("wholesalePrice"));
    	wholesalePriceCol.setPrefWidth(100);
    	TableColumn<Item, Double> retailPriceCol = new TableColumn<Item, Double>("Retail Price");
    	retailPriceCol.setCellValueFactory(new PropertyValueFactory<Item, Double>("retailPrice"));
    	retailPriceCol.setPrefWidth(100);
    	TableColumn<Item, Integer> currentStockCol = new TableColumn<Item, Integer>("Stock");
    	currentStockCol.setCellValueFactory(new PropertyValueFactory<Item, Integer>("stock"));
    	currentStockCol.setPrefWidth(100);
    	inventoryTable.getColumns().addAll(itemCol, tagCol, wholesalePriceCol, retailPriceCol, currentStockCol);
    	// Link the table columns to the Inventory's observable list inventory (maintaining the correct values for each column)
    	inventoryTable.setItems(Inventory.getObservableListInventory());
    	
    	// Add new item to inventory (a set of TextFields and a Button)
    	VBox middleOfPane = new VBox();
    	HBox addInventory = new HBox();
    	addInventory.setPadding(new Insets(10, 10, 10, 10));
    	addInventory.setAlignment(Pos.CENTER);
    	VBox col1 = new VBox();
    	VBox col2 = new VBox();
    	VBox col3 = new VBox();
    	TextField itemName = new TextField();;
    	itemName.setPromptText("Item Name");
    	TextField itemTag = new TextField();
    	itemTag.setPromptText("Item Tag");
    	TextField itemWholesalePrice = new TextField();
    	itemWholesalePrice.setPromptText("Wholesale Price");
    	TextField itemRetailPrice = new TextField();
    	itemRetailPrice.setPromptText("Retail Price");
    	TextField itemCurrentStock = new TextField();
    	itemCurrentStock.setPromptText("Current Stock");
    	Button addInventoryDetails = new Button("Add New Inventory Details");
    	col1.getChildren().addAll(itemName, itemTag);
    	col2.getChildren().addAll(itemWholesalePrice, itemRetailPrice);
    	col3.getChildren().addAll(itemCurrentStock, addInventoryDetails);
    	addInventory.getChildren().addAll(col1, col2, col3);
    	// Creating ArrayList with all TextFields inside for easy access/modification
    	ArrayList<TextField> inputTextFields = new ArrayList<TextField>();
    	Collections.addAll(inputTextFields, itemName, itemTag, itemWholesalePrice, itemRetailPrice, itemCurrentStock);
    	
    	// Set middle of pane including table and add item menu
    	middleOfPane.getChildren().addAll(inventoryTable, addInventory);
    	middleOfPane.setAlignment(Pos.CENTER); 	
    	
    	// Add bottomOfPane (return to menu button) and middleOfPane (inventory table and add item)
    	manageInventoryContainer.setBottom(bottomOfPane);
    	manageInventoryContainer.setCenter(middleOfPane);
    	
    	// Define new scene built out of root manageInventory Container
    	Scene InventoryScene = new Scene(manageInventoryContainer, 800, 600);
    	

    	
    	// Set event handler method to add the entered values to the inventory and clear the entry table (if inputed correctly) to be called on add to inventory button
    	EventHandler<ActionEvent> addToInventory = new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent buttonPressed) {
    			String inputName = itemName.getText(); 
				String inputTag = itemTag.getText();
				String inputWholesalePrice = itemWholesalePrice.getText();
				String inputRetailPrice = itemRetailPrice.getText();
				String inputStock = itemCurrentStock.getText();
    			if (Inventory.checkItemValidity(inputName, inputTag, inputWholesalePrice, inputRetailPrice, inputStock)) {
    				Inventory.addToInventory(inputName, inputTag, inputWholesalePrice, inputRetailPrice, inputStock);
    				inventoryTable.refresh();
    				clearAllTextfields(inputTextFields);
    			} else {
    				if (!ValueValidation.checkString(inputName))
    					invalidTextfield(itemName, "Item Name", ValueValidation.checkStringErrorMsg);
    				if (!ValueValidation.checkNaturalNum(inputTag)) 
    					invalidTextfield(itemTag, "Item Tag", ValueValidation.checkNaturalNumErrorMsg);	
    				if (!ValueValidation.checkValidMoney(inputWholesalePrice))
    					invalidTextfield(itemWholesalePrice, "Wholesale Price", ValueValidation.checkValidMoneyErrorMsg);
    				if (!ValueValidation.checkValidMoney(inputRetailPrice))
    					invalidTextfield(itemRetailPrice, "Retail Price", ValueValidation.checkValidMoneyErrorMsg);
    				if (!ValueValidation.checkWholeNum(inputStock))
    					invalidTextfield(itemCurrentStock, "Current Stock", ValueValidation.checkWholeNumErrorMsg);
    				if (ValueValidation.checkTagRepeats(inputTag)) 
						invalidTextfield(itemTag, "Item Tag", ValueValidation.checkTagRepeatsErrorMsg);
    				if (ValueValidation.checkNameRepeats(inputName))
    					invalidTextfield(itemName, "Item Name", ValueValidation.checkItemRepeatsErrorMsg);
    			}
    		}
    	};
    	addInventoryDetails.setOnAction(addToInventory);
    	
    	// Set scene to inventory scene
    	applicationStage.setScene(InventoryScene);
	}

}
