package application;

import java.text.DecimalFormat;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Order {
	private static ArrayList<ItemOrder> order = new ArrayList<ItemOrder>();
	private static ObservableList<ItemOrder> observableListOrder = FXCollections.observableList(order);
	
	public static void addToOrder(ItemOrder addedItem) {
		order.add(addedItem);
	}

	public static ObservableList<ItemOrder> getObservableListOrder() {
		return observableListOrder;
	}
	
	public static boolean findInOrderTag(String tagSearched) {
		for (ItemOrder orderItem : order) {
			if (orderItem.getTag() == Integer.parseInt(tagSearched)) {
				return true;
			}
		}
		// Returns false if no match is found
		return false;
	}
	
	final static DecimalFormat df = new DecimalFormat("0.00");
	
	public static double calculateSubtotal() {
		double subtotal = 0.00;
		for (ItemOrder items: order) {
			subtotal += items.getRetailPrice() * items.getQuantity();
		}
		return subtotal;
	}
	
	public static double calculateTax() {
		return calculateSubtotal() * 0.05;
	}
	
	public static double calculateTotal() {
		return calculateSubtotal() + calculateTax();
	}
	
	public static double calculateStockingPrice() {
		double stockingPrice = 0;
		for (ItemOrder items: order) {
			stockingPrice += items.getWholesalePrice() * items.getQuantity();
		}
		return stockingPrice;
	}
	
	public static double calculateProfit() {
		return (calculateTotal() - calculateTax()) - calculateStockingPrice();
	}
	
	public static ArrayList<ItemOrder> getOrder() {
		return order;
	}
	
	public static void makeOrder() {
		for (ItemOrder items : order) {
			for (Item inventory : Inventory.getListInventory()) {
				if (items.getTag() == inventory.getTag()) {
					inventory.setStock(inventory.getStock() - items.getQuantity());
				}
			}
		}
		order.removeAll(observableListOrder);
	}
	
	public static void clearOrder() {
		order.removeAll(observableListOrder);
	}
}
