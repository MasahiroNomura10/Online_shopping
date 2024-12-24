<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アカウント登録エラー</title>
<!--CSSのファイルを読み込み-->
<link rel="stylesheet" type="text/css" href="./css/acountCreateFailure.css">
</head>
<body>
	<h1>アカウント登録エラー</h1>
	
	<%String message =(String) request.getAttribute("errormessage"); %>
		<p><%=message %></p><br>
	<form action="top.jsp"method="post">
	<input type="submit" value="TOPページに戻る">
	</form>
</body>
</html>
