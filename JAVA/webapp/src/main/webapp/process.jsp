<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-12-29
  Time: 오후 3:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  //파라미터를 읽기
  String first = request.getParameter("first");
  String second = request.getParameter("second");

  // 처리 수행
  int result = Integer.parseInt(first)+Integer.parseInt(second);

  // 결과 저장
  request.setAttribute("result", result);
  session.setAttribute("result", result);
  application.setAttribute("result", result);

  // 결과 페이지 설정
  System.out.println("처리 페이지");

  // 포워딩
  //request.getRequestDispatcher("output.jsp").forward(request, response);

  //리다이렉트
  response.sendRedirect("output.jsp");
%>