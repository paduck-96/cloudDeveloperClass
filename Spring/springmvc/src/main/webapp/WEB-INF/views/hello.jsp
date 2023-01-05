
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- jstl 사용을 위한 태그 라이브러리 설정 : JSP 에서만 사용 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Link 는 파일의 위치 기준이 아니고 URL 기준 -->
<link rel="stylesheet" href="./css/style.css"/>
</head>
<body>
	<div align="center" class="body">
		<h2>상품 목록</h2>
		<table border="1">
			<tr class="header">
				<th align="center" width="80">상품 아이디</th>
				<th align="center" width="320">상품 이름</th>
				<th align="center" width="100">가격</th>
			</tr>
			<c:forEach var="item" items="${result}">
				<tr class="record">
					<td align="center" width="80">${item.itemid}</td>
					<td align="center" width="320">${item.itemname}</td>
					<td align="center" width="100">${item.price}원</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>