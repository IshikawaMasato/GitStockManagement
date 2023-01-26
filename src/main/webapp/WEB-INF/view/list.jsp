<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dto.StockManagement" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>一覧</h2>
	
	<table border="1">
		<tr>
			<th>ID</th>
			<th>名前</th>
			<th>カテゴリ</th>
			<th>値段</th>
			<th>詳細</th>
		</tr>
	<%
	List<StockManagement> list = (ArrayList<StockManagement>)request.getAttribute("list");
	for(StockManagement s : list) {
	%>
		<tr>
			<td><%=s.getStockId() %></td>
			<td><%=s.getStockName() %></td>
			<td><%=s.getStockCategory() %></td>
			<td><%=s.getStockPrice() %></td>
			<td><%=s.getStockNote() %></td>
		</tr>
	<%} %>
	</table>
</body>
</html>