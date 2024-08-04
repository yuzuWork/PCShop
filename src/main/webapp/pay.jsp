<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Product"%>
<%@ page import="model.Cart"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>精算完了</title>
<link rel="stylesheet" href="style.css?v=1.0">
</head>
<body>
	<%@include file = "header-navi.jsp" %>
	
	<h2>精算完了</h2>
	
	<p>お買い上げありがとうございました。</p>
	
	<%
		List<Product> listProd;
		Cart payData = (Cart) session.getAttribute("pay");
		if(payData == null){
			listProd = new ArrayList<Product>();
		}else{
			listProd = payData.getListProd();
		}
		if (listProd.size() > 0){
	%>
			<table class="pay-list">
			<tr>
				<th>商品ID</th><th>商品名</th><th>価格</th>
			</tr>
	<%
			for (int i = 0; i < listProd.size(); i++){
				Product prod = listProd.get(i);
	%>
				<tr>
					<td><%=prod.getId() %></td>
					<td><%=prod.getName() %></td>
					<td><%=prod.getPriceString() %></td>
				</tr>
	<%
			}
	%>
			</table>
			<br>
			<p>合計：<%=payData.getTotalPriceString() %>になります</p>
	<%
			session.removeAttribute("pay");
		}
	%>
	
</body>
</html>