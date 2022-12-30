<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-12-30
  Time: 오전 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>아이디 저장</title>
</head>
<body>
<form action="Login.jsp" id="Loginform">
  아이디<input type="text" id="id" name="id" required="required"><br>
  <input type="checkbox" value="check" id="idsave"/>아이디 저장<br>
  <input type="submit" value="로그인"/>
</form>
</body>
<script>
  let idsave = document.getElementById("idsave");
  let ids = document.getElementById("id");
  let loginform = document.getElementById("Loginform");

  // 처음 로딩될 떄 ids 존재 여부 확인
  window.addEventListener("load", (e)=>{
    if(typeof localStorage.ids !== "undefined"){
        ids.value = localStorage.ids;
        idsave.checked = true;
    }
  })
  // 폼의 데이터 전송할 때 확인
  loginform.addEventListener("submit", (e)=>{
    if(idsave.checked === true){
      localStorage.ids = ids.value;
    }else{
      localStorage.clear();
    }
  });
</script>
</html>
