<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<table border ='1'>
		<tr>
			<th>编号</th>
			<th>名称</th>
			<th>价格</th>
			<th>产地</th>
		</tr>
		<c:forEach items="${list }" var="flower">
		<tr>
			<td>${flower.id }</td>
			<td>${flower.name }</td>
			<td>${flower.price }</td>
			<td>${flower.production }</td>
		</tr>
		</c:forEach>
	</table>
	<a href="add.jsp">添加</a>
</body>
</html>