<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/register.css">
</head>
<body>
<h2>게시글 등록</h2>
<p>게시글 등록 페이지입니다.</p>
<hr>
<form action="<%=request.getContextPath()%>/bbs/register" method="post">
	<div class="container">
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