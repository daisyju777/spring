<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/header.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/register.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <title>HealthCare | Health and Fitness News, Recipes, Natural Remedies </title>
</head>
<body>
<%@ include file="../header.jsp" %>
<form action="<%=request.getContextPath()%>/bbs/register" method="post">
	<div class="container">
	 <h1>게시판</h1>
     <hr>
		<label for="title">제목:</label>
		<input type="text" class="form-control" id="title" name="title" required>
		
		<label for="writer">작성자:</label>
		<input type="text" class="form-control" id="writer" name="writer" readonly value="${user.id}"> <!-- user정보를 세션에 저장했기때문에 바로 사용 가능 -->
	
		<label for="content">내용:</label>
		<textarea class="form-control" id="content" name="content" required ></textarea>
		
		<button class="btn btn-outline-primary registerbtn">등록</button>
	</div>
</form>
</body>
</html>