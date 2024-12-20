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
	ユーザーネーム：<input type="text" name="userName" required><br>
	パスワード：<input type="password" name="password" required><br>
	メールアドレス：<input type="text" name="mailAddres" required><br>
	残高：<input type="number" name="money" required><br><br>
	<input type="submit" value="アカウント登録">
	</form>
</body>
</html>