<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/header.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/register.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <title>HealthCare | Health and Fitness News, Recipes, Natural Remedies </title>
</head>
<body>
<%@ include file="../header.jsp" %>

<div class="container">
     <h1>게시판</h1>
     <hr>
	<label for="title">제목:</label>
	<input type="text" class="form-control" id="title" name="title" readonly value="${board.title}">

	<label for="writer">작성자:</label>
	<input type="text" class="form-control" id="writer" name="writer" readonly value="${board.writer}">

	<label for="content">내용:</label>
	<textarea class="form-control" id="content" name="content" readonly>${board.content}</textarea>

	<a href="<%=request.getContextPath() %>/bbs/list?page=${cri.page}&search=${cri.search}&type=${cri.type}">
		<button class="btn btn-outline-primary registerbtn">목록</button>
	</a>
	<c:if test="${user.id == board.writer || user.authority.equals('admin')}">   <!-- 여기서 user은 session에 저장된 유저정보임. -->
		<a href="<%=request.getContextPath() %>/bbs/delete?id=${board.id}">
			<button class="btn btn-outline-primary registerbtn deletebtn">삭제</button>
		</a>
	</c:if>
	<c:if test="${user.id == board.writer}">
		<a href="<%=request.getContextPath() %>/bbs/modify?id=${board.id}">
			<button class="btn btn-outline-primary registerbtn">수정</button>
		</a>
	</c:if>
</div>
<script>
$(document).ready(function(){
  $(".deletebtn").click(function(){
    var msg = confirm("삭제하시겠습니까? ");
    if (msg == false) {
      return false;
    }
  });
});
</script>
</body>
</html>