<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!-- アイテムビーンをインポート -->
<%@page import = "java.util.List,model.entity.ItemBean.java" %>


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
		//while( cart.hasNext() ){
		
		for( List<ItemBean> contents : cart ){
	%>

	カートの中身<br>

	名称　個数　値段

	<br>

	<!-- カートの中身を表示 -->
	<%=cart.getItemName();//名称%>　<%=cart.getStok();//個数%>　<%=cart.getPrice();//値段%><br>

	<%
		//値段を加算していく
		totalNum += cart.getPrice();
	%>
	
	<br>

	<%}%>

	小計<br>

	<!-- 合計金額を表示 -->
	<%= totalNum%>

	<form action="purchaseFailure.jsp" method="POST">
		<input type="submit" value="購入"><br>
		<br>
	</form>	
	
	
	<form action="itemList.jsp" method="POST">
		<input type="submit" value="商品ページに戻る">
	</form>


</body>

</html>