<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アカウント登録完了</title>

<!--CSSのファイルを読み込み-->
<link rel="stylesheet" type="text/css" href="./css/entry.css">

</head>
<body>
	<div class = "entry_Main">
		<h1>アカウント登録完了</h1>
		<jsp:useBean id="user" scope="request" class="model.entity.UserBean"/>
		<p>ユーザー名：<jsp:getProperty name="user" property="userName"/></p>
		<p>パスワード：<jsp:getProperty name="user" property="password"/></p>
		<p>メールアドレス：<jsp:getProperty name="user" property="mailAddres"/></p>
		<p>残高：<jsp:getProperty name="user" property="money"/></p>
		<form action="top.jsp" method="post">
		<input type="submit" value="TOPページに戻る">
		</form>
	</div>
</body>
</html>