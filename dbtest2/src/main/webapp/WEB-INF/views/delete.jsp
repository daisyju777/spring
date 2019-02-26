<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>delete.jsp</title>
</head>
<body>
<h2>정보삭제</h2>
<form method="get">
  삭제할 아이디 <input type="text" name="search" />
  <input type="submit" value="검색" />
</form>
<hr/>
<c:forEach var="str" items="${search}">
  <form method="post">
      아이디 : ${str.id} <br/> 
      비밀번호 : ${str.pwd}<br/>
      고유번호 : ${str.idx}<br/>
    <input type="submit" value="삭제하기" /><br/>
    <input type="hidden" name="id" value="${str.id}" />
    <input type="hidden" name="pwd" value="${str.pwd}" />
  </form>
  <hr/>
</c:forEach> 
<hr/>
<p><a href="<%=request.getContextPath() %>/">돌아가기</a></p>
</body>
</html>