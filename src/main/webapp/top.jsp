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
	<form action="loginservlet" method="post">
	ユーザー名：<input type="text" name="userName"><br>
	パスワード：<input type="password" name="password"><br><br>
	
	<input type="submit" value="ログイン">
	</form>
	
	<form action="acountCreate.jsp" method="post">
	<input type="submit" value="アカウント登録はこちら">
	</form>
	
</body>
</html>