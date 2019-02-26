<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update.jsp</title>
</head>
<body>
<h2>정보수정</h2>
<form method="get">
  검색할 아이디 <input type="text" name="search" />
  <input type="submit" value="검색" />
</form>
<hr/
>
<c:forEach var="str" items="${search}">
  <form method="post">
      아이디 : ${str.id} <br/> 
      비밀번호 : <input type="password" name="pwd" value="${str.pwd}"/><br/>
      고유번호 : ${str.idx}<br/>
    <input type="submit" value="수정하기" /><br/>
    <input type="hidden" name="id" value="${str.id}" />
  </form>
  <hr/>
</c:forEach> 
<hr/>
<p><a href="<%=request.getContextPath() %>/">돌아가기</a></p>
</body>
</html>