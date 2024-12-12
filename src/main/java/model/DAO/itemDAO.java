package model.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import model.entity.ItemBean;

/**
*		アイテム関係を管理するクラス
*/

public class itemDAO {
	
	//商品一覧のリスト？
	public List<ItemBean> itemDisplay() throws SQLException, ClassNotFoundException {
		List<ItemBean> itemList = new ArrayList<>();
		
		String sql = "SELECT item_id, item_name, price FROM item_table";
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet res = pstmt.executeQuery()) {
			
				while (resultSet.next()) {
					int itemId = resultSet.getInt("item_id");
					String itemName = resultSet.getString("item_name");
					int price = resultSet.getInt("price");
					
					ItemBean item = new ItemBean(itemId, itemName, price);
					itemList.add(item);
				}
			}
			return itemList;  //商品のリストを返す
	}
	
	public List<ItemBean> cartAdd(int itemID) throws SQLException, ClassNotFoundException {
		List<ItemBean> cartList = new ArrayList<>();
		
		
	}
	

	
	//リストの中身の合計金額を返す
	public int getAllPrice( List< ItemBean >item ) {
		
		//合計金額を入れるフィールド
		int allPrice = 0;
		
		
		//カートの中身を拡張for文でアイテムの金額をallPriceに加算していく
		for( ItemBean i : item ) {
			allPrice += i.getprice();
			
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