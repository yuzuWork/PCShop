<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Product"%>
<%@ page import="model.Cart"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カート内一覧</title>
<link rel="stylesheet" href="style.css?v=1.0">
</head>
<body>
	<%@include file = "header-navi.jsp" %>
	
	<h2>カート内一覧</h2>
	
	<%
		List<Product> listProd;
		Cart cart = (Cart) session.getAttribute("cart");
		if(cart == null){
			listProd = new ArrayList<Product>();
		}else{
			listProd = cart.getListProd();
		}
		if (listProd.size() > 0){
	%>
			<table class="cart-list">
			<tr>
				<th>商品ID</th><th>商品名</th><th>価格</th><th></th>
			</tr>
	<%
			for (int i = 0; i < listProd.size(); i++){
				Product prod = listProd.get(i);
	%>
				<tr>
					<td><%=prod.getId() %></td>
					<td><%=prod.getName() %></td>
					<td><%=prod.getPriceString() %></td>
					<td>
						<form action="remove-prod-servlet" method="post">
							<input type="hidden" name="idx" value="<%=i%>">
							<input type="submit" value="削除">
						</form>
					</td>
				</tr>
	<%
			}
	%>
			</table>
			<br>
			<form action="pay-servlet" method="post">
				<input type="submit" value="精算">
			</form>
	<%
		}else{
	%>
			<p>カートの中は空です。</p>
	<%
		}
	%>
</body>
</html>