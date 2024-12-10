package model.DAO;


import java.util.List;



/**
*		アイテム関係を管理するクラス
*/

public class itemDAO {
	
	
	//購入できるかを判定
	public boolean purchase( List< Integer >itemBean, List< Integer >UserBean, int userId ) {
		
		//判定フィールド
		boolean judge = false;
		//ユーザーの残高を入れる
		int money = UserBean.get( userId + 5 );
		//合計金額フィールド
		int totalPay = 0;
		//カートの中身を判別する際に進めるカウント
		int count = 0;
		//アイテムごとの個数フィールド
		int itemNum = 0;
		//アイテムごとの値段フィールド
		int itemPay = 0;
		//カウントを進める時にアイテム群を一つ分進める時の値
		final int ITEMDATA = 3;
		
		//カートのリストから合計金額を取得する
		while( itemBean.get( count ) != 0 ) {
			//リストから個数を取得
			itemNum = itemBean.get( count + 1);
			//リストから値段を取得
			itemPay = itemBean.get( count + 2);
			
			//合計金額に追加する
			totalPay += (itemNum * itemPay);
			
			//次のアイテムに進む
			count += ITEMDATA;
		}
		
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