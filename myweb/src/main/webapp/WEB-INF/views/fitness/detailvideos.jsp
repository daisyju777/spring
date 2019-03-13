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
<%@ include file="../header.jsp" %>
 <div class="box">
	 <div class="left-box">
		<h1 class="newstitle">
			<scan style="color:rgb(217,83,79);">FITNESS</scan> VIDEOS
			<a href="<%=request.getContextPath()%>/fitness/videos"><button class="btn btn-primary btn-sm mynewsbutton">목록</button></a>
		</h1>
		<div class="newsbox">
			<h2>${topic.title}</h2>
			<%-- <img src="<%=request.getContextPath()%>/resources/img${topic.file}" class="detailnewsimg"> --%>
			<div>
				${topic.content}
			</div>
		</div>
	</div>
	<div class="right-box">
		<img src="<%=request.getContextPath()%>/resources/img/ads.jpg">
	</div>
 </div>
<script>
$(document).ready(function(){
  $("iframe").css("width",670);
});
</script>
</body>
</html>