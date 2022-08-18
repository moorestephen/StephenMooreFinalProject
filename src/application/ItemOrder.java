package application;
/**
 * The ItemOrder class creates a specific item instance to added to an order, and gives it the additional instance variable of quantity
 * @author steph
 *
 */
public class ItemOrder extends Item {
	private int quantity;
	
	/**
	 * A constructor that instantiates a new ItemOrder object (i.e., an Item in an order)
	 * @param item is the name of the item
	 * @param tag is the item's tag
	 * @param wholesalePrice is the item's wholesale price
	 * @param retailPrice is the item's retail price
	 * @param stock is the item's stock
	 * @param quantity is the quantity of the item order
	 */
	public ItemOrder(String item, int tag, double wholesalePrice, double retailPrice, int stock, int quantity) {
		super(item, tag, wholesalePrice, retailPrice, stock);
		this.quantity = quantity;
	}
	
	/**
	 * A constructor that instantiates a new ItemOrder object from an instantiated item and the quantity ordered
	 * @param itemDetails
	 * @param quantity
	 */
	public ItemOrder(Item itemDetails, int quantity) {
		super(itemDetails);
		this.quantity = quantity;
	}

	/**
	 * Getter for the quantity instance variable
	 * @return quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	
	
}
