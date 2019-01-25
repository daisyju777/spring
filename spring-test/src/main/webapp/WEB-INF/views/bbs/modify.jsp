<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/register.css">
</head>
<body>
<h2>게시글 수정</h2>
<p>게시글 수정 페이지입니다.</p>
<hr>
<form action="<%=request.getContextPath()%>/bbs/modify" method="post">
	<div class="container">
		<input type="hidden" value="${board.id}" name="id">
	
		<label for="title">제목:</label>
		<input type="text" class="form-control" id="title" name="title" value="${board.title}" required>
		
		<label for="writer">작성자:</label>
		<input type="text" class="form-control" id="writer" name="writer" readonly value="${board.writer}"> <!-- user정보를 세션에 저장했기때문에 바로 사용 가능 -->
	
		<label for="content">내용:</label>
		<textarea class="form-control" id="content" name="content" required>${board.content}</textarea>
		
		<button class="btn btn-outline-primary registerbtn">완료</button>
	</div>
</form>
</body>
</html>