package application;
/**
 * The Item class builds an item with several characteristics and which can/will be added to the inventory
 * @author steph
 *
 */
public class Item {
	private String item;
	private int tag;
	private double wholesalePrice;
	private double retailPrice;
	private int stock;
	
	
	/**
	 * Constructor for the Item class; instantiates a new object based on the passed arguments
	 * @param item
	 * @param tag
	 * @param wholesalePrice
	 * @param retailPrice
	 * @param stock
	 */
	public Item(String item, int tag, double wholesalePrice, double retailPrice, int stock) {
		this.item = item;
		this.tag = tag;
		this.wholesalePrice = wholesalePrice;
		this.retailPrice = retailPrice;
		this.stock = stock;
	}
	
	/**
	 * Constructor for a deep copy of an Item already instantiated
	 * @param toCopy is the item to be copied
	 */
	public Item(Item toCopy) {
		this(new String(toCopy.getItem()), toCopy.getTag(), toCopy.getWholesalePrice(), toCopy.getRetailPrice(), toCopy.getStock());
	}
	
	/**
	 * Item getter
	 * @return item
	 */
	public String getItem() {
		return item;
	}
	
	 /**
	  * Tag getter
	  * @return tag
	  */
	public int getTag() {
		return tag;
	}
	
	 /**
	  * Wholesale price getter
	  * @return wholesalePrice
	  */
	public double getWholesalePrice() {
		return wholesalePrice;
	}
	
	/**
	 * Wholesale price setter
	 * @param wholesalePrice is the wholesale price to be modified
	 */
	public void setWholesalePrice(double wholesalePrice) {
		this.wholesalePrice = wholesalePrice;
	}
	
	/**
	 * Retail price getter
	 * @return retailPrice
	 */
	public double getRetailPrice() {
		return retailPrice;
	}
	
	/**
	 * Retail price setter
	 * @param retailPrice is the retailPrice to be modified
	 */
	public void setRetailPrice(double retailPrice) {
		this.retailPrice = retailPrice;
	}
	
	/** 
	 * Item stock getter
	 * @return stock
	 */
	public int getStock() {
		return stock;
	}
	
	/**
	 * Item stock setter
	 * @param stock is the stock instance variable to be modified
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}
}
