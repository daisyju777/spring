<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<title>회원가입</title>
</head>
<body>
	<h1>회원가입</h1>
	<form method="post" action="<%=request.getContextPath()%>/signup">
		<div>
			<input type="text" name="id">
		</div>
		<div>
			<input type="password" name="pw">
		</div>
		<div>
			<input type="email" name="email">
		</div>
		<div>
			<input type="radio" value="male" name="gender" id="male" checked>
			<label for="male">남성</label>
			<input type="radio" value="male" name="gender" id="female" checked>
			<label for="female">여성</label>
		</div>
		<button>회원가입</button>
	</form>
	<script>
	var check = ${fail};
	if(check==true)
		alert("중복된 아이디입니다.");
	</script>
</body>
</html>
