<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="insert" method="post">
<table border="1">
	<tr>
		<td colspan="2" style="text-align:center;front-size:30px;front-weight:bold;">
			花卉信息
		</td>
	</tr>
	<tr>
		<td><b>花卉名称：</b></td>
		<td><input type="text" name="name"/></td>
	</tr>
	<tr>
		<td><b>花卉价格：</b></td>
		<td><input type="text" name="price"/></td>
	</tr>
	<tr>
		<td><b>花卉产地：</b></td>
		<td><input type="text" name="production"/></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="提交" /><input type="reset" value="重置"/>
		</td>
	</tr>
	
</table>
</form>
</body>
</html>