<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>購入エラー画面</title>

</head>

<body>

<h1>購入エラー</h1>

<!--エラーメッセージ表示-->
<% String message = (String) request.getAttribute("erromessage"); %>

<p><% = message  %></p><br>


<form action = "itemList.jsp" method = "POST">
	<input type = "submit" value = "商品ページに戻る">
</form>


</body>



</html>