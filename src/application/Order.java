package application;

import java.text.DecimalFormat;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 * The Order class represents an order object which contains an ArrayList of ItemOrders (i.e., item's to be ordered) and a collection of methods
 * modifying the order
 * @author steph
 *
 */
public class Order {
	private static ArrayList<ItemOrder> order = new ArrayList<ItemOrder>();
	private static ObservableList<ItemOrder> observableListOrder = FXCollections.observableList(order);
	
	/**
	 * addToOrder adds the ItemOrder passed as an argument to the order ArrayList
	 * @param addedItem is the ItemOrder to be added to the order
	 */
	public static void addToOrder(ItemOrder addedItem) {
		order.add(addedItem);
	}

	/**
	 * Getter for the observable list order
	 * @return observableListOrder
	 */
	public static ObservableList<ItemOrder> getObservableListOrder() {
		return observableListOrder;
	}
	
	/**
	 * findInOrderTag takes a tag of type String and iterates through the order to try to find a match within
	 * @param tagSearched is the tag being searched for
	 * @return true if the tag is present in an ItemOrder in the order, false if not
	 */
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
	
	/**
	 * calculateSubtotal calculates the cost of the order's ItemOrders based on the retail price of each ItemOrder and the quantity ordered
	 * @return total cost of the current order
	 */
	public static double calculateSubtotal() {
		double subtotal = 0.00;
		for (ItemOrder items: order) {
			subtotal += items.getRetailPrice() * items.getQuantity();
		}
		return subtotal;
	}
	
	/**
	 * calculateTax calculates the tax of the subtotal
	 * @return the subtotal multiplied by the tax rate
	 */
	public static double calculateTax() {
		double taxRate = 0.05;
		return calculateSubtotal() * taxRate;
	}
	
	/**
	 * calculateTotal calculates the total sum of the subtotal and its tax
	 * @return sum of the calculateSubtotal and calculateTax methods for the order
	 */
	public static double calculateTotal() {
		return calculateSubtotal() + calculateTax();
	}
	
	/**
	 * calculateStockingPrice calculates the total stocking price of the order using each ItemOrder's retail price and the quantity ordered
	 * @return
	 */
	public static double calculateStockingPrice() {
		double stockingPrice = 0;
		for (ItemOrder items: order) {
			stockingPrice += items.getWholesalePrice() * items.getQuantity();
		}
		return stockingPrice;
	}
	
	/**
	 * calculateProfit calculates the total amount of money made from the given order
	 * @return the stocking price subtracted from the stocking price of the order
	 */
	public static double calculateProfit() {
		return (calculateTotal() - calculateTax()) - calculateStockingPrice();
	}
	
	/**
	 * Getter for the order ArrayList
	 * @return order
	 */
	public static ArrayList<ItemOrder> getOrder() {
		return order;
	}
	
	/**
	 * makeOrder completes the order; it subtracts the quantity of each item ordered from the inventory stock and clears all of the ItemOrder objects
	 * in the order list
	 */
	public static void makeOrder() {
		for (ItemOrder items : order) {
			for (Item inventory : Inventory.getListInventory()) {
				if (items.getTag() == inventory.getTag()) {
					inventory.setStock(inventory.getStock() - items.getQuantity());
				}
			}
		}
		order.removeAll(observableListOrder);
		Inventory.updateInventoryToFile();
	}
	
	/**
	 * clearOrder removes all ItemOrder objects in the order list without removing their corresponding quantities from the inventory list (i.e.,
	 * it lets users restart their orders)
	 */
	public static void clearOrder() {
		order.removeAll(observableListOrder);
	}
}
