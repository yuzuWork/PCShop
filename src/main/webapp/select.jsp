<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Product"%>
<%@ page import="model.Store"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品選択</title>
<link rel="stylesheet" href="style.css?v=1.0">
</head>
<body>
	<%@include file = "header-navi.jsp" %>
	
	<%
		List<Product> listProd;
		Store store = (Store) session.getAttribute("store");
		if(store == null){
			listProd = new ArrayList<Product>();
		}else{
			listProd = store.getListProd();
		}
		if (listProd.size() > 0){
	%>
			<h2>商品選択</h2>
			
			<table class="select-list">
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
						<form action="add-prod-servlet" method="post">
							<input type="hidden" name="idx" value=<%=i %>>
							<input type="submit" value="カート追加">
						</form>
					</td>
				</tr>
	<%
			}
	%>
			</table>
	<%
		}
	%>
</body>
</html>