<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/header.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/login.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <title>HealthCare | Health and Fitness News, Recipes, Natural Remedies </title>
</head>
<body>
<%@ include file="header.jsp" %>
<br><br>
<h1>
	로그인 
</h1>
<!-- jsp에서 컨트롤러로 데이터를 전달하려면 form태그를 이용 -->
<form method="post" action="<%=request.getContextPath() %>/login" class="myform">   <%-- c:if는 조건식(test)이 참일경우 실행하는 문법 --%>
	<div class="imgcontainer">
    	<img src="<%=request.getContextPath()%>/resources/img/image.jpg" alt="Avatar" class="avatar">
    </div>
    
	<div class="mylogincontainer">
		<!-- 전달하려는 데이터가 있는 태그의 속성name을 입력한다. -->
		<label for="id"><b>ID</b></label>
		<input type="text" placeholder="아이디를 입력해주세요" name="id" class="mytext" required><br>
		
		<label for="pw"><b>Password</b></label>
		<input type="password" placeholder="비밀번호를 입력해주세요" name="pw" class="mypassword" required><br>
		<button class="btn btn-primary">로그인</button>
<%-- 	    <c:if test="${user == null}"><scan>회원정보가 존재하지 않습니다.</scan></c:if> --%>
	</div>
</form>
</body>
</html>
