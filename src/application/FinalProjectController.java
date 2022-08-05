package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
    	
    	// Middle of BorderPane - contains table and place to enter new values
    	VBox middleOfPane = new VBox();
    	
    	TableView inventoryTable = new TableView();
    	inventoryTable.setMaxSize(500, 300);
    	inventoryTable.setPlaceholder(new Label("No inventory to display"));
    	TableColumn item = new TableColumn("Item");
    	item.setPrefWidth(150);
    	TableColumn tag = new TableColumn("Tag");
    	tag.setPrefWidth(50);
    	TableColumn wholesalePrice = new TableColumn("Wholesale Price");
    	wholesalePrice.setPrefWidth(100);
    	TableColumn retailPrice = new TableColumn("Retail Price");
    	retailPrice.setPrefWidth(100);
    	TableColumn currentStock = new TableColumn("Stock");
    	currentStock.setPrefWidth(100);
    	inventoryTable.getColumns().addAll(item, tag, wholesalePrice, retailPrice, currentStock);
    	
    	HBox addInventory = new HBox();
    	
    	
    	middleOfPane.getChildren().addAll(inventoryTable);
    	middleOfPane.setAlignment(Pos.CENTER);
    	
    	// Feature Actions
    	returnToMenu.setOnAction(pressed -> applicationStage.setScene(menuScene));
    	
    	manageInventoryContainer.setPadding(new Insets(20));
    	manageInventoryContainer.setBottom(bottomOfPane);
    	manageInventoryContainer.setCenter(middleOfPane);
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

