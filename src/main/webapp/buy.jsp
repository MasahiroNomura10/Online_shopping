<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入画面</title>
</head>
<body>
	<h1>購入画面</h1>
	カートの中身<br>
	名称　個数　値段
	
	カートに入れたもの　個数　値段　のデータ
	<br>
	小計　カート内の商品の合計
	
	<form action="purchaseDecision.jsp" method="POST">
	<form action="purchaseFailure.jsp" method="POST">
		<input type="submit" value="購入">
		<br>
	</form>	
	
	
	<form action="itemList.jsp" method="POST">
	<input type="submit" value="商品ページに戻る">
	</form>
	 
	
	
	
	

</body>
</html>