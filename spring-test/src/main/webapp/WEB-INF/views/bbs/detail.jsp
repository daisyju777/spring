<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/register.css">
</head>
<body>
<h2>게시글 상세</h2>
<p>게시글 상세 페이지입니다.</p>
<hr>
<div class="container">
	<label for="title">제목:</label>
	<input type="text" class="form-control" id="title" name="title" readonly value="${board.title}">

	<label for="writer">작성자:</label>
	<input type="text" class="form-control" id="writer" name="writer" readonly value="${board.writer}">

	<label for="content">내용:</label>
	<textarea class="form-control" id="content" name="content" readonly>${board.content}</textarea>

	<a href="<%=request.getContextPath() %>/bbs/list">
		<button class="btn btn-outline-primary registerbtn">목록</button>
	</a>
	<c:if test="${user.id == board.writer}">
		<a href="<%=request.getContextPath() %>/bbs/delete?id=${board.id}">
			<button class="btn btn-outline-primary registerbtn">삭제</button>
		</a>
	</c:if>
	<c:if test="${user.id == board.writer}">
		<a href="<%=request.getContextPath() %>/bbs/modify?id=${board.id}">
			<button class="btn btn-outline-primary registerbtn">수정</button>
		</a>
	</c:if>
</div>
</body>
</html>