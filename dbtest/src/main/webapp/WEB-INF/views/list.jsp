<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list.jsp</title>
</head>
<body>
<h2>전체 리스트</h2>
<c:forEach var="i" items="${list}">
	<p>아이디 : ${i.id} / 비밀번호 : ${i.pwd}</p>
</c:forEach>
<p><a href="<%=request.getContextPath() %>/">돌아가기</a></p>
</body>
</html>