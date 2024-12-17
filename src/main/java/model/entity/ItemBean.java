package model.entity;

import java.io.Serializable;

public class ItemBean implements Serializable {
	//id
	private int itemId;
	
	//名前
	private String itemName;
	
	//値段
	private int price;
	
	//在庫
	private int stock;
	
	//購入数
	private int amount;
	
	
	
	//itemBean構築
	public ItemBean() {
	}
	
	//フィールドのitemIdの値を返す
	public int getItemId() {
		return itemId;
	}
	
	//フィールドitemIdの値を設定
	//@param itemId 商品のID
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	
	//フィールドのitemNameの値を返す
	public String getItemName() {
		return itemName;
	}
	
	//フィールドitemNameの値を設定
	//@param itemName 商品の名前
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	//フィールドのpriceの値を返す
	public int getPrice() {
		return price;
	}
	
	//フィールドpriceの値を設定
		//@param price 商品の値段
	public void setPrice(int price) {
		this.price = price;
	}
	
	//フィールドのstockの値を返す
	public int getStock() {
		return stock;
	}
	
	//フィールドstockの値を設定
	//@param stock 商品の在庫数
	public void setStock(int stock) {
	this.stock = stock;
	}
	
	//フィールドamountの値を設定
	//@param amount 購入数量
	public void setAmount(int amount) {
		this.amount = amount;
	}
		
	//フィールドのamountの値を返す
	public int getAmount() {
		return amount;
	}
	
}

