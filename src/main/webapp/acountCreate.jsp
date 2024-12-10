<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>アカウント登録画面</h1>
	<form action="acountCreateServlet" method="POST">
	ユーザーネーム：<input type="text" name="userName"><br>
	パスワード：<input type="text" name="password"><br>
	メールアドレス：<input type="text" name="mailAddres"><br>
	残高：<input type="number" name="money"><br><br>
	<input type="submit" value="アカウント登録">
	</form>
</body>
</html>