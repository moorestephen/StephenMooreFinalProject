package application;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {
	private static ArrayList<Item> listInventory = new ArrayList<Item>();
	private static ObservableList<Item> observableListInventory = FXCollections.observableList(listInventory);
	
	public static void createInventoryItem(String itemToAdd, int tagToAdd, Double wholesalePriceToAdd, Double retailPriceToAdd, int stockToAdd) {
		listInventory.add(new Item(itemToAdd, tagToAdd, wholesalePriceToAdd, retailPriceToAdd, stockToAdd));
	}
	
	public static ObservableList<Item> getObservableListInventory() {
		return observableListInventory;
	}

	public void setObservableListInventory(ObservableList<Item> observableListInventory) {
		Inventory.observableListInventory = observableListInventory;
	}
	
	
}
