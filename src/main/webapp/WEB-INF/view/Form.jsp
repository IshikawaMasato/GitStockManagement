<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>商品登録</h3>
	<form action="StockRegisterExecuteServlet" method="post">
		商品ID：<input type="text" name="StockId"><br>
		商品名：<input type="text" name="StockName"><br>
		商品カテゴリー：<select name="StockCategory">
		<option value="食品">食品</option>
		<option value="お酒">お酒</option>
		<option value="おもちゃ">おもちゃ</option>
		<option value="ファッション">ファッション</option>
		<option value="家電">家電</option>
		<option value="	日用品">日用品</option>
		<option value="	その他">その他</option>
		</select>
		<br>
		商品価格：<input type="text" name="StockPrice"><br>
		商品詳細：<br>
		<textarea name="StockNote" rows="10" cols="50" placeholder="内容を入力"></textarea><br>
		<input type="submit" value="登録"class="botan">
	
	</form>
</body>
</html>