package application;

import java.util.ArrayList;
import java.util.Collections;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
/**
 * Abstract class CreateOrderScene extends FinalProjectController and loads the create order scene
 * @author steph
 *
 */
public class CreateOrderScene extends FinalProjectController {
	/**
	 * loadScene sets the Scene to the createOrder scene, which is coded directly into the method
	 * It also includes the action events for the buttons included in the scene (i.e., it loads the entire scene)
	 */
	public static void loadScene() {
		Scene menuScene = applicationStage.getScene();
    	
		// Create Order Scene
    	// Scene Features
    	BorderPane createOrderContainer = new BorderPane();
    	
    	// Bottom of pane - for returning to menu
    	HBox bottomOfPane = new HBox();
    	bottomOfPane.setSpacing(20);
    	Button returnToMenu = new Button("Return to Menu");
    	// Adds returnToMenu centered right in the bottom of the createOrder Container
    	bottomOfPane.getChildren().addAll(returnToMenu);
    	bottomOfPane.setAlignment(Pos.CENTER_LEFT);
    	
    	// Left side of pane - for searching items, viewing their inventory details, and adding them to the order
    	VBox leftOfPane = new VBox();
    	
    	VBox searchItem = new VBox();
    	searchItem.setSpacing(20);
    	Text searchTitle = new Text("Search");
    	HBox searchTextFieldsName = new HBox();
    	HBox searchTextFieldsTag = new HBox();
    	searchTextFieldsName.setSpacing(10);
    	searchTextFieldsTag.setSpacing(10);
    	TextField searchName = new TextField();
    	searchName.setPromptText("Search by item name");
    	Button searchNameButton = new Button("Search");
    	Label searchNameError = new Label("");
    	searchNameError.setPadding(new Insets(5, 0, 0, 0)); 
    	TextField searchTag = new TextField();
    	searchTag.setPromptText("Search by item tag");
    	Button searchTagButton = new Button("Search");
    	Label searchTagError = new Label("");
    	searchTagError.setPadding(new Insets(5, 0, 0, 0)); 
    	searchTextFieldsName.getChildren().addAll(searchName, searchNameButton, searchNameError);
    	searchTextFieldsTag.getChildren().addAll(searchTag, searchTagButton, searchTagError);
    	searchItem.getChildren().addAll(searchTitle, searchTextFieldsName, searchTextFieldsTag);
    	
    	VBox itemInfo = new VBox();
    	itemInfo.setSpacing(20);
    	HBox itemNameBox = new HBox();
    	Label itemNameFormat = new Label("Name: ");
    	Label itemName = new Label();
    	itemNameBox.getChildren().addAll(itemNameFormat, itemName);
    	HBox itemTagBox = new HBox();
    	Label itemTagFormat = new Label("Tag: ");
    	Label itemTag = new Label();
    	itemTagBox.getChildren().addAll(itemTagFormat, itemTag);
    	HBox itemWholesaleBox = new HBox();
    	Label itemWholesaleFormat = new Label("Wholesale Price: ");
    	Label itemWholesale = new Label();
    	itemWholesaleBox.getChildren().addAll(itemWholesaleFormat, itemWholesale);
    	HBox itemRetailBox = new HBox();
    	Label itemRetailFormat = new Label("Retail Price: ");
    	Label itemRetail = new Label();
    	itemRetailBox.getChildren().addAll(itemRetailFormat, itemRetail);
    	HBox itemStockBox = new HBox();
    	Label itemStockFormat = new Label("Stock: ");
    	Label itemStock = new Label();
    	itemStockBox.getChildren().addAll(itemStockFormat, itemStock);
    	itemInfo.getChildren().addAll(itemNameBox, itemTagBox, itemWholesaleBox, itemRetailBox, itemStockBox);
    	ArrayList<Label> itemInfoLabelList = new ArrayList<Label>();
    	Collections.addAll(itemInfoLabelList, itemName, itemTag, itemWholesale, itemRetail, itemStock);
    	
    	VBox addItemInfo = new VBox();
    	addItemInfo.setSpacing(20);
    	Text addItemTitle = new Text("Add Item");
    	HBox addItemDetails = new HBox();
    	addItemDetails.setSpacing(30);
    	TextField addItemQuantity = new TextField();
    	addItemQuantity.setPromptText("Quantity to order");
    	Button addItemToOrder = new Button("Add");
    	Label quantityError = new Label("");
    	addItemDetails.getChildren().addAll(addItemQuantity, addItemToOrder);
    	addItemInfo.getChildren().addAll(addItemTitle, addItemDetails, quantityError);
    	
    	leftOfPane.getChildren().addAll(searchItem, itemInfo, addItemInfo);
    	leftOfPane.setSpacing(20);
    	
    	
    	// Right side of pane - for viewing order details and making order
    	VBox rightOfPane = new VBox();
    	rightOfPane.setSpacing(10);
    	TableView<ItemOrder> orderTable = new TableView<ItemOrder>();
    	// Table details
    	orderTable.setPlaceholder(new Label("No items added to order"));
    	TableColumn<ItemOrder, String> itemNameCol = new TableColumn<ItemOrder, String>("Item");
    	itemNameCol.setCellValueFactory(new PropertyValueFactory<ItemOrder, String>("item"));
    	itemNameCol.setPrefWidth(125);
    	TableColumn<ItemOrder, Integer> itemQuantityCol = new TableColumn<ItemOrder, Integer>("Quantity");
    	itemQuantityCol.setCellValueFactory(new PropertyValueFactory<ItemOrder, Integer>("quantity"));
    	itemQuantityCol.setPrefWidth(125);
    	orderTable.getColumns().addAll(itemNameCol, itemQuantityCol);
    	orderTable.setItems(Order.getObservableListOrder());
    	// End of table details
    	Text subtotalFormat = new Text("Subtotal: ");
    	Label subtotalCalc = new Label();
    	Text taxFormat = new Text("Tax: ");
    	Label taxCalc = new Label();
    	Text totalFormat = new Text("Total: ");
    	Label totalCalc = new Label();
    	Separator orderSeparator = new Separator();
    	orderSeparator.setOrientation(Orientation.HORIZONTAL);
    	Text stockingPriceFormat = new Text("Stocking Price: ");
    	Label stockingPriceCalc = new Label();
    	Text profitFormat = new Text("Profit: ");
    	Label profitCalc = new Label();
    	HBox buttonBox = new HBox();
    	buttonBox.setSpacing(5);
    	buttonBox.setAlignment(Pos.CENTER_RIGHT);
    	Button clearOrder = new Button("Clear Order");
    	Button makeOrder = new Button("Make Order");
    	buttonBox.getChildren().addAll(clearOrder, makeOrder);
    	makeOrder.setAlignment(Pos.CENTER_RIGHT);
    	rightOfPane.getChildren().addAll(orderTable, subtotalFormat, subtotalCalc, taxFormat, taxCalc, totalFormat, totalCalc, 
    			orderSeparator, stockingPriceFormat, stockingPriceCalc, profitFormat, profitCalc, buttonBox);
    	
    	subtotalCalc.setText(String.valueOf(Order.df.format(Order.calculateSubtotal())));
		taxCalc.setText(String.valueOf(Order.df.format(Order.calculateTax())));
		totalCalc.setText(String.valueOf(Order.df.format(Order.calculateTotal())));
		stockingPriceCalc.setText(String.valueOf(Order.df.format(Order.calculateStockingPrice())));
		profitCalc.setText(String.valueOf(Order.df.format(Order.calculateProfit())));
    	
    	// Feature Actions
    	returnToMenu.setOnAction(pressed -> applicationStage.setScene(menuScene));
    	
    	
    	// Search by name
    	EventHandler<ActionEvent> searchByName = new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent buttonPressed) {
    			if (ValueValidation.checkString(searchName.getText())) {
    				Item searchedItem = Inventory.searchInventoryName(searchName.getText());
    				searchTag.clear();
    				addItemQuantity.clear();
    				if (searchedItem == null) {
    					searchTagError.setText("");
    					searchNameError.setText("Item \"" + searchName.getText() + "\" not found in inventory");
    					clearLabels(itemInfoLabelList);
    				} else {
    					searchNameError.setText("");
    					searchTagError.setText("");
    					itemName.setText(searchedItem.getItem());
    					itemTag.setText(Integer.toString(searchedItem.getTag()));
    					itemWholesale.setText(Double.toString(searchedItem.getWholesalePrice()));
    					itemRetail.setText(Double.toString(searchedItem.getRetailPrice()));
    					itemStock.setText(Integer.toString(searchedItem.getStock()));
    				}
    			}
    		}
    	};
    	
    	// Search by tag
    	EventHandler<ActionEvent> searchByTag = new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent buttonPressed) {
    			if (ValueValidation.checkNaturalNum(searchTag.getText())) {
    				Item searchedItem = Inventory.searchInventoryTag(searchTag.getText());
    				searchName.clear();
    				addItemQuantity.clear();
    				if (searchedItem == null) {
    					searchNameError.setText("");
    					searchTagError.setText("Tag " + searchTag.getText() + " not found in inventory");
    					clearLabels(itemInfoLabelList);
    				} else {
    					searchTagError.setText("");
    					searchNameError.setText("");
    					itemName.setText(searchedItem.getItem());
    					itemTag.setText(Integer.toString(searchedItem.getTag()));
    					itemWholesale.setText(Order.df.format(searchedItem.getWholesalePrice()));
    					itemRetail.setText(Order.df.format(searchedItem.getRetailPrice()));
    					itemStock.setText(Integer.toString(searchedItem.getStock()));
    				}
    			}
    		}
    	};
    	
    	// Add item to order (of quantity entered)
    	EventHandler<ActionEvent> addingItemToOrder = new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent buttonPressed) {
    			if (ValueValidation.checkInteger(itemStock.getText())) {
    				if (ValueValidation.checkNaturalNum(itemStock.getText())) {
		    			int currentStockItemToBeAdded = Integer.parseInt(itemStock.getText());
		    			if (Order.findInOrderTag(itemTag.getText())) {
		    				// Item is already in order
		    				quantityError.setText("Item " + itemName.getText() + " is already in the order. Enter items not already added to the order");
		    			} else if (ValueValidation.checkNaturalNum(addItemQuantity.getText()) && Integer.parseInt(addItemQuantity.getText()) <= currentStockItemToBeAdded) {
		    				Order.addToOrder(new ItemOrder(Inventory.searchInventoryTag(itemTag.getText()), Integer.parseInt(addItemQuantity.getText())));
		    				quantityError.setText("");
		    				orderTable.refresh();
		    				addItemQuantity.clear();
		    				
		    				subtotalCalc.setText(String.valueOf(Order.df.format(Order.calculateSubtotal())));
		    				taxCalc.setText(String.valueOf(Order.df.format(Order.calculateTax())));
		    				totalCalc.setText(String.valueOf(Order.df.format(Order.calculateTotal())));
		    				stockingPriceCalc.setText(String.valueOf(Order.df.format(Order.calculateStockingPrice())));
		    				profitCalc.setText(String.valueOf(Order.df.format(Order.calculateProfit())));
		    				
		    			} else if (ValueValidation.checkNaturalNum(addItemQuantity.getText())){
		    				quantityError.setText("Insufficient item stock. Only " + itemStock.getText() + " available");
		    				addItemQuantity.clear();
		    			} else {
		    				quantityError.setText("");
		    				invalidTextfield(addItemQuantity, "Item Quantity", ValueValidation.checkNaturalNumErrorMsg);
		    			}
		    		} else {
		    			quantityError.setText("Please enter a positive integer. \" " + addItemQuantity.getText() + "\" is not a positive integer");
		    		} 
    			} else {
    				quantityError.setText("Please search an item before adding it to inventory");
    			}
    		}
    	};
    	
    	// Make order
    	EventHandler<ActionEvent> makingOrder = new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent buttonPressed) {
    			if (Order.getOrder().size() >=1) {
    				Order.makeOrder();
    				orderTable.refresh();
    				
    				subtotalCalc.setText(String.valueOf(Order.df.format(Order.calculateSubtotal())));
    				taxCalc.setText(String.valueOf(Order.df.format(Order.calculateTax())));
    				totalCalc.setText(String.valueOf(Order.df.format(Order.calculateTotal())));
    				stockingPriceCalc.setText(String.valueOf(Order.df.format(Order.calculateStockingPrice())));
    				profitCalc.setText(String.valueOf(Order.df.format(Order.calculateProfit())));
    				
    				clearLabels(itemInfoLabelList);
    				searchName.clear();
    				searchTag.clear();
    			}
    		}
    	};
    	
    	// Clear order
    	EventHandler<ActionEvent> cancelOrder = new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent buttonPressed) {
    			Order.clearOrder();
    			orderTable.refresh();
    			
    			subtotalCalc.setText(String.valueOf(Order.df.format(Order.calculateSubtotal())));
				taxCalc.setText(String.valueOf(Order.df.format(Order.calculateTax())));
				totalCalc.setText(String.valueOf(Order.df.format(Order.calculateTotal())));
				stockingPriceCalc.setText(String.valueOf(Order.df.format(Order.calculateStockingPrice())));
				profitCalc.setText(String.valueOf(Order.df.format(Order.calculateProfit())));
				
				clearLabels(itemInfoLabelList);
				searchName.clear();
				searchTag.clear();
    		}
    	};
    	
    	// Build Scene
    	searchNameButton.setOnAction(searchByName);
    	searchTagButton.setOnAction(searchByTag);
    	addItemToOrder.setOnAction(addingItemToOrder);
    	makeOrder.setOnAction(makingOrder);
    	clearOrder.setOnAction(cancelOrder);
    	createOrderContainer.setPadding(new Insets(20));
    	createOrderContainer.setBottom(bottomOfPane);
    	createOrderContainer.setLeft(leftOfPane);
    	createOrderContainer.setRight(rightOfPane);
    	Scene createOrderScene = new Scene(createOrderContainer, 800, 600);
    	applicationStage.setScene(createOrderScene);
	}
	
}
