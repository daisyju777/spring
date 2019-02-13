<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>자료 입력처리</h1>
<form method="post">
	<p>아이디 : <input type="text" name="id" /></p>
	<p>비밀번호 : <input type="password" name="pwd" /></p>
	<p><input type="submit" value="입력" /></p>
</form> 
<P>가입한 아이디는 : ${id}</P>
<P>가입한 비밀번호는 : ${pwd}</P>
</body>
</html>
