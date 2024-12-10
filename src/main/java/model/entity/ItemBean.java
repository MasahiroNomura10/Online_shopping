package model.entity;

import java.io.Serializable;

public class ItemBean implements Serializable {
	//名前
	private String itemName;
	
	//値段
	private int price;
	
	//在庫
	private int stock;
	
	
	//itemBean構築
	public ItemBean() {
	}
	
	
	//フィールドのitemNameの値を返す
	public String getItemName() {
		return itemName;
	}
	
	//フィールドitemNameの値を設定
	//@param itemName 名前
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	//フィールドのpriceの値を返す
	public int getprice() {
		return price;
	}
	
	//フィールドpriceの値を設定
		//@param price 値段
	public void setPrice(int price) {
		this.price = price;
	}
	
	//フィールドのstockの値を返す
	public int getStock() {
		return stock;
	}
	
	//フィールドstockの値を設定
			//@param stock 値段
	public void setStock(int stock) {
		this.stock = stock;
	}
}

