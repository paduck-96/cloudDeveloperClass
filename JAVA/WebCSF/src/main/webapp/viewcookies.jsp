<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-12-30
  Time: 오전 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
  // 모든 쿠키 가져오기
  Cookie [] cookies = request.getCookies();
  for(Cookie cookie : cookies){
      String value = java.net.URLDecoder.decode(cookie.getValue(),"UTF-8");
%>
<%=cookie.getName()%> : <%=value%><br>
<%
  }
%>
<script>
    // 모든 쿠키 읽기
    let cookieData = document.cookie;
    let start = cookieData.indexOf("nickname");
    let cValue = '';
    if(start!=-1){
        start+="nickname".length;
        let end = cookieData.indexOf(";",start);
        if(end===-1){
            end=cookieData.length;
        }
        console.log(decodeURI(cookieData.substring(start,end)));
    }else{
        console.log("존재하지 않은 쿠키");
    }
</script>
</body>
</html>
