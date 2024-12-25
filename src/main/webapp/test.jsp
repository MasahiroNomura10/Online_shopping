<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.entity.ItemBean" %>

<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.Statement" %>

<%@ page import="model.DAO.ConnectionManager" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>購入画面</title>

	<!--CSSのファイルを読み込み-->
	<link rel="stylesheet" type="text/css" href="./css/test.css">

</head>
<body>


	<div class = "test_Main">
	
		<div class = "main_Title">
	    	<h1>購入確認</h1>
	    </div>
	
	    <% 
	        // セッションからカートリストを取得
	        List<ItemBean> cartList = (List<ItemBean>) session.getAttribute("cartList");
	    
			//ログインしているユーザーネームを取得する
	  		String name = (String)session.getAttribute("userName");
	        
			//取得したいユーザーの残高索用SQL
			String sql = "SELECT money FROM user_table WHERE user_name = ?";
			
			Connection con = ConnectionManager.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			//SQL文に取得したユーザーネームをセットする
			pstmt.setString( 1, name );
			
			ResultSet res = pstmt.executeQuery();
			
	  		//ユーザーの残高を入れる
	  		int money = 0;
	
	  		if(res.next()) {
				//残高を取得する
				money = res.getInt("money");
			}
			 
	        if (cartList != null && !cartList.isEmpty()) {
	    %>
	    <div class = "main_Text">
		    <table border="1" class = "cart">
		        <tr>
		            <th>商品名</th>
		            <th>購入数</th>
		            <th>価格</th>
		            <th>小計</th>
		        </tr>
		        <% 
		            int total = 0;
		            for (ItemBean item : cartList) {
		                int subtotal = item.getPrice() * item.getAmount();
		                total += subtotal;
		        %>
		        <tr>
		            <td><%= item.getItemName() %></td>
		            <td><%= item.getAmount() %></td>
		            <td><%= item.getPrice() %></td>
		            <td><%= subtotal %></td>
		        </tr>
		        <% } %>
		    </table>
		    <br>
		    <p>ユーザー残高: <%= money %>円</p>
		    <p>合計金額: <%= total %>円</p>
		    
		    <form action="purchaseServlet" method="POST">
		        <input type="submit" value="購入する" class = "button">
		    </form>
		    <% 
		        } else {
		    %>
		    <p class = "text_None">カートは空です。</p>
		    <% 
		        }
		    %>
		    <form action="itemList.jsp" method="POST">
		    	<input type="submit" value="商品ページに戻る" class = "button">
		    </form>
	    
	    </div>
    </div>
</body>
</html>