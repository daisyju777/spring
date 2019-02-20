<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>search.jsp</title>
</head>
<body>
<h2>개별검색</h2>
<form method="get">
  검색할 아이디 <input type="text" name="search" />
  <input type="submit" value="검색" />
</form>
<c:forEach var="str" items="${search}">
  아이디 : ${str.id} / 비밀번호 : ${str.pwd}<br/>
</c:forEach>
<p><a href="<%=request.getContextPath() %>/">돌아가기</a></p>
</body>
</html>