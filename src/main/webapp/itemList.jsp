<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品一覧画面</title>
</head>
<body>
	<h1>商品一覧</h1>
	
<!--	ログアウトし、トップ画面（ログイン画面）へ-->
	<form action="Top.jsp" method="POST">
		<input type="submit" value="ログアウト"><br>
		<br>
	</form>
		
		
<!--		カートへ追加したら購入画面へ-->
	<form action="buy.jsp" method="POST">
		<input type="submit" value="購入(カートへ)"><br>
		<br>
		</form>
	
		名称購入数値段<br>
		コンピュータ<input type="number" id="quantity" name="数量" min="1" max="10" value="1"> 
		\50,000 <input type="submit" value="カートへ追加"><br>
		<br>
		本<input type="number" id="quantity" name="数量" min="1" max="10" value="1"> 
		\1,000 <input type="submit" value="カートへ追加"><br>
		<br>
		ケータイ<input type="number" id="quantity" name="数量" min="1" max="10" value="1"> 
		\40,000 <input type="submit" value="カートへ追加"><br>
		<br>
		イヤホン<input type="number" id="quantity" name="数量" min="1" max="10" value="1"> 
		\30,000 <input type="submit" value="カートへ追加"><br>
		<br>
		音楽ＣＤ<input type="number" id="quantity" name="数量" min="1" max="10" value="1"> 
		\2,500 <input type="submit" value="カートへ追加">
	

</body>
</html>