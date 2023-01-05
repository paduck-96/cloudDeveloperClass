<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring MVC</title>
</head>
<body>
<a href="hello">안녕으로 이동</a><br>
<a href="message/detail/11">URL 포함 매개변수 확인</a>
<a href="redirect">리다이렉트 이동</a>

<form action="param1">
	이름:<input type="text" name="name" /><br>
	비번:<input type="password" name="password" /><br>
	<input type="submit" value="전송" />
</form>
<form action="param2" method="post">
	이름:<input type="text" name="name" /><br>
	비번:<input type="password" name="password" /><br>
	<input type="submit" value="전송" />
</form>
<form action="param3" method="post">
	이름:<input type="text" name="name" /><br>
	비번:<input type="password" name="password" /><br>
	<input type="submit" value="전송" />
</form>
</body>
</html>