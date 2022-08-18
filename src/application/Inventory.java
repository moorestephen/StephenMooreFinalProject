package application;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 * The inventory class holds an ArrayList of Items and offers several methods to manipulate said lists
 * @author steph
 *
 */
public class Inventory {
	private static ArrayList<Item> listInventory = new ArrayList<Item>();
	private static ObservableList<Item> observableListInventory = FXCollections.observableList(listInventory);
	
	/**
	 * createInventoryItem instantiates a new Item and adds it to the inventory list (listInventory)
	 * @param itemToAdd is the name of the item as a string
	 * @param tagToAdd is the tag of the item as an integer
	 * @param wholesalePriceToAdd is the wholesale price of the item as a double
	 * @param retailPriceToAdd is the retail price of the item as a double
	 * @param stockToAdd is the stock of the item as an integer
	 */
	public static void createInventoryItem(String itemToAdd, int tagToAdd, Double wholesalePriceToAdd, Double retailPriceToAdd, int stockToAdd) {
		listInventory.add(new Item(itemToAdd, tagToAdd, wholesalePriceToAdd, retailPriceToAdd, stockToAdd));
		updateInventoryToFile();
	}
	
	/** 
	 * checkItemValidity verifies that the parameters (all strings) can be used to instantiate a new Item object (by parsing)
	 * @param itemToAdd the potential item name	
	 * @param tagToAdd the potential item tag
	 * @param wholesalePriceToAdd the potential item wholesale price
	 * @param retailPriceToAdd the potential item retail price
	 * @param stockToAdd the potential item stock
	 * @return true if the correctly parsed parameters can instantiate a new object, false if not
	 */
	public static boolean checkItemValidity(String itemToAdd, String tagToAdd, String wholesalePriceToAdd, String retailPriceToAdd, String stockToAdd) {
		if (ValueValidation.checkString(itemToAdd) && ValueValidation.checkNaturalNum(tagToAdd) && ValueValidation.checkValidMoney(wholesalePriceToAdd)
				&& ValueValidation.checkValidMoney(retailPriceToAdd) && ValueValidation.checkWholeNum(stockToAdd) && !ValueValidation.checkTagRepeats(tagToAdd) 
				&& !ValueValidation.checkNameRepeats(itemToAdd)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * addToInventory parses string parameters and correctly passes them (after parsing) to createInventoryItem to add the Item to listInventory
	 * @param itemToAdd is the item name 
	 * @param tagToAdd is the item tag (parsed to integer)
	 * @param wholesalePriceToAdd is the item wholesale price (parsed to double)
	 * @param retailPriceToAdd is the item retail price (parsed to double)
	 * @param stockToAdd is the item stock (parsed to int)
	 */
	public static void addToInventory(String itemToAdd, String tagToAdd, String wholesalePriceToAdd, String retailPriceToAdd, String stockToAdd) {
		createInventoryItem(itemToAdd, 
				Integer.parseInt(tagToAdd), 
				Double.parseDouble(wholesalePriceToAdd),
				Double.parseDouble(retailPriceToAdd),
				Integer.parseInt(stockToAdd));
	}
	
	/**
	 * searchInventoryName iterates through the inventory searching for an Item with the same name as the parameter
	 * @param nameSearched item name being searched for 
	 * @return the Item object sharing the same name if it exists in the inventory, and a null object if not
	 */
	public static Item searchInventoryName(String nameSearched) {
		for (Item inventoryItem : listInventory) {
			if (inventoryItem.getItem().equals(nameSearched)) {
				return new Item(inventoryItem);
			}
		}
		// Returns a null item if no match is found - must be managed at next step
		return null;
	}
	
	/**
	 * searchInventoryTag iterates through the inventory searching for an Item with the same tag as the parameter
	 * @param tagSearched is the tag being searched for
	 * @return the Item object sharing the same tag if it exists in the inventory, and a null object if not
	 */
	public static Item searchInventoryTag(String tagSearched) {
		for (Item inventoryItem : listInventory) {
			if (inventoryItem.getTag() == Integer.parseInt(tagSearched)) {
				return new Item(inventoryItem);
			}
		}
		// Returns a null item if no match is found - must be managed at next step
		return null;
	}
	
	/**
	 * getter for the ObservableListInventory
	 * @return observableListInventory
	 */
	public static ObservableList<Item> getObservableListInventory() {
		return observableListInventory;
	}

	/**
	 * setter for the ObservableListInventory
	 * @param observableListInventory is the list to be set
	 */
	public void setObservableListInventory(ObservableList<Item> observableListInventory) {
		Inventory.observableListInventory = observableListInventory;
	}
	
	/** 
	 * getter for the ListInventory
	 * @return listInventory
	 */
	public static ArrayList<Item> getListInventory() {
		return listInventory;
	}
	
	/**
	 * updateInventoryToFile writes the current inventory items to the inventory file for maintenance of inventory
	 */
	public static void updateInventoryToFile() {
		try {
			FileWriter inventoryFile = new FileWriter("inventory", false);
			for (Item item : listInventory) {
				// inventoryFile.write(itemToAdd + "," + tagToAdd + "," + wholesalePriceToAdd + "," + retailPriceToAdd + "," + stockToAdd + "\n");
				inventoryFile.write(item.getItem() + "," + item.getTag() + "," + item.getWholesalePrice() 
										+ "," + item.getRetailPrice() + "," + item.getStock() + "\n");
			}
			inventoryFile.close();
		} catch(IOException ioe) {
			System.out.println("Not loaded properly");
		}
	}
	
	
}
