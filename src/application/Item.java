package application;

public class Item {
	private String item;
	private int tag;
	private double wholesalePrice;
	private double retailPrice;
	private int stock;
	
	
	
	public Item(String item, int tag, double wholesalePrice, double retailPrice, int stock) {
		this.item = item;
		this.tag = tag;
		this.wholesalePrice = wholesalePrice;
		this.retailPrice = retailPrice;
		this.stock = stock;
	}
	
	public Item(Item toCopy) {
		this(new String(toCopy.getItem()), toCopy.getTag(), toCopy.getWholesalePrice(), toCopy.getRetailPrice(), toCopy.getStock());
	}
	
	public String getItem() {
		return item;
	}
	
	public int getTag() {
		return tag;
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
}
