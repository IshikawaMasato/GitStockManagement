<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.StockManagement" %>
<%@ page import="dao.StockManagementDao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>削除するStickidを入力してください。</h1>
	<form action="DeleteStockServlet" method="get">
	<div class="delete">
	Stockid:<input type="text" name="stockid">
	 <input type="submit" value="送信">
	 </div>
	 </form>
	 <div class="botan">
	 <div class="right">
	 <a href="./">メニューへ戻る</a>
	 </div>
	 </div>
</body>
</html>