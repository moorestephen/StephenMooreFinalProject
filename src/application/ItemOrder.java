package application;

public class ItemOrder extends Item {
	private int quantity;
	
	public ItemOrder(String item, int tag, double wholesalePrice, double retailPrice, int stock, int quantity) {
		super(item, tag, wholesalePrice, retailPrice, stock);
		this.quantity = quantity;
	}
	
	public ItemOrder(Item itemDetails, int quantity) {
		super(itemDetails);
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}
	
	
}
