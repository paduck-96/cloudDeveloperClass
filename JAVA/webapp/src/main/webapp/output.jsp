<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-12-29
  Time: 오후 3:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>결과</title>
</head>
<body>
request 객체 : <%=request.getAttribute("result")%><br>
session 객체 : <%=session.getAttribute("result")%><br>
application 객체 : <%=application.getAttribute("result")%><br>
</body>
</html>
