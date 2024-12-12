package model.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import model.entity.ItemBean;

/**
*		アイテム関係を管理するクラス
*/

public class itemDAO {
	
	//商品一覧のリストを表示する処理
	public List<ItemBean> itemDisplay() throws SQLException, ClassNotFoundException {
		List<ItemBean> itemList = new ArrayList<>();
		
		String sql = "SELECT * FROM item_table";
		
		try (Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery(sql)) {
			
				while (res.next()) {
					int itemId = res.getInt("item_id");
					String itemName = res.getString("item_name");
					int stock = res.getInt("stock");
					int price = res.getInt("price");
					
					ItemBean item = new ItemBean();
					item.setItemId(itemId);
					item.setItemName(itemName);
					item.setStock(stock);
					item.setPrice(price);
					itemList.add(item);
				}
			}
			return itemList;  //商品のリストを返す
	}
	
	
	//カートに追加する処理
	public List<ItemBean> cartAdd(int itemId, int amount) throws SQLException, ClassNotFoundException {
		List<ItemBean> cartList = new ArrayList<>();
		
		String sql = "SELECT * FROM item_table WHERE item_id = ?";
		
		try (Connection con = ConnectionManager.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql)) {
		
			pstmt.setInt(1, itemId);
			
				
		try (ResultSet res = pstmt.executeQuery()) {
		if (res.next()) { 
				
			String itemName = res.getString("item_name");
			int price = res.getInt("price");
			
			ItemBean item = new ItemBean();
			item.setItemName(itemName);
			item.setPrice(price);
			item.setAmount(amount);
			
			cartList.add(item);
				}
			}
		}
		return cartList;
//		idで識別するように
	}
	

	
	//リストの中身の合計金額を返す
	public int getAllPrice( List< ItemBean >item ) {
		
		//合計金額を入れるフィールド
		int allPrice = 0;
		
		
		//カートの中身を拡張for文でアイテムの金額をallPriceに加算していく
		for( ItemBean i : item ) {
			allPrice += i.getPrice();
			
		}
		
		return allPrice;
	}
	
	
	
	
	
	
	//購入できるかを判定
	public boolean purchase( List< ItemBean >item, HttpSession session ) {
		
		//判定フィールド
		boolean judge = false;
		
		//ユーザーの残高を入れる
		int money = 0;

		//合計金額フィールド
		int totalPay = getAllPrice(item);
		
		//ログインしているユーザーネームを取得する
		String name = (String)session.getAttribute("userName");
		
		
		//購入判定
		if( money >= totalPay ) {
			//可能
			judge = true;
		}else {
			//不可能
			judge = false;
		}
	
		//判定を返す
		return judge;
	}
	
}