package application;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {
	private static ArrayList<Item> listInventory = new ArrayList<Item>();
	private static ObservableList<Item> observableListInventory = FXCollections.observableList(listInventory);
	
	// Adds new instance of an item with variables set to arguments required to ArrayList (i.e., the inventory)
	public static void createInventoryItem(String itemToAdd, int tagToAdd, Double wholesalePriceToAdd, Double retailPriceToAdd, int stockToAdd) {
		listInventory.add(new Item(itemToAdd, tagToAdd, wholesalePriceToAdd, retailPriceToAdd, stockToAdd));
	}
	
	// Checks if all arguments as strings will be valid when parsed to create a new item instance variable
	public static boolean checkItemValidity(String itemToAdd, String tagToAdd, String wholesalePriceToAdd, String retailPriceToAdd, String stockToAdd) {
		if (ValueValidation.checkString(itemToAdd) && ValueValidation.checkNaturalNum(tagToAdd) && ValueValidation.checkValidMoney(wholesalePriceToAdd)
				&& ValueValidation.checkValidMoney(retailPriceToAdd) && ValueValidation.checkWholeNum(stockToAdd) && !ValueValidation.checkTagRepeats(tagToAdd)) {
			return true;
		} else {
			return false;
		}
	}
	
	// Converts all arguments as strings to the required argument type for createInventoryItem (useful for pulling values from text boxes)
	public static void addToInventory(String itemToAdd, String tagToAdd, String wholesalePriceToAdd, String retailPriceToAdd, String stockToAdd) {
		createInventoryItem(itemToAdd, 
				Integer.parseInt(tagToAdd), 
				Double.parseDouble(wholesalePriceToAdd),
				Double.parseDouble(retailPriceToAdd),
				Integer.parseInt(stockToAdd));
	}
	
	public static ObservableList<Item> getObservableListInventory() {
		return observableListInventory;
	}

	public void setObservableListInventory(ObservableList<Item> observableListInventory) {
		Inventory.observableListInventory = observableListInventory;
	}

	public static ArrayList<Item> getListInventory() {
		return listInventory;
	}
	
	
}
