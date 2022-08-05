package application;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {
	private String item;
	private int tag;
	private double wholesalePrice;
	private double retailPrice;
	private int stock;
	private static ArrayList<Inventory> listInventory = new ArrayList<Inventory>();
	private static ObservableList<Inventory> observableListInventory = FXCollections.observableList(listInventory);
	
	
	public Inventory(String item, int tag, double wholesalePrice, double retailPrice, int stock) {
		this.item = item;
		this.tag = tag;
		this.wholesalePrice = wholesalePrice;
		this.retailPrice = retailPrice;
		this.stock = stock;
	}
	
	public static void createInventoryItem(String itemToAdd, int tagToAdd, Double wholesalePriceToAdd, Double retailPriceToAdd, int stockToAdd) {
		listInventory.add(new Inventory(itemToAdd, tagToAdd, wholesalePriceToAdd, retailPriceToAdd, stockToAdd));
		System.out.println(observableListInventory);
		System.out.println(listInventory);
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getTag() {
		return tag;
	}

	public void setTag(int tag) {
		this.tag = tag;
	}

	public double getWholesalePrice() {
		return wholesalePrice;
	}

	public void setWholesalePrice(double wholesalePrice) {
		this.wholesalePrice = wholesalePrice;
	}

	public double getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(double retailPrice) {
		this.retailPrice = retailPrice;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public static ObservableList<Inventory> getObservableListInventory() {
		return observableListInventory;
	}

	public void setObservableListInventory(ObservableList<Inventory> observableListInventory) {
		this.observableListInventory = observableListInventory;
	}
	
	
}
