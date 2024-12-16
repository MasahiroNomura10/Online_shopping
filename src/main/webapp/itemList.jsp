<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.entity.ItemBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品一覧画面</title>
</head>
<body>
	<h1>商品一覧</h1>
	
<!--	ログアウトし、トップ画面（ログイン画面）へ-->
	<form action="top.jsp" method="GET">
		<input type="submit" value="ログアウト"><br>
		<br>
	</form>
		
<!--		カートへ追加したら購入画面へ-->
	<form action="buy.jsp" method="POST">
		<input type="submit" value="購入(カートへ)"><br>
		<br>
		</form>

		<%
			List<ItemBean> itemList 
				= (List<ItemBean>) session.getAttribute("itemList");
		%>
		<form action="add-cart-servlet" method="GET">
		<table>
				<tr>
					<th>名称</th>
					<th>購入数</th>
					<th>値段</th>
				</tr>
				<%for (ItemBean item:itemList) { %>
				<tr>
					<td><%= item.getItemName() %></td>
					
					<td><input type="number" name="amount" min="0" max="<%= item.getStock() %>" value="0"></td>
					<td><%= item.getPrice() %></td>
					<td>
						<input type="hidden" name="itemId" value="<%= item.getItemId() %>">
						<input type="submit" value="カートに追加">
		
					</td>
				</tr>
				
				<%
						}
				%>
		</table>
		</form>
</body>
</html>