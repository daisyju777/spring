<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta http-equiv="X-UA-Compatible" content="ie=edge">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
		<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/header.css">
		<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/hottopics.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
		<title>HealthCare | Health and Fitness News, Recipes, Natural Remedies </title>
</head>
<body>
<form action="<%=request.getContextPath()%>/admin/fitness/videos/modify" method="post" enctype="multipart/form-data">
	<div class="container">
	 <h1>글수정하기</h1>
     <hr>
     	<input type="hidden" value="${topic.id}" name="id">
     	
		<label for="title">제목:</label>
		<input type="text" class="form-control" id="title" name="title" value="${topic.title}" required>
	
		<label for="content">내용:</label>
		<textarea class="form-control" id="content" name="content" required >${topic.content}</textarea>
		
		<label for="title">파일:</label>
		<input type="file" class="form-control" id="file" name="files">
		<br>
		<button class="btn btn-outline-primary registerbtn">등록</button>
	</div>
</form>

</body>
</html>