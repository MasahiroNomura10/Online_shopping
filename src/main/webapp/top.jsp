<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>topページ</title>

<!--CSSのファイルを読み込み-->
<link rel="stylesheet" type="text/css" href="./css/top.css">

</head>
<body>
	<h1>ログイン画面</h1>
	<div class="main">
		<div class="content">
			<form action="loginservlet" method="post" class="login">
			ユーザー名：<input type="text" name="userName"><br>
			パスワード：<input type="password" name="password"><br><br>
				
			<input type="submit" value="ログイン">
			</form>
		</div>
			
		<div class="button">	
			<form action="acountCreate.jsp" method="post" class="create">
			<input type="submit" value="アカウント登録はこちら">
			</form>
		</div>
	</div>
		
		
</body>
</html>