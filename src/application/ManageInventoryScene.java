package application;

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

public class ManageInventoryScene extends FinalProjectController {

	public static void loadScene() {
		Scene menuScene = applicationStage.getScene();
    	// Manage Inventory Scene
    	// Scene Features
    	BorderPane manageInventoryContainer = new BorderPane();
    	
    	HBox bottomOfPane = new HBox();
    	Button returnToMenu = new Button("Return to Menu");
    	// Adds returnToMenu centered right in the bottom of the createOrder Container
    	bottomOfPane.getChildren().addAll(returnToMenu);
    	bottomOfPane.setAlignment(Pos.CENTER_RIGHT);
    	
    	// Middle of BorderPane - contains table and place to enter new values
    	VBox middleOfPane = new VBox();
    	
    	TableView<Inventory> inventoryTable = new TableView<Inventory>();
    	
    	inventoryTable.setMaxSize(500, 300);
    	inventoryTable.setPlaceholder(new Label("No inventory to display"));
    	
    	TableColumn<Inventory, String> itemCol = new TableColumn<Inventory, String>("Item");
    	itemCol.setCellValueFactory(new PropertyValueFactory<Inventory, String>("item"));
    	itemCol.setPrefWidth(150);
    	
    	TableColumn<Inventory, Integer> tagCol = new TableColumn<Inventory, Integer>("Tag");
    	tagCol.setCellValueFactory(new PropertyValueFactory<Inventory, Integer>("tag"));
    	tagCol.setPrefWidth(50);
    	
    	TableColumn<Inventory, Double> wholesalePriceCol = new TableColumn<Inventory, Double>("Wholesale Price");
    	wholesalePriceCol.setCellValueFactory(new PropertyValueFactory<Inventory, Double>("wholesalePrice"));
    	wholesalePriceCol.setPrefWidth(100);
    	
    	TableColumn<Inventory, Double> retailPriceCol = new TableColumn<Inventory, Double>("Retail Price");
    	retailPriceCol.setCellValueFactory(new PropertyValueFactory<Inventory, Double>("retailPrice"));
    	retailPriceCol.setPrefWidth(100);
    	
    	TableColumn<Inventory, Integer> currentStockCol = new TableColumn<Inventory, Integer>("Stock");
    	currentStockCol.setCellValueFactory(new PropertyValueFactory<Inventory, Integer>("stock"));
    	currentStockCol.setPrefWidth(100);
    	
    	inventoryTable.getColumns().addAll(itemCol, tagCol, wholesalePriceCol, retailPriceCol, currentStockCol);
    	inventoryTable.setItems(Inventory.getObservableListInventory());

    	// Creating text boxes to enter new inventory items
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
    	
    	
    	middleOfPane.getChildren().addAll(inventoryTable, addInventory);
    	middleOfPane.setAlignment(Pos.CENTER);
    	
    	// Feature Actions
    	returnToMenu.setOnAction(pressed -> applicationStage.setScene(menuScene));
    	
    	EventHandler<ActionEvent> addToInventory = new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent buttonPressed) {
    			Inventory.createInventoryItem(
						itemName.getText(), 
						Integer.parseInt(itemTag.getText()), 
						Double.parseDouble(itemWholesalePrice.getText()),
						Double.parseDouble(itemRetailPrice.getText()),
						Integer.parseInt(itemCurrentStock.getText()));
    			itemName.clear();
				itemTag.clear();
				itemWholesalePrice.clear();
				itemRetailPrice.clear();
				itemCurrentStock.clear();
				inventoryTable.refresh();
    		}
    	};
    	
    	addInventoryDetails.setOnAction(addToInventory);
    	manageInventoryContainer.setPadding(new Insets(20));
    	manageInventoryContainer.setBottom(bottomOfPane);
    	manageInventoryContainer.setCenter(middleOfPane);
    	Scene InventoryScene = new Scene(manageInventoryContainer, 800, 600);
    	applicationStage.setScene(InventoryScene);
	}

}
