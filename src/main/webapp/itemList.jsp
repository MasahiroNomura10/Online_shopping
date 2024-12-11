<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,model."%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品一覧画面</title>
</head>
<body>
	<h1>商品一覧</h1>
	
<!--	ログアウトし、トップ画面（ログイン画面）へ-->
	<form action="top.jsp" method="GET">
		<input type="submit" value="ログアウト"><br>
		<br>
	</form>
		
<!--		カートへ追加したら購入画面へ-->
	<form action="buy.jsp" method="POST">
		<input type="submit" value="購入(カートへ)"><br>
		<br>
		</form>

	<%
	List<ItemBean> itemList
		= (List<ItemBean>) request.getAttribute("itemList");
	%>
	<table>
			<tr>
				<th>名称<th>
				<th>購入数<th>
				<th>値段<th>
			<tr>
			<%
			for (ItemBean item: itemList) {
			%>
			<tr>
				<td><%=item.getId()%></td>
				<td><%=item.getName()%></td>
				<td>
					<form action=""></form>
			}
	</table>





<!--下に前のがあります。-->




<!--	<h1>商品一覧</h1>-->
	
<!--	ログアウトし、トップ画面（ログイン画面）へ-->
<!--	<form action="top.jsp" method="GET">-->
<!--		<input type="submit" value="ログアウト"><br>-->
<!--		<br>-->
<!--	</form>-->
		
		
<!--		カートへ追加したら購入画面へ-->
<!--	<form action="buy.jsp" method="POST">-->
<!--		<input type="submit" value="購入(カートへ)"><br>-->
<!--		<br>-->
<!--		</form>-->
	
<!--		名称購入数値段<br>-->
<!--		コンピュータ<input type="number" id="quantity" name="数量" min="1" max="10" value="1"> -->
<!--		\50,000 <input type="submit" value="カートへ追加"><br>-->
<!--		<br>-->
<!--		本<input type="number" id="quantity" name="数量" min="1" max="10" value="1"> -->
<!--		\1,000 <input type="submit" value="カートへ追加"><br>-->
<!--		<br>-->
<!--		ケータイ<input type="number" id="quantity" name="数量" min="1" max="10" value="1"> -->
<!--		\40,000 <input type="submit" value="カートへ追加"><br>-->
<!--		<br>-->
<!--		イヤホン<input type="number" id="quantity" name="数量" min="1" max="10" value="1"> -->
<!--		\30,000 <input type="submit" value="カートへ追加"><br>-->
<!--		<br>-->
<!--		音楽ＣＤ<input type="number" id="quantity" name="数量" min="1" max="10" value="1"> -->
<!--		\2,500 <input type="submit" value="カートへ追加">-->
<!--	loginのサーブレットから持ってくる。こっちではget-->

</body>
</html>