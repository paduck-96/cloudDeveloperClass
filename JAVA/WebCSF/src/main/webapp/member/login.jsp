<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-12-30
  Time: 오후 3:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인 페이지</title>
</head>
<body>
<%
    String error = request.getParameter("error");
    if(error!=null){
%>
<div>아이디 나 비밀번호 가 틀렸습니다</div>
<%
    }
%>
<form method="post">
  아이디<input type="text" name="mid"/><br>
  비밀번호<input type="password" name="mpw"/><br>
    자동 로그인<input type="checkbox" name="auto"/><br>
  <input type="submit" value="로그인"/>
</form>
</body>
</html>
