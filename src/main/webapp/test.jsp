<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.entity.ItemBean" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>購入画面</title>
</head>
<body>
    <h1>購入確認</h1>
    
    <% 
        // セッションからカートリストを取得
        List<ItemBean> cartList = (List<ItemBean>) session.getAttribute("cartList");
        
        if (cartList != null && !cartList.isEmpty()) {
    %>
    <table border="1">
        <tr>
            <th>商品名</th>
            <th>購入数</th>
            <th>価格</th>
            <th>小計</th>
        </tr>
        <% 
            int total = 0;
            for (ItemBean item : cartList) {
                int subtotal = item.getPrice() * item.getAmount();
                total += subtotal;
        %>
        <tr>
            <td><%= item.getItemName() %></td>
            <td><%= item.getAmount() %></td>
            <td><%= item.getPrice() %></td>
            <td><%= subtotal %></td>
        </tr>
        <% } %>
    </table>
    <br>
    <p>合計金額: <%= total %>円</p>
    
    <form action="purchaseServlet" method="POST">
        <input type="submit" value="購入する">
    </form>
    <% 
        } else {
    %>
    <p>カートは空です。</p>
    <% 
        }
    %>
    <form action="itemList.jsp" method="POST">
    	<input type="submit" value="商品ページに戻る">
    </form>
</body>
</html>