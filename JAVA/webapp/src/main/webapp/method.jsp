<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-12-29
  Time: 오후 12:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    // web.xml 파일의 초기화 파라미터 읽어오기
    String user = application.getInitParameter("User");
%>
<%=user%>
<a href="res.jsp?name=park">GET 요청</a>
<div>
    <form method="post" action="res.jsp">
        별명: <input type="text" name="nickname" />
        <input type="submit" value="전송"/>
    </form>
    <%
        // 모든 헤더 정보 출력
        Enumeration <String> headerEnum = request.getHeaderNames();
        while(headerEnum.hasMoreElements()){
            String name = headerEnum.nextElement();
            String value = request.getHeader(name);
    %>
    <%=name %> : <%=value %><br/>
    <% }%>
</div>
</body>
</html>
