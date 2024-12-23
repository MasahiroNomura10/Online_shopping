<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>購入完了画面</title>

<!--CSSのファイルを読み込み-->
<link rel="stylesheet" type="text/css" href="./css/purchaseDecision.css">

</head>

<body>

	
	<div class ="main_Text">

		<p class = "inner_Text">購入が完了しました。</p>
		
		
		<form action = "itemList.jsp" method = "POST">
		
			<input type = "submit" value = "商品一覧に戻る" class = "return_Button">
			
		</form>
	</div>

</body>




</html>