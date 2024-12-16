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
	<form action="purchaseServlet" method="POST">
		<input type="submit" value="購入(カートへ)"><br>
		<br>
		</form>

		
		<form action="add-cart-servlet" method="GET">
		<%
			List<ItemBean> cartList 
				= (List<ItemBean>) session.getAttribute("cartList");
		if (cartList != null && !cartList.isEmpty()) {
		%>
		<table>
				<tr>
					<th>名称</th>
					<th>購入数</th>
					<th>値段</th>
					<th>小計</th>
				</tr>
				<%for (ItemBean item : cartList) { %>
				<tr>
        <td><%= item.getItemName() %></td>
        <td><%= item.getAmount() %></td>
        <td><%= item.getPrice() %></td>
        <td><%= item.getPrice() * item.getAmount() %></td>
    </tr>
    <% } %>
</table>
<%
    } else {
%>
<p>カートは空です。</p>
<%
    }
%>
		</form>
</body>
</html>