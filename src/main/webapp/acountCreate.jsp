<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!--CSSのファイルを読み込み-->
<link rel="stylesheet" type="text/css" href="./css/acountCreate.css">

</head>
<body>
	<div class = "acountCreate_Main">
		<h1>アカウント登録画面</h1>
		<form action="acountCreateServlet" method="POST">
			<div class = "itemBox">
				<div class = "item">ユーザーネーム　：</div><input type="text" name="userName" required>
			</div>

			<br>
			
			<div class = "itemBox">			
				<div class = "item">パスワード　　　：</div><input type="password" name="password" required>
			</div>

			<br>
			
			<div class = "itemBox">
				<div class = "item">メールアドレス　：</div><input type="text" name="mailAddres" required>
			</div>
			
			<br>
			
			<div class = "itemBox">
				<div class = "item">残高　　　　　　：</div><input type="number" name="money" min="1" required>
			</div>
			
			<br><br>
			
			<input type="submit" value="アカウント登録" class = "button">
		
		</form>
	</div>
</body>
</html>