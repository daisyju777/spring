<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<title>Home</title>
	<%-- 
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/bootstrap.css">
	--%>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/home.css">
</head>
<body>
<h1>
	Hello world!  
</h1>
<!-- jsp에서 컨트롤러로 데이터를 전달하려면 form태그를 이용 -->
<form method="post" action="<%=request.getContextPath() %>/" 
style="<c:if test="${user != null}">display:none;</c:if>">   <%-- c:if는 조건식(test)이 참일경우 실행하는 문법 --%>
	<div class="imgcontainer">
    	<img src="<%=request.getContextPath()%>/resources/img/image.jpg" alt="Avatar" class="avatar">
    </div>
    
	<div class="container">
		<!-- 전달하려는 데이터가 있는 태그의 속성name을 입력한다. -->
		<label for="id"><b>ID</b></label>
		<input type="text" placeholder="아이디를 입력해주세요" name="id" required><br>
		
		<label for="pw"><b>Password</b></label>
		<input type="password" placeholder="비밀번호를 입력해주세요" name="pw" required><br>
		<button class="btn btn-primary">로그인</button>
	</div>
</form>
<a href="<%=request.getContextPath() %>/signup" class="join">회원가입</a>
</body>
</html>
