<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>자바 웹 프로그래밍</title>
</head>
<body>

<h1>쿠키 와 세션에 대한 학습</h1>
<a href="createcookie.jsp">생성 이동</a>
<a href="deletecookie.jsp">삭제 이동</a>
<a href="idsave.jsp">아이디 저장</a>

<h1>프로젝트 구조 실습</h1>
<%
    Object loginInfo = session.getAttribute("logininfo");
    if(loginInfo == null){
%>
<a href="login">로그인</a>
<%--<%--%>
<%--    }else{--%>
<%--        dto.MemberDTO dto = (dto.MemberDTO)loginInfo;--%>
<%--%>--%>
<%--<%=dto.getMname() %> 님 환영합니다<br>--%>
<%--<a href="logout">로그아웃</a>--%>
<%
    }
%>
</body>
</html>