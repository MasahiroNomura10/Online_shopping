<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.entity.ItemBean" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
<meta charset="UTF-8">
<title>商品一覧画面</title>

<!--CSSのファイルを読み込み-->
<link rel="stylesheet" type="text/css" href="./css/itemList.css">

</head>
<body>
	<h1>商品一覧</h1>
	
	<div class="content">
	<form action="logoutServlet" method="POST" class="logout">
		<input type="submit" value="ログアウト"><br><br>
	</form>
		
	<form action="test.jsp" method="POST" class="buy">
		<button class="btn">
		<i class="bi bi-cart"></i>
		</button>
<!--		<input type="submit" value="購入(カートへ)">-->
	</form>

	<%
		List<ItemBean> itemList = (List<ItemBean>) session.getAttribute("itemList");
	%>
	
	
		<table class="itemList">
			<tr>
				<th>名称</th>
				<th>価格</th>
				<th>購入数</th>
			</tr>
			<% for (ItemBean item : itemList) { %>
			
				<tr>
					<td><%= item.getItemName() %></td>
					
					<td><%= item.getPrice() %></td>
					<td>
					<form action="add-cart-servlet" method="POST">
						<input type="number" name="amount" min="0" max="<%= item.getStock() %>" value="0">
						<input type="hidden" name="itemId" value="<%= item.getItemId() %>">
						<input type="submit" value="カートに追加">
					</form>
					</td>
				</tr>
			
			<% } %>
			
		</table>
	</div>
</body>
</html>
