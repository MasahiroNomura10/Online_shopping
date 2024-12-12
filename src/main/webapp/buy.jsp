<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!-- アイテムビーンをインポート -->
<%@page import = "java.util.List,model.entity.ItemBean" %>


<%
	//リクエストスコープからデータの取得
	List<ItemBean> cart = request.getAttribute("itemList");
%>


<html>

<head>

<meta charset="UTF-8">


<title>購入画面</title>

</head>

<body>
	<h1>購入画面</h1>
	
	<%
		//小計の合算を入れるフィールド
		int totalNum = 0;
		
		//リストの中身を全て表示
		for( List<ItemBean> contents : cart ){
	%>

	カートの中身<br>

	名称　個数　値段

	<br>

	<!-- カートの中身を表示 -->
	<%=contents.getItemName();//名称%>　<%=contents.getStok();//個数%>　<%=contents.getPrice();//値段%><br>

	<%
		//値段を加算していく
		totalNum += contents.getPrice();
	%>
	
	<br>

	<%}%>

	小計<br>

	<!-- 合計金額を表示 -->
	<%= totalNum%>

	<!-- 購入成功or購入失敗へ -->
	<form action="purchaseServlet.java" method="POST">
		<input type="submit" value="購入"><br>
		<br>
	</form>	
	
	<!-- 商品画面へ -->
	<form action="itemList.jsp" method="POST">
		<input type="submit" value="商品ページに戻る">
	</form>


</body>

</html>