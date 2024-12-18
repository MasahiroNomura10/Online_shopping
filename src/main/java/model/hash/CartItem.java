package model.hash;

import model.entity.ItemBean;

public class CartItem {

	private ItemBean item;
	private String itemName;
	private int price;
	private int amount;
	
	public CartItem(ItemBean item, String itemName, int price, int amount) {
		this.item = item;
		this.itemName = itemName;
		this.price = price;
		this.amount = amount;
	}
	
	public ItemBean getItem() {
		return item;
	}

	/**
	 * @return itemName
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * @param itemName セットする itemName
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * @return price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price セットする price
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * @return amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount セットする amount
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * @param item セットする item
	 */
	public void setItem(ItemBean item) {
		this.item = item;
	}
	
}
