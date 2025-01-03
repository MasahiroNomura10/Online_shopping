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
	public ItemBean cartAdd(int itemId, int amount)
	        throws SQLException, ClassNotFoundException {
	    List<ItemBean> cartList = new ArrayList<>();
	    
	    String sql = "SELECT * FROM item_table WHERE item_id = ?";
	    
	    ItemBean item = null;
	    
	    try (Connection con = ConnectionManager.getConnection();
	         PreparedStatement pstmt = con.prepareStatement(sql)) {
	        
	        // itemIdsとamountsのリストループ処理
//	        for (int i = 0; i < itemIds.size(); i++) {
//	            int itemId = itemIds.get(i); // 商品IDを取得
//	            int amount = amounts.get(i); // 購入数を取得
	            
	            pstmt.setInt(1, itemId); // SQLに商品IDをセット
	            
	            try (ResultSet res = pstmt.executeQuery()) {
	                if (res.next()) { 
	                    String itemName = res.getString("item_name");
	                    int price = res.getInt("price");
	                    int stock = res.getInt("stock");
	                    
	                    // ItemBeanを作成し、リストに追加
	                    item = new ItemBean();
	                    item.setItemName(itemName);
	                    item.setPrice(price);
	                    item.setStock(stock);
	                    
	                    item.setAmount(amount);
	                   
	                    
	                    cartList.add(item);
	                    System.out.println("cartList" + cartList);
	                }
	            }
	        
	    }
	    return item;
	}


	

	
	//リストの中身の合計金額を返す
	public int getAllPrice( List< ItemBean >item ) {
		
		//合計金額を入れるフィールド
		int allPrice = 0;
		
		
		//カートの中身を拡張for文で購入個数を掛けてアイテムの金額をallPriceに加算していく
		for( ItemBean i : item ) {
			allPrice += ( i.getPrice() * i.getAmount() );
			
		}
		
		return allPrice;
	}
	
	
	
	
	
	
	//購入できるかを判定
	public boolean purchase( List< ItemBean >item, HttpSession session )  throws SQLException, ClassNotFoundException {
				
		//判定フィールド
		boolean judge = false;
		
		//ユーザーの残高を入れる
		int money = 0;

		//合計金額フィールド
		int totalPay = getAllPrice(item);
		
		//ログインしているユーザーネームを取得する
		String name = (String)session.getAttribute("userName");
		
		//取得したいユーザーの残高索用SQL
		String sql = "SELECT money FROM user_table WHERE user_name = ?";
		
		//SQLの実行
		try (Connection con = ConnectionManager.getConnection();
			 PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			//SQL文に取得したユーザーネームをセットする
			pstmt.setString( 1, name );

				
			//SQLの値を取得する
			try (ResultSet res = pstmt.executeQuery()) {
				if(res.next()) {
					//残高を取得する
					money = res.getInt("money");
					System.out.println("money="+money );
				}
			}
		}
		
		//購入判定
		if( money >= totalPay ) {
			//可能
			judge = true;

			//データベースの購入したアイテムを減少する
			minusitemOperation( item );
			
			//データベースからユーザーの残高を減らす
			minusOperation( name, totalPay );
			
			//カートのリストの初期化
			item.clear();
			
		}else {
			//不可能
			judge = false;
		}
	
		//判定を返す
		return judge;
	}
	
	//データベースから購入したカートの中身のアイテムの在庫を減少させる
	public void minusitemOperation( List< ItemBean >cart )  throws SQLException, ClassNotFoundException {
		
		//更新された行の数を格納するフィールド
		int resultNum = 0;
		
		//更新したいアイテムのの在庫SQL
		String sql = "UPDATE item_table SET stock = stock - ?  WHERE item_name = ?";
		
		//SQLの実行
		try ( Connection con = ConnectionManager.getConnection();
			  PreparedStatement pstmt = con.prepareStatement( sql ) ) {
			
			//拡張for文でリストの数だけアイテムの在庫を減少させる
			for( ItemBean i : cart ) {

				//購入した数を取得する
				int amount = i.getAmount();

				//購入したアイテムのネームを取得する
				String name = i.getItemName();
		
				//SQL文に更新したい購入数をセットする
				pstmt.setInt( 1, amount );

				//SQL文に更新したいアイテムネームをセットする
				pstmt.setString( 2, name );

				//SQL文を実行しアイテムの在庫数を更新する
				resultNum = pstmt.executeUpdate();
			}
		}

	}



	//データベースからユーザーの残高を引数の値だけ減少させる
	public void minusOperation( String name, int minus )  throws SQLException, ClassNotFoundException {
		
		//更新された行の数を格納するフィールド
		int resultNum = 0;
		
		//更新したいアイテムのの在庫SQL
		String sql = "UPDATE user_table SET money = money - ?  WHERE user_name = ?";
		
		//SQLの実行
		try ( Connection con = ConnectionManager.getConnection();
			  PreparedStatement pstmt = con.prepareStatement( sql ) ) {
					
			//SQL文に更新したい購入数をセットする
			pstmt.setInt( 1, minus );

			//SQL文に更新したいアイテムネームをセットする
			pstmt.setString( 2, name );

			//SQL文を実行しアイテムの在庫数を更新する
			resultNum = pstmt.executeUpdate();

		}

	}
	
	
}